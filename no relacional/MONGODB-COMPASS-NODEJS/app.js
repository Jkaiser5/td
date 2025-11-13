const express = require('express');
const dbClient = require('./config/dbClient');
const routesMascotas = require('./routes/mascotas.js');

const app = express();
const PORT = 3000;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use('/mascotas', routesMascotas);

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);

    dbClient.conectarBD();
});