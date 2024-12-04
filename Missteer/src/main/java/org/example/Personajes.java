package org.example;

-- Tabla 1: Personajes
CREATE TABLE Personajes (
        codigo_personaje_mg INT PRIMARY KEY,
        nombre_mg VARCHAR(100),
apellidos_mg VARCHAR(100),
altura_media_mg DECIMAL(5, 2),
peso_medio_mg DECIMAL(5, 2),
id_raza_mg INT
);

        -- Tabla 2: Armas
CREATE TABLE Armas (
        codigo_arma_mg INT PRIMARY KEY,
        nombre_mg VARCHAR(100),
tipo_mg VARCHAR(50),
color_mg VARCHAR(50)
);

        -- Tabla 3: Planetas
CREATE TABLE Planetas (
        id_planeta_mg INT PRIMARY KEY,
        nombre_mg VARCHAR(100),
radio_mg DECIMAL(10, 2),
numero_poblacion_mg BIGINT
);

        -- Tabla 4: Naves
CREATE TABLE Naves (
        id_nave_mg INT PRIMARY KEY,
        nombre_mg VARCHAR(100),
capacidad_mg INT,
fecha_fabricacion_mg DATE,
tipo_mg VARCHAR(50)
);

        -- Tabla 5: Viajes
CREATE TABLE Viajes (
        numero_viaje_mg INT PRIMARY KEY,
        distancia_recorrida_mg DECIMAL(10, 2),
numero_pasajeros_mg INT,
fecha_hora_salida_mg TIMESTAMP,
fecha_hora_llegada_mg TIMESTAMP
);

        -- Tabla 6: Capítulos
CREATE TABLE Capitulos (
        codigo_capitulo_mg INT PRIMARY KEY,
        nombre_mg VARCHAR(100),
descripcion_mg TEXT,
fecha_estreno_mg DATE
);

        -- Tabla 7: Temporadas
CREATE TABLE Temporadas (
        codigo_temporada_mg INT PRIMARY KEY,
        descripcion_mg TEXT,
        numero_capitulos_mg INT
);

-- Tabla 8: Raza
CREATE TABLE Raza (
        id_raza_mg INT PRIMARY KEY,
        descripcion_mg TEXT,
        caracteristicas_mg TEXT
);
