package com.bodegas.service;

import com.bodegas.dto.BodegaDto;
import com.bodegas.entity.Bodega;
import com.bodegas.repository.BodegaRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BodegaService {

    private final BodegaRepository bodegaRepository;
    private final ModelMapper modelMapper;

    public BodegaService(BodegaRepository bodegaRepository, ModelMapper modelMapper) {
        this.bodegaRepository = bodegaRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public BodegaDto create(BodegaDto dto) {
        Bodega bodega = new Bodega();
        bodega.setNombre(dto.getNombre().trim());
        bodega.setUbicacion(dto.getUbicacion().trim());

        Bodega guardada = bodegaRepository.save(bodega);
        return modelMapper.map(guardada, BodegaDto.class);
    }

    @Transactional(readOnly = true)
    public List<BodegaDto> getAll() {
        return bodegaRepository.findAllConProductos().stream()
                .map(bodega -> modelMapper.map(bodega, BodegaDto.class))
                .toList();
    }
}
