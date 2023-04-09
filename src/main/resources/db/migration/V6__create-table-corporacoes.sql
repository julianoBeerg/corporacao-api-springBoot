CREATE TABLE tb_corporacoes(
	corporacao_id SERIAL PRIMARY KEY,
	cnpj VARCHAR(30) NOT NULL UNIQUE,
	razao_social VARCHAR(255) NOT NULL UNIQUE,
	nome_fantasia VARCHAR(255),
	tipo_publico BOOLEAN NOT NULL,
	multinacional BOOLEAN NOT NULL,
	faturamento DECIMAL NOT NULL,
	num_funcionarios INTEGER NOT NULL,
	cnpj_ativo BOOLEAN NOT NULL,
	instituicao_id INTEGER,
	porte_id INTEGER,
	categoria_id INTEGER,
	sede_id INTEGER,
	
	FOREIGN KEY (instituicao_id)
	REFERENCES tb_instituicoes(instituicao_id),
	
	FOREIGN KEY (porte_id)
	REFERENCES tb_portes(porte_id),
	
	FOREIGN KEY (categoria_id)
	REFERENCES tb_categorias(categoria_id),
	

	FOREIGN KEY (sede_id)
	REFERENCES tb_sedes(sede_id)

);