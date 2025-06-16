#!/bin/bash
PGPASSWORD=aurora_pass \
psql -h localhost -d aurora -U aurora_user -p 5432 -c \
"CREATE TABLE stores (
  store_id SERIAL PRIMARY KEY,
  store_name VARCHAR(30)
);
INSERT INTO stores (store_name)
VALUES ('Spar'),
('Centra'),
('Xtra-Vision'),
('GAME'),
('HMV'),
('Costa')"