// src/components/ProyectoList.jsx
import React, { useEffect, useState } from 'react';
import proyectoService from '../Services/ProyectoService';
import { Link } from 'react-router-dom';

const ProyectoList = () => {
    const [proyectos, setProyectos] = useState([]);

    useEffect(() => {
        loadProyectos();
    }, []);

    const loadProyectos = async () => {
        const result = await proyectoService.getAllProyectos();
        setProyectos(result.data);
    };

    const handleDelete = async (id) => {
        await proyectoService.deleteProyecto(id);
        loadProyectos(); // Recargar la lista después de eliminar
    };

    return (
        <div>
            <h2>Lista de Proyectos</h2>
            <Link to="/proyecto/new">Crear Nuevo Proyecto</Link>
            <ul>
                {proyectos.map((proyecto) => (
                    <li key={proyecto.id}>
                        {proyecto.nombre}
                        <Link to={`/proyecto/${proyecto.id}`}> Ver Detalles</Link>
                        <button onClick={() => handleDelete(proyecto.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ProyectoList;
