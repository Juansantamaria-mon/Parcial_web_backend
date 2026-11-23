# bodegas-backend

Backend del sistema de bodegas y productos. Java 21, Spring Boot, JPA y H2 en memoria.
Una bodega tiene varios productos y cada producto pertenece a una unica bodega.

## Requisitos

JDK 21 y Maven 3.9 o superior. No hay que instalar base de datos.

## Ejecutar

    mvn spring-boot:run

Queda en http://localhost:8080

## Endpoints

| Metodo | Ruta | Accion |
|--------|------|--------|
| POST | /bodegas | Registrar bodega |
| GET | /bodegas | Consultar bodegas con sus productos |

## Estructura

    src/main/java/com/bodegas
      entity/       Bodega y Producto
      repository/   BodegaRepository y ProductoRepository
      service/      BodegaService
      controller/   BodegaController y ApiExceptionHandler
      dto/          BodegaDto, ProductoDto y ErrorDto
      config/       ModelMapperConfig, ConfiguracionCors y CargaDatosIniciales

Producto es entidad y repositorio, sin servicio ni controlador propio.
CargaDatosIniciales guarda al arrancar dos bodegas y tres productos de prueba.

El frontend esta en el repositorio bodegas-frontend y se ejecuta por separado.
