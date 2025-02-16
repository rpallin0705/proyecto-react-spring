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
- [Ejemplos de Código](#ejemplos-de-código)
  - [`src/data/api/api.ts` (Configuración Global de Axios)](#srcdataapiapits-configuración-global-de-axios)
  - [`src/data/api/videoGamesApi.ts` (API de Videojuegos)](#srcdataapivideogamesapits-api-de-videojuegos)
  - [`src/data/api/usersApi.ts` (API de Usuarios)](#srcdataapiusersapits-api-de-usuarios)
  - [`src/data/api/api.ts` (Configuración Global de Axios)](#srcdataapiapits-configuración-global-de-axios-1)
  - [src/domain/usecases/DeleteVideoGame.ts](#srcdomainusecasesdeletevideogamets)
  - [src/domain/usecases/UpdateVideoGame.ts](#srcdomainusecasesupdatevideogamets)
  - [src/data/repositories/VideoGameRepository.ts](#srcdatarepositoriesvideogamerepositoryts-1)
  - [src/presentation/hooks/useVideoGames.ts](#srcpresentationhooksusevideogamests-1)
  - [1. ¿Qué hay en el archivo constants.ts?](#1-qué-hay-en-el-archivo-constantsts)
  - [Ejemplo de constants.ts](#ejemplo-de-constantsts)
  - [Cómo usar constants.ts en api.ts](#cómo-usar-constantsts-en-apits)
  - [Cómo usar constants.ts en videoGamesApi.ts](#cómo-usar-constantsts-en-videogamesapits)
  - [`src/data/api/usersApi.ts` (API de Usuarios)](#srcdataapiusersapits-api-de-usuarios-1)
- [Descripción de Carpetas y Archivos](#descripción-de-carpetas-y-archivos)
  - [`src/`](#src)
    - [`src/main/`](#srcmain)
    - [`src/data/`](#srcdata)
      - [`api/`](#api)
      - [`dtos/`](#dtos)
      - [`repositories/`](#repositories)
    - [`src/domain/`](#srcdomain)
      - [`entities/`](#entities)
      - [`usecases/`](#usecases)
    - [`src/presentation/`](#srcpresentation)
      - [`components/`](#components)
      - [`pages/`](#pages)
      - [`hooks/`](#hooks)
    - [`src/shared/`](#srcshared)
      - [`utils/`](#utils)
  - [Comunicación entre Capas](#comunicación-entre-capas-1)
  - [Ejemplos de Archivos](#ejemplos-de-archivos)
  - [Notas](#notas)
- [Resumen de Mejoras](#resumen-de-mejoras)

## Estructura General del Proyecto

```
my-app/
├── package.json
├── tsconfig.json
├── README.md
└── src/
    ├── main/
    │   ├── index.tsx                   // Entrada principal de la app
    │   ├── App.tsx                     // Componente raíz
    │   └── routes/
    │       └── AppRouter.tsx           // Configuración de rutas (React Router)
    ├── data/
    │   ├── api/
    │   │   ├── api.ts                   // Configuración global de Axios
    │   │   ├── videoGamesApi.ts         // Peticiones relacionadas con videojuegos
    │   │   ├── usersApi.ts              // Peticiones relacionadas con usuarios
    │   ├── dtos/
    │   │   ├── VideoGameDTO.ts         // Definición del DTO para videojuegos
    │   │   ├── UserDTO.ts              // Definición del DTO para usuarios
    │   └── repositories/
    │       ├── VideoGameRepository.ts  // Repositorio que interactúa con la API de videojuegos
    │       ├── UserRepository.ts       // Repositorio que interactúa con la API de usuarios
    ├── domain/
    │   ├── entities/
    │   │   ├── VideoGame.ts            // Entidad de dominio VideoGame
    │   │   ├── User.ts                 // Entidad de dominio User
    │   └── usecases/
    │       ├── GetVideoGames.ts        // Caso de uso para obtener videojuegos
    │       ├── GetUsers.ts             // Caso de uso para obtener usuarios
    ├── presentation/
    │   ├── components/
    │   │   ├── VideoGameCard.tsx       // Componente para mostrar un videojuego
    │   │   ├── UserCard.tsx            // Componente para mostrar un usuario
    │   ├── pages/
    │   │   ├── VideoGameListPage.tsx   // Página que lista los videojuegos
    │   │   ├── UserListPage.tsx        // Página que lista los usuarios
    │   └── hooks/
    │       ├── useVideoGames.ts        // Hook para videojuegos
    │       ├── useUsers.ts             // Hook para usuarios
    └── shared/
        └── utils/
            ├── formatDate.ts           // Función utilitaria para formatear fechas
            ├── constants.ts            // Constantes generales como URLs
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
# Ejemplos de Código

## `src/data/api/api.ts` (Configuración Global de Axios)

```ts
import axios from "axios";

const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  }
});

export default api;
```

---

## `src/data/api/videoGamesApi.ts` (API de Videojuegos)

```ts
import api from "./api";
import { VideoGameDTO } from "../dtos/VideoGameDTO";

export const fetchVideoGames = async (): Promise<VideoGameDTO[]> => {
  const response = await api.get('/videogames');
  return response.data;
};

export const fetchVideoGameById = async (id: number): Promise<VideoGameDTO> => {
  const response = await api.get(`/videogames/${id}`);
  return response.data;
};
```

---

## `src/data/api/usersApi.ts` (API de Usuarios)

```ts
import api from "./api";
import { UserDTO } from "../dtos/UserDTO";

export const fetchUsers = async (): Promise<UserDTO[]> => {
  const response = await api.get('/users');
  return response.data;
};
```
## `src/data/api/api.ts` (Configuración Global de Axios)

```ts
import axios from "axios";

const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  }
});

export default api;
```

## src/domain/usecases/DeleteVideoGame.ts
```ts

import { VideoGameRepository } from "../../data/repositories/VideoGameRepository";

export class DeleteVideoGame {
  static async execute(id: number): Promise<void> {
    await VideoGameRepository.delete(id);
  }
}
```
## src/domain/usecases/UpdateVideoGame.ts
```ts

import { VideoGameRepository } from "../../data/repositories/VideoGameRepository";
import { VideoGame } from "../entities/VideoGame";

export class UpdateVideoGame {
  static async execute(videoGame: VideoGame): Promise<VideoGame> {
    return await VideoGameRepository.update(videoGame);
  }
}
```
## src/data/repositories/VideoGameRepository.ts

```ts
import { VideoGameDTO } from "../dtos/VideoGameDTO";
import { VideoGame } from "../../domain/entities/VideoGame";
import { updateVideoGameApi, deleteVideoGameApi } from "../api/videoGamesApi";

export class VideoGameRepository {
  static async update(videoGame: VideoGame): Promise<VideoGame> {
    const dto: VideoGameDTO = {
      id: videoGame.id,
      title: videoGame.title,
      releaseDate: videoGame.releaseDate.toISOString()
    };
    const updatedDto = await updateVideoGameApi(dto);
    return new VideoGame(updatedDto.id, updatedDto.title, new Date(updatedDto.releaseDate));
  }

  static async delete(id: number): Promise<void> {
    await deleteVideoGameApi(id);
  }
}
```

## src/presentation/hooks/useVideoGames.ts

```ts
import { useEffect, useState } from "react";
import { GetVideoGames } from "../../domain/usecases/GetVideoGames";
import { DeleteVideoGame } from "../../domain/usecases/DeleteVideoGame";
import { UpdateVideoGame } from "../../domain/usecases/UpdateVideoGame";
import { VideoGame } from "../../domain/entities/VideoGame";

export const useVideoGames = () => {
  const [videoGames, setVideoGames] = useState<VideoGame[]>([]);

  useEffect(() => {
    GetVideoGames.execute().then(setVideoGames);
  }, []);

  const deleteVideoGame = async (id: number) => {
    await DeleteVideoGame.execute(id);
    setVideoGames(videoGames.filter(game => game.id !== id));
  };

  const updateVideoGame = async (videoGame: VideoGame) => {
    const updatedGame = await UpdateVideoGame.execute(videoGame);
    setVideoGames(videoGames.map(game => (game.id === updatedGame.id ? updatedGame : game)));
  };

  return { videoGames, deleteVideoGame, updateVideoGame };
};
```

## 1. ¿Qué hay en el archivo constants.ts?

Este archivo contiene valores constantes reutilizables en todo el proyecto.

## Ejemplo de constants.ts

```ts
export const API_BASE_URL = "http://localhost:8080/api";

export const ENDPOINTS = {
  VIDEO_GAMES: "/videogames",
  USERS: "/users",
};

export const ERROR_MESSAGES = {
  FETCH_FAILED: "No se pudieron obtener los datos.",
  UPDATE_FAILED: "No se pudo actualizar el elemento.",
  DELETE_FAILED: "No se pudo eliminar el elemento.",
};

export const APP_CONFIG = {
  ITEMS_PER_PAGE: 10,
};
```

## Cómo usar constants.ts en api.ts

*src/data/api/api.ts*

```ts
import axios from "axios";
import { API_BASE_URL } from "../../shared/utils/constants";

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-Type": "application/json",
    "Accept": "application/json"
  }
});

export default api;
```

## Cómo usar constants.ts en videoGamesApi.ts

```ts
import api from "./api";
import { ENDPOINTS } from "../../shared/utils/constants";

export const fetchVideoGames = async () => {
  const response = await api.get(ENDPOINTS.VIDEO_GAMES);
  return response.data;
};
```

---

## `src/data/api/usersApi.ts` (API de Usuarios)

```ts
import api from "./api";
import { UserDTO } from "../dtos/UserDTO";

export const fetchUsers = async (): Promise<UserDTO[]> => {
  const response = await api.get('/users');
  return response.data;
};
```


# Descripción de Carpetas y Archivos

## `src/`
Contiene todo el código fuente de la aplicación.

### `src/main/`
- **`index.tsx`** → Punto de entrada de la aplicación.
- **`App.tsx`** → Componente raíz de la aplicación.
- **`routes/AppRouter.tsx`** → Configuración de React Router.

### `src/data/`
Manejo de datos y comunicación con la API.

#### `api/`
- **`api.ts`** → Archivo de configuración global de Axios.
- **`videoGamesApi.ts`** → Contiene solo peticiones relacionadas con videojuegos.
- **`usersApi.ts`** → Contiene solo peticiones relacionadas con usuarios.

#### `dtos/`
- **`VideoGameDTO.ts`** → Define el DTO para videojuegos.
- **`UserDTO.ts`** → Define el DTO para usuarios.

#### `repositories/`
- **`VideoGameRepository.ts`** → Se encarga de transformar los DTOs de videojuegos en entidades de dominio.
- **`UserRepository.ts`** → Se encarga de transformar los DTOs de usuarios en entidades de dominio.

### `src/domain/`
Contiene la lógica de negocio y los modelos de datos.

#### `entities/`
- **`VideoGame.ts`** → Define la entidad `VideoGame`.
- **`User.ts`** → Define la entidad `User`.

#### `usecases/`
- **`GetVideoGames.ts`** → Caso de uso para obtener videojuegos.
- **`GetUsers.ts`** → Caso de uso para obtener usuarios.

### `src/presentation/`
Gestión de la UI y la interacción con los datos.

#### `components/`
- **`VideoGameCard.tsx`** → Componente de presentación para videojuegos.
- **`UserCard.tsx`** → Componente de presentación para usuarios.

#### `pages/`
- **`VideoGameListPage.tsx`** → Página que muestra una lista de videojuegos.
- **`UserListPage.tsx`** → Página que muestra una lista de usuarios.

#### `hooks/`
- **`useVideoGames.ts`** → Hook que maneja la lógica de videojuegos.
- **`useUsers.ts`** → Hook que maneja la lógica de usuarios.

### `src/shared/`
Recursos compartidos entre distintos módulos.

#### `utils/`
- **`formatDate.ts`** → Función para formatear fechas.
- **`constants.ts`** → Constantes generales, como URLs de la API.

---

## Comunicación entre Capas


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

# Resumen de Mejoras
✔ Casos de uso también para delete y update para seguir Clean Architecture.
✔ Archivo constants.ts para evitar valores hardcodeados y mejorar la mantenibilidad.
✔ Reutilización y escalabilidad mejoradas para soportar más entidades y funcionalidades en el futuro.

¿Necesitas más cambios o agregamos otra funcionalidad? 🚀# Descripción de Carpetas y Archivos

