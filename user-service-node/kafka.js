const { Grew } = require("./models");
const { Kafka, logLevel} = require("kafkajs");

const kafka = new Kafka({
  clientId: 'user-service',
  brokers: [process.env.KAFKA_HOST],
  logLevel: logLevel.INFO
})

const consumer = kafka.consumer({ groupId: 'user-service' });
const topic = 'newLetter';

module.exports = async () => {
  await consumer.connect();
  await consumer.subscribe({ topic });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log({
        partition,
        offset: message.offset,
        value: message.value.toString()
      });
      const letter = JSON.parse(message.value.toString());
      await Grew.increment('lettersCount', { by: 1, where: { userId: letter.userId }});
    }
  });
};