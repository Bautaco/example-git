// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ProyectoList from './Components/ProyectoList';
import ProyectoDetail from './Components/ProyectoDetail';
import ProyectoForm from './Components/ProyectoForm';

const App = () => {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<ProyectoList />} />
                    <Route path="/proyectos" element={<ProyectoList />} />
                    <Route path="/proyecto/:id" element={<ProyectoDetail />} />
                    <Route path="/proyecto/new" element={<ProyectoForm />} />
                    <Route path="/proyecto/edit/:id" element={<ProyectoForm />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
