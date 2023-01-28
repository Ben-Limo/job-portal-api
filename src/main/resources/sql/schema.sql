DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE _users
(
    id SERIAL PRIMARY KEY,
    email VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  INT NOT NULL DEFAULT 1,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
 );

CREATE TABLE authorities
(
    id SERIAL PRIMARY KEY,
    email  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL
);