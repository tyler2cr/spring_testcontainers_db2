CREATE TABLE person
(
    id         INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(150)                         NOT NULL,
    last_name  VARCHAR(255)                         NOT NULL,
    email      VARCHAR(100),
    PRIMARY KEY (id)
);