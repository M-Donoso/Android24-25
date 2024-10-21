const express = require('express');
const bodyParser = require('body-parser');
const { Pool } = require('pg');
const cors = require('cors');

const app = express();
const PORT = process.env.PORT || 3000;

const pool = new Pool({
    user: 'postgres',
    host: 'login-db.cnqwui85diru.us-east-1.rds.amazonaws.com',
    password: '12341234',
    port: 5432,
    ssl: { rejectUnauthorized: false }
});

app.use(express.json());
app.use(cors());

app.post('/login', async (req, res) => {
    const { correo, contraseña } = req.body;
    console.log('Datos recibidos:', { correo, contraseña });

    try {
        const result = await pool.query('SELECT * FROM usuario WHERE correo = $1 AND contraseña = $2', [correo, contraseña]);
        console.log('Resultado de la consulta:', result.rows);

        if (result.rows.length === 0) {
            return res.status(400).json({ message: 'Credenciales incorrectas' });
        }

        const user = result.rows[0];
        res.status(200).json({
            message: 'Login exitoso',
            lstUsers: [{ id: user.id, correo: user.correo }]
        });

    } catch (error) {
        console.error('Error al realizar la consulta', error);
        res.status(500).json({ message: 'Error interno del servidor' });
    }
});


app.listen(PORT, '0.0.0.0', () => {
    console.log(`Servidor escuchando en el puerto ${PORT}`);
});
