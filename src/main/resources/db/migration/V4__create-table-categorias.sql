CREATE TABLE tb_categorias(
	categoria_id SERIAL PRIMARY KEY,	
	codigo_Natureza_Juridica INTEGER,
	descricao_Natureza_Juridica VARCHAR(255),
	codigo_Atividade_Comercial INTEGER,
	descricao_Atividade_Comercial VARCHAR(255)

);