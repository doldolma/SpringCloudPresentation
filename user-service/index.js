require('dotenv').config({filename: ".env"});

// 필요한 모듈 다운
const express = require('express');
const cors = require('cors');
const app = express();
const db = require('./models');
const { Grew } = require('./models');
const { Op } = require('sequelize');
const axios = require('axios');
const port = process.env.HTTP_PORT || 80;

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(
  cors({
    origin: '*',
    credentials: true,
  })
);

app.get('/', (_, res) => {
  return res.send("hey");
});

app.get('/searching', async (req, res) => {
  const { name, team } = req.query;
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
        grewInfo.letters = (await axios.get(`http://192.168.0.23:7894/letters/${id}`)).data;
      } catch(e) {
        grewInfo.letters = [];
      }
      return res.json(grewInfo);
    }
    else res.status(400).send('조건을 만족하는 분이 안 계십니다');
  } catch (err) {
    res.status(500).send('네트워크가 불안정합니다');
  }
});

app.get("/health", (_, res) => res.json({ status: "UP" }));

app.get('/grews', async (_, res) => res.json(await Grew.findAll()));

db.sequelize.sync();

app.listen(port, () => {
  console.log(`\t server listening on ${port}`);
});
