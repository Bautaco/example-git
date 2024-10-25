// src/components/ProyectoDetail.jsx
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import proyectoService from '../Services/ProyectoService';

const ProyectoDetail = () => {
    const [proyecto, setProyecto] = useState({});
    const { id } = useParams();

    useEffect(() => {
        const loadProyecto = async () => {
            const result = await proyectoService.getProyectoById(id);
            setProyecto(result.data);
        };
        loadProyecto();
    }, [id]);

    return (
        <div>
            <h2>Detalles del Proyecto</h2>
            <p><strong>ID:</strong> {proyecto.id}</p>
            <p><strong>Nombre:</strong> {proyecto.nombre}</p>
        </div>
    );
};

export default ProyectoDetail;