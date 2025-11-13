const mascotasModel = require('../modelo/mascotas.js');

class MascotasController {

    async getAll(req, res) {
        try {
            const data = await mascotasModel.getAll();

            res.status(200).json(data);
        } catch (e) {
            console.error("Error en controlador (getAll):", e);
            res.status(500).json({ msg: "Error en el servidor" });
        }
    }


    async getOne(req, res) {
        try {
            const { id } = req.params;
            const data = await mascotasModel.getOne(id);
            if (data) {
                res.status(200).json(data);
            } else {
                res.status(404).json({ msg: "Mascota no encontrada" });
            }
        } catch (e) {
            console.error("Error en controlador (getOne):", e);
            res.status(500).json({ msg: "Error en el servidor" });
        }
    }


    async create(req, res) {
        try {
            const { nombre, tipo, edad } = req.body;
            if (!nombre || !tipo || !edad) {
                return res.status(400).json({ msg: "Datos incompletos (nombre, tipo y edad son requeridos)" });
            }
            const data = await mascotasModel.create(req.body);
            res.status(201).json({ msg: "Mascota creada", data });
        } catch (e) {
            console.error("Error en controlador (create):", e);
            res.status(500).json({ msg: "Error en el servidor" });
        }
    }

    async update(req, res) {
        try {
            const { id } = req.params;
            const data = await mascotasModel.update(id, req.body);
            res.status(200).json({ msg: "Mascota actualizada", data });
        } catch (e) {
            console.error("Error en controlador (update):", e);
            res.status(500).json({ msg: "Error en el servidor" });
        }
    }

    async delete(req, res) {
        try {
            const { id } = req.params;

            await mascotasModel.delete(id);

            res.status(200).json({ message: 'Mascota eliminada' });
        } catch (e) {
            console.error("Error en controlador (delete):", e);
            res.status(500).json({ msg: "Error en el servidor" });
        }
    }
}

module.exports = new MascotasController();