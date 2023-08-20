CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    url_stream VARCHAR(255) NOT NULL
);

INSERT INTO movies (name, genre, url_stream) VALUES ('El señor de los anillos', 'Fantasia', 'https://www.youtube.com/watch?v=V75dMMIW2B4');
INSERT INTO movies (name, genre, url_stream) VALUES ('Harry Potter', 'Fantasia', 'https://www.youtube.com/watch?v=V75dMMIW2B4');
INSERT INTO movies (name, genre, url_stream) VALUES ('Star Wars', 'Ciencia Ficcion', 'https://www.youtube.com/watch?v=V75dMMIW2B4');
INSERT INTO movies (name, genre, url_stream) VALUES ('El señor de los anillos 2', 'Fantasia', 'https://www.youtube.com/watch?v=V75dMMIW2B4');
INSERT INTO movies (name, genre, url_stream) VALUES ('Todo poderoso', 'Comedia', 'https://www.youtube.com/watch?v=V75dMMIW2B4');