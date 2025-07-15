CREATE TABLE Hardware (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(255) NOT NULL UNIQUE,
    price FLOAT,
    type VARCHAR(255),
    quantity INT
);

CREATE TABLE Category (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE Article (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price FLOAT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Category(id)
);
