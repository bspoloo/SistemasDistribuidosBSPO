const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('bd_agenda_api', 'root', 'root', {
  host: 'localhost',
  dialect: 'mysql'
});

module.exports = sequelize;