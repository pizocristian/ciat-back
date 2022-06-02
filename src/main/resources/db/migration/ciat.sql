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

CREATE TABLE roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100),
  password VARCHAR(100),
  username VARCHAR(100)
);

CREATE TABLE user_roles (
  user_id INT,
  role_id INT,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id)
);