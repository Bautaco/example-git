import axios from 'axios';

const API_URL = 'http://localhost:8080/api/proyectos';

const getAllProyectos = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error al obtener proyectos:', error);
    }
};

const getProyectoById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error al obtener proyecto por ID:', error);
    }
};

const createProyecto = async (proyecto) => {
    try {
        const response = await axios.post(API_URL, proyecto);
        return response.data;
    } catch (error) {
        console.error('Error al crear proyecto:', error);
    }
};

const updateProyecto = async (id, proyecto) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, proyecto);
        return response.data;
    } catch (error) {
        console.error('Error al actualizar proyecto:', error);
    }
};

const deleteProyecto = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error('Error al eliminar proyecto:', error);
    }
};

// Asignar el objeto a una variable antes de exportar
const ProyectoService = {
    getAllProyectos,
    getProyectoById,
    createProyecto,
    updateProyecto,
    deleteProyecto,
};

export default ProyectoService;