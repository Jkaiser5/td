
const { ObjectId } = require('mongodb');
const dbClient = require("../config/dbClient");

class mascotasModelo {
    getCollection() {
        const db = dbClient.getDb();
        if (!db) {
            throw new Error('Base de datos no conectada');
        }
        return db.collection('mascotas');
    }

    async getAll() {
        const coleccion = this.getCollection();
        return await coleccion.find({}).toArray();
    }

    async getOne(id) {
        const coleccion = this.getCollection();
        if (!ObjectId.isValid(id)) {
            return null;
        }
        return await coleccion.findOne({ _id: new ObjectId(id) });
    }

    async create(mascota) {
        const coleccion = this.getCollection();
        return await coleccion.insertOne(mascota);
    }

    async update(id, mascota) {
        const coleccion = this.getCollection();
        if (!ObjectId.isValid(id)) {
            throw new Error('ID inválido para actualizar');
        }
        return await coleccion.updateOne(
            { _id: new ObjectId(id) }, 
            { $set: mascota }
        );
    }
    
    async delete(id) {
        const coleccion = this.getCollection();
        if (!ObjectId.isValid(id)) {
            throw new Error('ID inválido para borrar');
        }
        return await coleccion.deleteOne({ _id: new ObjectId(id) });
    }
}

module.exports = new mascotasModelo();