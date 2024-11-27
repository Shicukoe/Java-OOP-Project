
CREATE TABLE USERS (
    user_id NUMBER GENERATED BY DEFAULT AS IDENTITY (
    START WITH 1 INCREMENT BY 1 CACHE 10 NOCYCLE) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL , -- Password should be stored as a hash
    role VARCHAR(15) NOT NULL
);

INSERT INTO USERS(username,password,role) VALUES ('tus','123','admin');
INSERT INTO USERS(username,password,role) VALUES ('sang','321','admin');


DROP TABLE USERS;

CREATE TABLE PETS (
    pet_id NUMBER GENERATED BY DEFAULT AS IDENTITY (
    START WITH 1
    INCREMENT BY 1
    CACHE 10
    NOCYCLE
    ) PRIMARY KEY,
    name VARCHAR(50),
    price DOUBLE PRECISION,
    type VARCHAR(50) NOT NULL,  -- e.g., dog, cat, bird
    breed VARCHAR(50),
    age INT,
    gender VARCHAR2(10) CHECK (gender IN ('Male', 'Female')),
    description CLOB,
    added_by VARCHAR(50) NOT NULL,

    FOREIGN KEY (added_by) REFERENCES Users(username) ON DELETE SET NULL  -- Tracks which admin added the pet
);


INSERT INTO PETS (name, price , type, breed, age, gender, description, added_by)
VALUES ('Cau Vang',1000.00, 'Dog', 'Golden Retriever', 3, 'Male', 'Friendly and energetic. Good with kids.', 'tus');

INSERT INTO PETS (pet_id, name, price, type, breed, age, gender, description, added_by)
VALUES (2, 'Charlie', 300.00, 'Cat', 'Persian', 2, 'Male', 'A fluffy Persian cat, perfect for indoors.','sang' );

INSERT INTO PETS (pet_id, name, price, type, breed, age, gender, description, added_by)
VALUES (3, 'Tweety', 50.00, 'Bird', 'Canary', 1, 'Female', 'A bright yellow canary with a melodious voice.', 'tus');

INSERT INTO PETS (pet_id, name, price, type, breed, age, gender, description, added_by)
VALUES (4, 'Max', 450.00, 'Dog', 'Beagle', 4, 'Male', 'A curious and friendly dog, loves to explore.', 'tus');

INSERT INTO PETS (name, price, type, breed, age, gender, description, added_by)
VALUES ('Luna', 250.00, 'Cat', 'Siamese', 3, 'Female', 'A striking Siamese cat with blue eyes.', 'sang');


SELECT * FROM PETS;
SELECT * FROM USERS;

DROP TABLE PETS;



