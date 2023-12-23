CREATE TABLE IF NOT EXISTS apartment
(
    id SERIAL primary key,
    description   text,
    floor         varchar(255),
    square_meters varchar(255),
    building_id   bigint
        constraint fkmjjff7q9e4qfyop2w1vafy619
            references building,
    customer_id   bigint
        constraint fkp92tqn51uxofo4qd4c09be48m
            references customer
);

alter table apartment
    owner to postgres;