# Primer Examen Parcial - Especialización en Backend I
> Ana Maria Galarza y Luciano Gelvez

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)


## Descripción 📄

Nuestra tarea es implementar una arquitectura de microservicios utilizando Spring Cloud. Se proporcionan dos microservicios, movie-service y catalog-service, que deben ser configurados y comunicados entre sí siguiendo las directrices de Spring Cloud.

### Tareas Principales
1. Configuración de Microservicios:
Configura los microservicios movie-service y catalog-service para que puedan autodescubrirse utilizando Eureka Server.

2. Configuración Centralizada: Implementa el Config Server para obtener la configuración de los microservicios desde un repositorio Git centralizado.

3. Comunicación entre Microservicios: Utiliza Feign para establecer una comunicación eficiente entre los microservicios. En particular, deberás obtener películas filtradas por género desde el catálogo (catalog-service).

4. Proyecto Gateway y Ruteo: Crea un proyecto Gateway y configura el ruteo adecuado para uno de los microservicios.

5. Balanceo de Carga: Implementa el balanceo de carga con Load Balancer para garantizar la eficiencia y disponibilidad de los microservicios. Asegúrate de documentar el proceso y adjuntar capturas de pantalla del resultado en Postman.

## Solución 🔍

En este repositorio se encuentra la solución al examen parcial de la especialización en Backend I, en el cual se implementa una arquitectura de microservicios utilizando Spring Cloud.

Para la ejecución de este proyecto se debe tener instalado:

- Docker

Solo se debe ejecutar el siguiente comando para levantar los servicios desde la carpeta raíz del proyecto:

```sh
docker-compose up -d
```

## Documentación API 💼

La documentación de la API se encuentra en el siguiente link: [Documentación API](https://documenter.getpostman.com/view/24635478/2s9Y5SWm8L)
 
## Imágenes 📷

### Ejecución de Docker Compose

![Docker Compose](https://i.ibb.co/kgf68Y9/Sin-t-tulo.jpg)

### Dashboard de Docker Desktop

![Docker Desktop](https://i.ibb.co/LCyLQ2G/image.png)

### Trazabilidad (Tracing) con Zipkin

![Zipkin](https://i.ibb.co/qm26wtB/image.png)
![Zipkin 2](https://i.ibb.co/Fs8ytRB/image.png)

### Eureka Server (Dashboard)

![Eureka Server](https://i.ibb.co/42Xpkrm/image.png)

### Endpoint de Config Server

![Config Server](https://i.ibb.co/pbD4LBf/image.png)

### Listado de Películas

![Listado de Películas](https://i.ibb.co/qB8NNBK/image.png)

### Listado de Películas por ID

![Listado de Películas por ID](https://i.ibb.co/wyLq4q2/image.png)

### Guardar Película

![Guardar Película Comedia](https://i.ibb.co/YT8Dnxg/image.png) 
![Guardar Película 2](https://i.ibb.co/C5d9ZQ4/image.png) 

### Listado de Series

![Listado de Series](https://i.ibb.co/1mhbj0y/image.png)

### Listado de Catálogos

![Listado de Catálogos](https://i.ibb.co/1fbyKYz/image.png)

### Catalogo por Género

![Catalogo por Género Comedia](https://i.ibb.co/bHJTCY6/image.png)
![Catalogo por Género Acción](https://i.ibb.co/27yGjDx/image.png)

### Visualización de tabla en MySQL

![Visualización de tabla en MySQL](https://i.ibb.co/c2sFf9b/image.png)

### Visualización de registros en MongoDB

![Visualización de registros en MongoDB](https://i.ibb.co/SXjqyVq/image.png)

# Autores ✒️

- [Ana Maria Galarza](https://github.com/AnaMariaGalarza)
- [Luciano Gelvez](https://github.com/LucianoGelvez)
  
