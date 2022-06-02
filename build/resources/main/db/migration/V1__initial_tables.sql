CREATE TABLE tb_plaga (
    id_plaga INT AUTO_INCREMENT PRIMARY KEY,
    nombre_plaga VARCHAR(100)
);

CREATE TABLE tb_zona (
    id_zona INT AUTO_INCREMENT PRIMARY KEY,
    nombre_zona VARCHAR(100),
    cantidad_palmas INT,
    id_plaga INT,
    nombre_plaga VARCHAR(100),
    FOREIGN KEY (id_plaga) REFERENCES tb_plaga (id_plaga)
);

