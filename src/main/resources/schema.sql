-- liquibase formatted sql

-- changeset allandanos:1
CREATE TABLE todos (
    id NUMBER PRIMARY KEY,
    title VARCHAR2(255) NOT NULL,
    description VARCHAR2(4000),
    completed NUMBER(1) DEFAULT 0 NOT NULL
);

-- changeset allandanos:2
CREATE SEQUENCE todos_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- changeset allandanos:3
CREATE OR REPLACE TRIGGER todos_before_insert
BEFORE INSERT ON todos
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT todos_seq.NEXTVAL INTO :NEW.id FROM dual;
    END IF;
END;
/
