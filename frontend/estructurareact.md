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

-------

Índice
Estructura General del Proyecto
Descripción de Carpetas y Archivos
src/
src/main
src/data
src/domain
src/presentation
src/shared
Ejemplos de Código
Flujo de Datos
Notas Finales
Estructura General del Proyecto
less
Copiar
Editar
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
Descripción de Carpetas y Archivos
src/
Contiene todo el código fuente de la aplicación.

src/main/
index.tsx → Punto de entrada de la aplicación.
App.tsx → Componente raíz de la aplicación.
routes/AppRouter.tsx → Configuración de React Router.
src/data/
Manejo de datos y comunicación con la API.

api/
api.ts → Archivo de configuración global de Axios.
videoGamesApi.ts → Contiene solo peticiones relacionadas con videojuegos.
usersApi.ts → Contiene solo peticiones relacionadas con usuarios.
dtos/
VideoGameDTO.ts → Define el DTO para videojuegos.
UserDTO.ts → Define el DTO para usuarios.
repositories/
VideoGameRepository.ts → Se encarga de transformar los DTOs de videojuegos en entidades de dominio.
UserRepository.ts → Se encarga de transformar los DTOs de usuarios en entidades de dominio.
src/domain/
Contiene la lógica de negocio y los modelos de datos.

entities/VideoGame.ts → Define la entidad VideoGame.
entities/User.ts → Define la entidad User.
usecases/GetVideoGames.ts → Caso de uso para obtener videojuegos.
usecases/GetUsers.ts → Caso de uso para obtener usuarios.
src/presentation/
Gestión de la UI y la interacción con los datos.

components/VideoGameCard.tsx → Componente de presentación para videojuegos.
components/UserCard.tsx → Componente de presentación para usuarios.
pages/VideoGameListPage.tsx → Página que muestra una lista de videojuegos.
pages/UserListPage.tsx → Página que muestra una lista de usuarios.
hooks/useVideoGames.ts → Hook que maneja la lógica de videojuegos.
hooks/useUsers.ts → Hook que maneja la lógica de usuarios.
src/shared/
Recursos compartidos entre distintos módulos.

utils/formatDate.ts → Función para formatear fechas.
utils/constants.ts → Constantes generales, como URLs de la API.
Ejemplos de Código
src/data/api/api.ts (Configuración Global de Axios)
ts
Copiar
Editar
import axios from "axios";

const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  }
});

export default api;
src/data/api/videoGamesApi.ts (API de Videojuegos)
ts
Copiar
Editar
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
src/data/api/usersApi.ts (API de Usuarios)
ts
Copiar
Editar
import api from "./api";
import { UserDTO } from "../dtos/UserDTO";

export const fetchUsers = async (): Promise<UserDTO[]> => {
  const response = await api.get('/users');
  return response.data;
};
Flujo de Datos
Capa de Presentación (presentation)
Un componente o hook necesita datos y llama a un caso de uso (useVideoGames.ts o useUsers.ts).
Capa de Dominio (domain)
El caso de uso (GetVideoGames.ts o GetUsers.ts) solicita los datos al repositorio.
Capa de Datos (data)
El repositorio (VideoGameRepository.ts o UserRepository.ts) usa los métodos de la API (videoGamesApi.ts o usersApi.ts) para obtener los datos de la API REST.
Transforma los DTOs en entidades de dominio (VideoGame.ts o User.ts).
Capa de Presentación (presentation)
Los datos convertidos se devuelven a la UI para renderizarlos en los componentes.
Notas Finales
Modularidad: Cada API tiene su propio archivo, manteniendo el código limpio.
Configuración Global de Axios: Evita repetir configuraciones en cada API.
Escalabilidad: Puedes agregar más entidades (ej. ordersApi.ts) sin afectar las demás.
Este enfoque mantiene la Clean Architecture y facilita la mantenibilidad a largo plazo. 🚀

---

src/domain/usecases/DeleteVideoGame.ts
ts
Copiar
Editar
import { VideoGameRepository } from "../../data/repositories/VideoGameRepository";

export class DeleteVideoGame {
  static async execute(id: number): Promise<void> {
    await VideoGameRepository.delete(id);
  }
}
src/domain/usecases/UpdateVideoGame.ts
ts
Copiar
Editar
import { VideoGameRepository } from "../../data/repositories/VideoGameRepository";
import { VideoGame } from "../entities/VideoGame";

export class UpdateVideoGame {
  static async execute(videoGame: VideoGame): Promise<VideoGame> {
    return await VideoGameRepository.update(videoGame);
  }
}
src/data/repositories/VideoGameRepository.ts
ts
Copiar
Editar
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
src/data/api/videoGamesApi.ts
ts
Copiar
Editar
import api from "./api";
import { VideoGameDTO } from "../dtos/VideoGameDTO";

export const updateVideoGameApi = async (videoGame: VideoGameDTO): Promise<VideoGameDTO> => {
  const response = await api.put(`/videogames/${videoGame.id}`, videoGame);
  return response.data;
};

export const deleteVideoGameApi = async (id: number): Promise<void> => {
  await api.delete(`/videogames/${id}`);
};
src/presentation/hooks/useVideoGames.ts
ts
Copiar
Editar
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
2. ¿Qué hay en el archivo constants.ts?
Este archivo contiene valores constantes reutilizables en todo el proyecto.

Ejemplo de constants.ts
src/shared/utils/constants.ts
ts
Copiar
Editar
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
Cómo usar constants.ts en api.ts
src/data/api/api.ts
ts
Copiar
Editar
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
Cómo usar constants.ts en videoGamesApi.ts
ts
Copiar
Editar
import api from "./api";
import { ENDPOINTS } from "../../shared/utils/constants";

export const fetchVideoGames = async () => {
  const response = await api.get(ENDPOINTS.VIDEO_GAMES);
  return response.data;
};
Resumen de Mejoras
✔ Casos de uso también para delete y update para seguir Clean Architecture.
✔ Archivo constants.ts para evitar valores hardcodeados y mejorar la mantenibilidad.
✔ Reutilización y escalabilidad mejoradas para soportar más entidades y funcionalidades en el futuro.

¿Necesitas más cambios o agregamos otra funcionalidad? 🚀