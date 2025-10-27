const { Sequelize } = require('sequelize');
const sequelize = require('../database.js');
const Agenda = require('./agenda.js')
const Profesion = sequelize.define('Profesion', {
    id: {
        type: Sequelize.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true,
        unsigned: true // Aquí especificamos que es UNSIGNED
    },
    nombre: {
        type: Sequelize.STRING(9),
        allowNull: false
    },
    descripcion: {
        type: Sequelize.STRING(50),
        allowNull: false
    },
}, {
    tableName: 'profesiones',
    timestamps: true, // Para manejar los campos created_at y updated_at automáticamente
    createdAt: 'created_at',
    updatedAt: 'updated_at'
});


module.exports = Profesion;
