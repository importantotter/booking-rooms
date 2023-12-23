CREATE TABLE IF NOT EXISTS building
(
    id SERIAL primary key,
    address_building varchar(255),
    floor_building   varchar(255),
    type_building    varchar(255)
);

alter table building
    owner to postgres;