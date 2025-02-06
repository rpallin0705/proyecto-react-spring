# PROYECTO SPRING

## Estructura proyecto

```swift
com.example.videojuegos
├── application
│   ├── dto
│   │   ├── VideojuegoDTO.java
│   ├── usecase
│   │   ├── CreateVideojuegoUseCase.java
│   │   ├── GetVideojuegoUseCase.java
│   │   ├── UpdateVideojuegoUseCase.java
│   │   ├── DeleteVideojuegoUseCase.java
│   │   └── ListVideojuegosUseCase.java
│   ├── service
│   │   ├── VideojuegoService.java
│
├── domain
│   ├── model
│   │   ├── Videojuego.java
│   │   └── VideojuegoRepository.java
│
├── infrastructure
│   ├── adapter
│   │   ├── repository
│   │   │   ├── JpaVideojuegoRepository.java
│   │   │   ├── VideojuegoEntity.java
│   │   │   └── SpringDataVideojuegoRepository.java
│   │   ├── controller
│   │   │   ├── VideojuegoController.java
│   │   ├── configuration
│   │   │   ├── BeanConfig.java
│
└── VideojuegosApplication.java
```

```ini
MYSQL_ROOT_PASSWORD=root
MYSQL_USERNAME=root
MYSQL_PORT=33306
MYSQL_HOST=localhost
MYSQL_DATABASE=videogame
ADMINER_PORT=8181
SERVICE_PORT=8080
```