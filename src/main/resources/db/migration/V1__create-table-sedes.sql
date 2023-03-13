CREATE TABLE tb_sedes(
	sede_id SERIAL PRIMARY KEY,
	pais VARCHAR(255) NOT NULL,
	uf VARCHAR(255) NOT NULL,
	cidade VARCHAR(255),
	logradouro VARCHAR(255),
	numero INTEGER,
	cep INTEGER,
	complemento VARCHAR(255)
);