/* Diagrama02_Logico: */

CREATE TABLE Customer (
    id_customer INTEGER PRIMARY KEY,
    email VARCHAR,
    name VARCHAR
);

CREATE TABLE Travel (
    id_travel INTEGER PRIMARY KEY,
    tickets TINYINT,
    status VARCHAR,
    promoCode VARCHAR,
    totalPrice MONEY,
    fk_Customer_id_customer INTEGER,
    fk_Transit_id_transit INTEGER
);

CREATE TABLE Transit (
    id_transit INTEGER PRIMARY KEY,
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