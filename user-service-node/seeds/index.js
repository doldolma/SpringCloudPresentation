const grewsSeed = require('./grews');

module.exports = async function Seed() {
    await grewsSeed();
}