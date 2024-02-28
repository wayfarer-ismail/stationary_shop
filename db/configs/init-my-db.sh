#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE TABLE student (
    studentid INT PRIMARY KEY, 
    firstname VARCHAR (50), 
    lastname VARCHAR (50), 
    modulename VARCHAR (255), 
    level INT, 
    credits INT 
    );
    INSERT INTO student (studentid, firstname, lastname, modulename, level, credits)
    VALUES (18211599, 'John', 'Byabazaire', 'COMP30860', 3, 5);
EOSQL
