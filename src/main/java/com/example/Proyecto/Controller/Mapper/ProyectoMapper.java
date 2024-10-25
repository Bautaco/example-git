package com.example.Proyecto.Controller.Mapper;

import org.mapstruct.Mapper;

import com.example.Proyecto.Controller.DTO.ProyectoDTO;
import com.example.Proyecto.Model.Proyecto;

@Mapper(componentModel = "spring")
public class ProyectoMapper {

    // De Entidad a DTO
    public static ProyectoDTO toDTO(Proyecto proyecto) {
        ProyectoDTO dto = new ProyectoDTO(null, null, null);
        dto.setId(proyecto.getId());
        dto.setNombre(proyecto.getNombre());
        dto.setDescripcion(proyecto.getDescripcion());
        return dto;
    }

    // De DTO a Entidad
    public static Proyecto toEntity(ProyectoDTO dto) {
        Proyecto proyecto = new Proyecto(null, null, false);
        proyecto.setId(dto.getId());
        proyecto.setNombre(dto.getNombre());
        proyecto.setDescripcion(dto.getDescripcion());
        return proyecto;
    }
}
