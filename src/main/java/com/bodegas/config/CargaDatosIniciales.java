package com.bodegas.config;

import com.bodegas.entity.Bodega;
import com.bodegas.entity.Producto;
import com.bodegas.repository.BodegaRepository;
import com.bodegas.repository.ProductoRepository;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class CargaDatosIniciales implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CargaDatosIniciales.class);

    private final BodegaRepository bodegaRepository;
    private final ProductoRepository productoRepository;

    public CargaDatosIniciales(BodegaRepository bodegaRepository, ProductoRepository productoRepository) {
        this.bodegaRepository = bodegaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (bodegaRepository.count() > 0) {
            log.info("Ya hay bodegas registradas, no se cargan datos de prueba.");
            return;
        }

        Bodega norte = new Bodega();
        norte.setNombre("Bodega Norte");
        norte.setUbicacion("Calle 170 #45-20, Bogota");

        Bodega sur = new Bodega();
        sur.setNombre("Bodega Sur");
        sur.setUbicacion("Autopista Sur #68-15, Bogota");

        bodegaRepository.save(norte);
        bodegaRepository.save(sur);

        productoRepository.saveAll(List.of(
                crearProducto("Computador portatil", "Portatil 16GB RAM, SSD 512GB",
                        new BigDecimal("2500000.00"), 15, norte),
                crearProducto("Monitor", "Monitor 24 pulgadas Full HD",
                        new BigDecimal("750000.00"), 20, norte),
                crearProducto("Impresora", "Impresora multifuncional laser",
                        new BigDecimal("1200000.00"), 8, sur)));

        log.info("Datos de prueba cargados: {} bodegas y {} productos.",
                bodegaRepository.count(), productoRepository.count());
    }

    private Producto crearProducto(String nombre, String descripcion, BigDecimal precio,
                                   Integer cantidad, Bodega bodega) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setBodega(bodega);
        return producto;
    }
}
