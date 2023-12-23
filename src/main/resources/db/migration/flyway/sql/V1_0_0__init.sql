CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) UNIQUE,
    phone_number varchar(255) UNIQUE,
    role varchar(255),
    password varchar(255) UNIQUE
);