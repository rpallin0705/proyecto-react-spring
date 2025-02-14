# Esquema de Proyecto: React con Clean Architecture y TypeScript

Este documento describe la estructura de un proyecto React con TypeScript que utiliza Clean Architecture para consumir una API REST desarrollada en Spring Boot. El proyecto utiliza React Router para la navegación, Axios para las peticiones HTTP y DTOs para el mapeo de datos de videojuegos.

## Índice
- [Esquema de Proyecto: React con Clean Architecture y TypeScript](#esquema-de-proyecto-react-con-clean-architecture-y-typescript)
  - [Índice](#índice)
  - [Estructura General del Proyecto](#estructura-general-del-proyecto)
  - [Comunicación entre Capas](#comunicación-entre-capas)
    - [Flujo de Datos](#flujo-de-datos)
    - [Ejemplo de Código](#ejemplo-de-código)
      - [**src/data/api/videoGamesApi.ts**](#srcdataapivideogamesapits)
      - [**src/data/dtos/VideoGameDTO.ts**](#srcdatadtosvideogamedtots)
      - [**src/data/repositories/VideoGameRepository.ts**](#srcdatarepositoriesvideogamerepositoryts)
      - [**src/domain/entities/VideoGame.ts**](#srcdomainentitiesvideogamets)
      - [**src/domain/usecases/GetVideoGames.ts**](#srcdomainusecasesgetvideogamests)
      - [**src/presentation/hooks/useVideoGames.ts**](#srcpresentationhooksusevideogamests)
      - [**src/presentation/pages/VideoGameListPage.tsx**](#srcpresentationpagesvideogamelistpagetsx)
  - [Comunicación entre Capas](#comunicación-entre-capas-1)
  - [Descripción de Carpetas y Archivos](#descripción-de-carpetas-y-archivos)
    - [src/](#src)
    - [src/main](#srcmain)
    - [src/data](#srcdata)
    - [src/domain](#srcdomain)
    - [src/presentation](#srcpresentation)
    - [src/shared](#srcshared)
  - [Ejemplos de Archivos](#ejemplos-de-archivos)
  - [Notas](#notas)

## Estructura General del Proyecto

```
my-app/
├── package.json
├── tsconfig.json
├── README.md
└── src/
    ├── main/
    │   ├── index.tsx               // Entrada principal de la app
    │   ├── App.tsx                 // Componente raíz
    │   └── routes/
    │       └── AppRouter.tsx       // Configuración de rutas (React Router)
    ├── data/
    │   ├── api/
    │   │   └── videoGamesApi.ts    // Configuración y llamadas a la API (Axios)
    │   ├── dtos/
    │   │   └── VideoGameDTO.ts     // Definición del DTO para videojuegos
    │   └── repositories/
    │       └── VideoGameRepository.ts // Repositorio que interactúa con la API
    ├── domain/
    │   ├── entities/
    │   │   └── VideoGame.ts        // Entidad de dominio VideoGame
    │   └── usecases/
    │       └── GetVideoGames.ts    // Caso de uso para obtener videojuegos
    ├── presentation/
    │   ├── components/
    │   │   └── VideoGameCard.tsx   // Componente para mostrar un videojuego
    │   ├── pages/
    │   │   └── VideoGameListPage.tsx // Página que lista los videojuegos
    │   └── hooks/
    │       └── useVideoGames.ts    // Hook personalizado para la lógica de presentación
    └── shared/
        └── utils/
            └── formatDate.ts       // Función utilitaria para formatear fechas
```
## Comunicación entre Capas

### Flujo de Datos
1. **Capa de Presentación (`presentation`)**:
   - Utiliza `useVideoGames.ts` para recuperar la lista de videojuegos.
   - `useVideoGames.ts` invoca el caso de uso `GetVideoGames.ts` de la capa de dominio.
   - Renderiza la información usando `VideoGameListPage.tsx` y `VideoGameCard.tsx`.

2. **Capa de Dominio (`domain`)**:
   - `GetVideoGames.ts` se encarga de aplicar reglas de negocio si es necesario.
   - Llama a `VideoGameRepository.ts` en la capa de datos para recuperar los videojuegos.

3. **Capa de Datos (`data`)**:
   - `VideoGameRepository.ts` solicita datos a la API a través de `videoGamesApi.ts`.
   - `videoGamesApi.ts` hace la petición HTTP con Axios y recibe un `VideoGameDTO`.
   - `VideoGameDTO.ts` transforma la respuesta de la API en una entidad `VideoGame.ts`.
   - La entidad `VideoGame.ts` es enviada a la capa de dominio para su uso.

### Ejemplo de Código
#### **src/data/api/videoGamesApi.ts**
```typescript
import axios from 'axios';
import { VideoGameDTO } from '../dtos/VideoGameDTO';

const API_URL = 'https://api.example.com/videogames';

export const fetchVideoGames = async (): Promise<VideoGameDTO[]> => {
  const response = await axios.get(API_URL);
  return response.data;
};
```

#### **src/data/dtos/VideoGameDTO.ts**
```typescript
export interface VideoGameDTO {
  id: number;
  title: string;
  releaseDate: string;
}
```

#### **src/data/repositories/VideoGameRepository.ts**
```typescript
import { fetchVideoGames } from '../api/videoGamesApi';
import { VideoGameDTO } from '../dtos/VideoGameDTO';
import { VideoGame } from '../../domain/entities/VideoGame';

export class VideoGameRepository {
  static async getAll(): Promise<VideoGame[]> {
    const dtos: VideoGameDTO[] = await fetchVideoGames();
    return dtos.map(dto => new VideoGame(dto.id, dto.title, new Date(dto.releaseDate)));
  }
}
```

#### **src/domain/entities/VideoGame.ts**
```typescript
export class VideoGame {
  constructor(
    public id: number,
    public title: string,
    public releaseDate: Date
  ) {}
}
```

#### **src/domain/usecases/GetVideoGames.ts**
```typescript
import { VideoGameRepository } from '../../data/repositories/VideoGameRepository';
import { VideoGame } from '../entities/VideoGame';

export class GetVideoGames {
  static async execute(): Promise<VideoGame[]> {
    return await VideoGameRepository.getAll();
  }
}
```

#### **src/presentation/hooks/useVideoGames.ts**
```typescript
import { useEffect, useState } from 'react';
import { GetVideoGames } from '../../domain/usecases/GetVideoGames';
import { VideoGame } from '../../domain/entities/VideoGame';

export const useVideoGames = () => {
  const [videoGames, setVideoGames] = useState<VideoGame[]>([]);

  useEffect(() => {
    GetVideoGames.execute().then(setVideoGames);
  }, []);

  return { videoGames };
};
```

#### **src/presentation/pages/VideoGameListPage.tsx**
```typescript
import { useVideoGames } from '../hooks/useVideoGames';
import { VideoGameCard } from '../components/VideoGameCard';

export const VideoGameListPage = () => {
  const { videoGames } = useVideoGames();

  return (
    <div>
      {videoGames.map(game => (
        <VideoGameCard key={game.id} game={game} />
      ))}
    </div>
  );
};
``` 

## Comunicación entre Capas


## Descripción de Carpetas y Archivos

### src/
Contiene todo el código fuente de la aplicación.

### src/main
- **index.tsx**: Punto de entrada de la aplicación donde se monta el componente principal en el DOM.
- **App.tsx**: Componente principal que envuelve toda la aplicación y maneja la estructura general.
- **routes/AppRouter.tsx**: Define las rutas y su estructura usando React Router.

### src/data
Capa encargada de la comunicación con la API y el manejo de datos.
- **api/videoGamesApi.ts**: Configuración de Axios y funciones para realizar peticiones a la API REST de Spring Boot.
- **dtos/VideoGameDTO.ts**: Define la estructura de los datos recibidos de la API.
- **repositories/VideoGameRepository.ts**: Contiene métodos para obtener datos desde la API y transformarlos en entidades del dominio.

### src/domain
Capa que contiene la lógica de negocio independiente de la infraestructura.
- **entities/VideoGame.ts**: Define la estructura y comportamiento del modelo de dominio VideoGame.
- **usecases/GetVideoGames.ts**: Implementa la lógica para obtener videojuegos y servirlos a la capa de presentación.

### src/presentation
Capa que gestiona la interfaz de usuario y la interacción con el usuario.
- **components/VideoGameCard.tsx**: Componente visual para mostrar la información de un videojuego.
- **pages/VideoGameListPage.tsx**: Página que renderiza la lista completa de videojuegos.
- **hooks/useVideoGames.ts**: Hook que encapsula la lógica para obtener y gestionar videojuegos en la UI.

### src/shared
Contiene utilidades y recursos compartidos en toda la aplicación.
- **utils/formatDate.ts**: Función para formatear fechas de manera consistente en toda la app.

## Ejemplos de Archivos

- `src/main/index.tsx`
- `src/main/App.tsx`
- `src/main/routes/AppRouter.tsx`
- `src/data/api/videoGamesApi.ts`
- `src/data/dtos/VideoGameDTO.ts`
- `src/data/repositories/VideoGameRepository.ts`
- `src/domain/entities/VideoGame.ts`
- `src/domain/usecases/GetVideoGames.ts`
- `src/presentation/components/VideoGameCard.tsx`
- `src/presentation/pages/VideoGameListPage.tsx`
- `src/presentation/hooks/useVideoGames.ts`
- `src/shared/utils/formatDate.ts`

## Notas

- **TypeScript:** Todo el código está tipado para mayor seguridad y mantenimiento.
- **Comunicación con la API:** `data/api/videoGamesApi.ts` se encarga de realizar las peticiones HTTP a la API REST de Spring Boot.
- **DTOs:** `data/dtos/VideoGameDTO.ts` se utiliza para transformar y mapear los datos recibidos de la API, asegurando que se adapten a la entidad `VideoGame` en `domain`.
- **Clean Architecture:** Se separa la lógica de negocio (`domain`) de la infraestructura (`data`) y de la presentación (`presentation`), garantizando un código modular y mantenible.
- **Routing y Navegación:** La configuración de rutas en `src/main/routes/AppRouter.tsx` permite la navegación entre páginas, utilizando React Router.

---

Este esquema es una guía para estructurar un proyecto React con TypeScript aplicando los principios de Clean Architecture, asegurando una separación clara de responsabilidades y facilitando futuras ampliaciones y mantenimientos.

