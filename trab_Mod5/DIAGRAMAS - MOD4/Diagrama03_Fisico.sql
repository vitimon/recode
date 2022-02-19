/* Diagrama02_Logico: */

CREATE TABLE Customer (
    id_customer BIGINT PRIMARY KEY,
    email VARCHAR,
    name VARCHAR
);

CREATE TABLE Travel (
    id_travel BIGINT PRIMARY KEY,
    tickets SMALLINT,
    status VARCHAR,
    date DATE,
    promoCode VARCHAR,
    fk_Customer_id_customer BIGINT,
    fk_Transit_id_transit BIGINT
);

CREATE TABLE Transit (
    id_transit BIGINT PRIMARY KEY,
    origin VARCHAR,
    destination VARCHAR,
    price MONEY
);
 
ALTER TABLE Travel ADD CONSTRAINT FK_Travel_2
    FOREIGN KEY (fk_Customer_id_customer)
    REFERENCES Customer (id_customer)
    ON DELETE RESTRICT;
 
ALTER TABLE Travel ADD CONSTRAINT FK_Travel_3
    FOREIGN KEY (fk_Transit_id_transit)
    REFERENCES Transit (id_transit)
    ON DELETE RESTRICT;