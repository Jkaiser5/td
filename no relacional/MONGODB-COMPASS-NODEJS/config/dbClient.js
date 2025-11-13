const { MongoClient } = require("mongodb");
const queryString = process.env.MONGO_URI;

if (!queryString) {
    throw new Error('No se encontró la variable MONGO_URI. Revisa tu docker-compose.yml');
}

class dbClient {
    constructor() {
        this.client = new MongoClient(queryString);
        this.db = null;
    }

    async conectarBD() {
        try {
            await this.client.connect();
            this.db = this.client.db();
            console.log("Conectado exitosamente a la base de datos en Docker");
        } catch (e) {
            console.error(" Error al conectar con MongoDB:", e);
        }
    }

    getDb() {
        return this.db;
    }
}

module.exports = new dbClient();