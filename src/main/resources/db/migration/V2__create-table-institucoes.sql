CREATE TABLE tb_instituicoes(
	instituicao_id SERIAL PRIMARY KEY,
	tipo_instituicao VARCHAR(255) NOT NULL,
	fundador VARCHAR(255) NOT NULL,
	data_fundacao DATE NOT NULL,
	presidente VARCHAR(255),
	representante VARCHAR(255),
	diretor VARCHAR(255)
);