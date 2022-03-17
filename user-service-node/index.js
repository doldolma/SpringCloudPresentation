const dotenv = require('dotenv');
if (process.env.NODE_ENV === 'production') {
  dotenv.config({ path: '.env.production' });
} else dotenv.config({ path: '.env' });

// 필요한 모듈 다운
const express = require('express');
const cors = require('cors');
const app = express();
const db = require('./models');
const { Grew } = require('./models');
const { Op } = require('sequelize');
const axios = require('axios');
const morgan = require('morgan');
const Seed = require("./seeds");
const kafka = require("./kafka");
// const { zipkinMiddleware, tracer } = require("./zipkin");
const zipkin = require('zipkin');
const zipkinInstrumentationAxios = require("zipkin-instrumentation-axios");
const CLSContext = require('zipkin-context-cls');
const {recorder} = require('./recorder');
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;
const ctxImpl = new CLSContext('zipkin');
const localServiceName = 'user-service';

const port = process.env.HTTP_PORT || 80;


const tracer = new zipkin.Tracer({
  ctxImpl, // the in-process context
  recorder: recorder(localServiceName), // For easy debugging. You probably want to use an actual implementation, like Kafka or AWS SQS.
  sampler: new zipkin.sampler.CountingSampler(1), // sample rate 0.01 will sample 1 % of all incoming requests
  localServiceName // indicates this node in your service graph
});
const zipkinAxios = zipkinInstrumentationAxios(axios, { tracer, serviceName: `${localServiceName}-axios` });


app.use(morgan("combined"));
app.use(zipkinMiddleware({tracer}))
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cors());

app.use(express.static("public"));

app.get('/', (_, res) => {
  return res.sendFile("public/index.html");
});

app.get("/health", (_, res) => res.json({ status: "UP" }));

app.get('/searching', async (req, res) => {
  const { name, team } = req.query;
  console.log("search : ", req.query);
  try {
    let grewInfo;
    const nameCondition = [
      {
        name,
      },
      {
        nickname: name,
      },
      {
        nicknameEng: name,
      },
    ];
    if (name === 'all' && team === 'all') {
      grewInfo = await Grew.findAll({
        raw: true,
      });
    } else if (team === 'all' && name !== 'all') {
      grewInfo = await Grew.findAll({
        raw: true,
        where: {
          [Op.or]: nameCondition,
        },
      });
    } else if (team !== 'all' && name === 'all') {
      grewInfo = await Grew.findAll({
        raw: true,
        where: {
          belongsTo: team,
        },
      });
    } else {
      grewInfo = await Grew.findAll({
        raw: true,
        where: {
          [Op.or]: nameCondition,
          belongsTo: team,
        },
      });
    }

    if (!!grewInfo.length) {
      res.json(grewInfo);
    } else {
      res.status(400).send('조건을 만족하는 분이 안 계십니다');
    }
  } catch (err) {
    res.status(500).send('네트워크가 불안정합니다');
  }
});

app.get('/grew-person', async (req, res) => {
  const { id } = req.query;
  console.log(id);
  try {
    const grewInfo = await Grew.findOne({
      raw: true,
      where: {
        id,
      },
    });

    if (grewInfo) {
      try {
        grewInfo.letters = (await zipkinAxios.get(`${process.env.APIGATEWAY}/letter-service/letters/${id}`)).data;
      } catch(e) {
        console.log("err ", e);
        grewInfo.letters = [];
      }
      return res.json(grewInfo);
    }
    else res.status(400).send('조건을 만족하는 분이 안 계십니다');
  } catch (err) {
    console.log("err : ", err);
    res.status(500).send('네트워크가 불안정합니다');
  }
});

app.get("/health", (_, res) => res.json({ status: "UP" }));

app.get('/grews', async (_, res) => res.json(await Grew.findAll()));
app.get('/user-service/searching', async (_, res) => res.json(await Grew.findAll()));

app.listen(port,  async () => {
  await db.sequelize.sync();
  await Seed()
  console.log(`\t server listening on ${port}`);
  kafka();
});
