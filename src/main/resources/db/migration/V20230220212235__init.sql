CREATE TABLE sequence
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(50) NOT NULL,
    value TEXT        NOT NULL
);

INSERT INTO sequence (name, value)
VALUES ('LAST_INDEX', 'a0a0');