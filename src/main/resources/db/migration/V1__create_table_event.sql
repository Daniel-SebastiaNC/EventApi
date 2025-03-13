CREATE TABLE tb_event (
    id serial PRIMARY KEY,
    name varchar(255) NOT NULL,
    description TEXT,
    identifier varchar(255) NOT NULL UNIQUE,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    location varchar(255) NOT NULL,
    organizer varchar(255) NOT NULL,
    capacity INTEGER NOT NULL,
    type_event varchar(255) NOT NULL
);