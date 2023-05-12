DROP DATABASE IF EXISTS movie_app;

CREATE DATABASE movie_app;

USE movie_app;

CREATE TABLE
    content (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(150) NOT NULL UNIQUE,
        resume TEXT NOT NULL,
        short_resume VARCHAR(255),
        release_year YEAR NOT NULL,
        type VARCHAR(50) NOT NULL,
        image_path VARCHAR(200) UNIQUE
    );

CREATE TABLE
    category(
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(50)
    );

CREATE TABLE
    content_category(
        content_id INT NOT NULL,
        category_id INT NOT NULL,
        PRIMARY KEY(content_id, category_id),
        FOREIGN KEY (content_id) REFERENCES content (id),
        FOREIGN KEY (category_id) REFERENCES category (id)
    );