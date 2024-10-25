package com.example.Proyecto.Service;

import com.example.Proyecto.Controller.DTO.ProyectoDTO;
import com.example.Proyecto.Model.Proyecto;
import com.example.Proyecto.Repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyectoServicio {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<ProyectoDTO> obtenerProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        return proyectos.stream()
                .map(proyecto -> new ProyectoDTO(proyecto.getId(), proyecto.getNombre(), proyecto.getDescripcion()))
                .collect(Collectors.toList());
    }

    public Optional<ProyectoDTO> seleccionarProyecto(Long id) {
        return proyectoRepository.findById(id)
                .map(proyecto -> new ProyectoDTO(proyecto.getId(), proyecto.getNombre(), proyecto.getDescripcion()));
    }

    public ProyectoDTO actualizarProyecto(Long id, ProyectoDTO proyectoDTO) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow();
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyectoRepository.save(proyecto);
        return new ProyectoDTO(proyecto.getId(), proyecto.getNombre(), proyecto.getDescripcion());
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
