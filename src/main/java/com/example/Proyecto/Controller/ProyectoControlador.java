package com.example.Proyecto.Controller;

import com.example.Proyecto.Controller.DTO.ProyectoDTO;
import com.example.Proyecto.Service.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoControlador {

    @Autowired
    private ProyectoServicio proyectoServicio;

    @GetMapping
    public List<ProyectoDTO> obtenerProyectos() {
        return proyectoServicio.obtenerProyectos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> seleccionarProyecto(@PathVariable Long id) {
        return proyectoServicio.seleccionarProyecto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ProyectoDTO actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {
        return proyectoServicio.actualizarProyecto(id, proyectoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoServicio.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }
}