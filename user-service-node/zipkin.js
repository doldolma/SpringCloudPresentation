const { Tracer } = require('zipkin');
const { BatchRecorder } = require('zipkin');
const { HttpLogger } = require('zipkin-transport-http');
const CLSContext = require('zipkin-context-cls');

const ctxImpl = new CLSContext();

const recorder = new BatchRecorder({
  logger: new HttpLogger({
    endpoint: `${process.env.ZIPKIN_URL}`,
  })
});

const tracer = new Tracer({ ctxImpl, recorder });
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;


const fetch = require('node-fetch');
const wrapFetch = require('zipkin-instrumentation-fetch');
const zipkinFetch = wrapFetch(fetch, {
  tracer,
  serviceName: 'user-service'
});

module.exports = {
  zipkinMiddleware,
  tracer
}