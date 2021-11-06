const Sequelize = require('sequelize');
const University = require('./university');
const Member = require('./member');

const env = process.env.NODE_ENV || 'development';
const config = require('../config/config')[env];
const db = {};

const sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;
db.Sequelize = Sequelize;

db.University = University;
University.init(sequelize);
University.associate(db);


db.Member = Member;
Member.init(sequelize);
Member.associate(db);

module.exports = db;