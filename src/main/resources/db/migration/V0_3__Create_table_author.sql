CREATE TABLE author
(
    id            serial,
    name          VARCHAR(255),
    birth_date     date,
    particularity VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);
