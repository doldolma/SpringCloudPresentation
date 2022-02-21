require('dotenv').config();

module.exports = {
  development: {
    username: 'root',
    password: '123123',
    database: 'jest_presentation',
    host: 'localhost',
    dialect: 'mysql',
  },
  production: {
    username: 'root',
    password: '123123',
    database: 'jest_presentation',
    host: '127.0.0.1',
    dialect: 'mysql',
  },
};
