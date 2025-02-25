# Para ejecutar el proyecto 

Abrimos una terminal en la carpeta raiz y ejecutamos los siguientes comando

1. Primero copiamos el .env.example (contiene las variables de entorno de desarrollo) a un .env, generamos el .jar del proyecto y levantamos los contenedores docker que llevarán la aplicación.
   
```bash
cd ./backend
cp .env.example .env
mvn clean package 
docker compose up -d
```

2. Volvemos a la carpeta raiz del proyecto, abrimos la carpeta frontend. Instalamos las dependencias de node y ejecutamos la aplicación en modo desarrollo.

```bash
cd ../frontend
npm install
npm run dev
```