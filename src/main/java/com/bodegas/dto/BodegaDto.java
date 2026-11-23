package com.bodegas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BodegaDto {

    private Long id;

    @NotBlank(message = "El nombre de la bodega es obligatorio")
    @Size(max = 120, message = "El nombre no puede exceder 120 caracteres")
    private String nombre;

    @NotBlank(message = "La ubicacion de la bodega es obligatoria")
    @Size(max = 180, message = "La ubicacion no puede exceder 180 caracteres")
    private String ubicacion;

    private List<ProductoDto> productos = new ArrayList<>();
}
