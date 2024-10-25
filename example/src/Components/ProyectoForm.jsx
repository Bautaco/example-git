// src/components/ProyectoForm.jsx
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import proyectoService from '../Services/ProyectoService';

const ProyectoForm = () => {
    const [nombre, setNombre] = useState('');
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (id) {
            const loadProyecto = async () => {
                const result = await proyectoService.getProyectoById(id);
                setNombre(result.data.nombre);
            };
            loadProyecto();
        }
    }, [id]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const proyecto = { nombre };
        if (id) {
            await proyectoService.updateProyecto(id, proyecto);
        } else {
            await proyectoService.createProyecto(proyecto);
        }
        navigate('/proyectos'); // Redirigir a la lista después de guardar
    };

    return (
        <div>
            <h2>{id ? 'Editar Proyecto' : 'Crear Nuevo Proyecto'}</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Nombre del Proyecto:</label>
                    <input
                        type="text"
                        value={nombre}
                        onChange={(e) => setNombre(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Guardar</button>
            </form>
        </div>
    );
};

export default ProyectoForm;
