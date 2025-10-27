const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const schema = require('./schema');
const sequelize = require('./database.js');


const app = express();

app.use('/graphql', graphqlHTTP({
  schema: schema,
  graphiql: true
}));

sequelize.authenticate()
  .then(() => {
    console.log('Connection to the database has been established successfully.');
    app.listen(4000, () => {
      console.log('Server is running on http://localhost:4000/graphql');
    });
  })
  .catch(err => {
    console.error('Unable to connect to the database:', err);
  });
sequelize.sync({ alter: true })
  .then(() => {
    console.log("Exito en crear las tablas");
  })
  .catch(err => {
    console.error('Unable to connect to the create tables:', err);
  });
