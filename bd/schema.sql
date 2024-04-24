-- Crear las tablas en PostgreSQL

-- Usuario
CREATE TABLE IF NOT EXISTS usuario (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    correo_electronico VARCHAR(255) UNIQUE,
    contrasena VARCHAR(255),
    direccion_envio TEXT,
    es_admin BOOLEAN DEFAULT FALSE
);

-- Categoría de Producto
CREATE TABLE IF NOT EXISTS categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    imagen_url TEXT
);

-- Producto
CREATE TABLE IF NOT EXISTS producto (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    precio NUMERIC(10, 2),
    descuento NUMERIC(5, 2) DEFAULT 0,
    imagen_url TEXT,
    id_categoria INT REFERENCES categoria(id_categoria),
    stock INT
);

-- Pedido
CREATE TABLE IF NOT EXISTS pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id_usuario),
    fecha TIMESTAMP WITHOUT TIME ZONE DEFAULT (CURRENT_TIMESTAMP),
    estado VARCHAR(50),
    total NUMERIC(10, 2)
);

-- Detalle del Pedido
CREATE TABLE IF NOT EXISTS detalle_pedido (
    id_detalle_pedido SERIAL PRIMARY KEY,
    id_pedido INT REFERENCES pedido(id_pedido),
    id_producto INT REFERENCES producto(id_producto),
    cantidad INT,
    precio_unitario NUMERIC(10, 2),
    descuento NUMERIC(5, 2) DEFAULT 0
);

-- Promocion
CREATE TABLE IF NOT EXISTS promocion (
    id_promocion SERIAL PRIMARY KEY,
    descripcion TEXT,
    descuento NUMERIC(5, 2),
    fecha_inicio DATE,
    fecha_fin DATE
);

-- Producto Promocionado
CREATE TABLE IF NOT EXISTS producto_promocion (
    id_promocion INT REFERENCES promocion(id_promocion),
    id_producto INT REFERENCES producto(id_producto),
    PRIMARY KEY (id_promocion, id_producto)
);

-- Reseña
CREATE TABLE IF NOT EXISTS resena (
    id_resena SERIAL PRIMARY KEY,
    id_producto INT REFERENCES producto(id_producto),
    id_usuario INT REFERENCES usuario(id_usuario),
    puntuacion INT CHECK (puntuacion >= 1 AND puntuacion <= 5),
    comentario TEXT,
    fecha TIMESTAMP WITHOUT TIME ZONE DEFAULT (CURRENT_TIMESTAMP)
);

-- Historial de Stock
CREATE TABLE IF NOT EXISTS historial_stock (
    id_historial_stock SERIAL PRIMARY KEY,
    id_producto INT REFERENCES producto(id_producto),
    fecha TIMESTAMP WITHOUT TIME ZONE DEFAULT (CURRENT_TIMESTAMP),
    cantidad_entrada INT,
    cantidad_salida INT
);

-- Sesion de Usuario
CREATE TABLE IF NOT EXISTS sesion_usuario (
    id_sesion SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id_usuario),
    fecha_inicio TIMESTAMP WITHOUT TIME ZONE DEFAULT (CURRENT_TIMESTAMP),
    fecha_fin TIMESTAMP WITHOUT TIME ZONE,
    token_sesion TEXT
);


