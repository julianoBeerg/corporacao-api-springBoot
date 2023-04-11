CREATE TABLE TB_CORPORACAO(
	PK_ID_CORPORACAO SERIAL PRIMARY KEY,
	VAR_CNPJ VARCHAR(30) NOT NULL UNIQUE,
	VAR_RAZAO_SOCIAL VARCHAR(255) NOT NULL UNIQUE,
	VAR_NOME_FANTASIA VARCHAR(255),
	BOOL_TIPO_PUBLICO BOOLEAN NOT NULL,
	VAR_MULTINACIONAL BOOLEAN NOT NULL,
	BOOL_CNPJ_ATIVO DECIMAL NOT NULL,
	DECIMAL_FATURAMENTO INTEGER NOT NULL,
	INT_NUMERO_FUNCIONARIOS BOOLEAN NOT NULL,
	FK_INSTITUICAO_ID INTEGER,
	FK_PORTE_ID INTEGER,
	FK_ATIVIDADE_COMERCIAL_ID INTEGER,
	FK_NATUREZA_JURIDICA_ID INTEGER,
	FK_SEDE_ID INTEGER,
	
	FOREIGN KEY (FK_INSTITUICAO_ID)
	REFERENCES TB_INSTITUICAO (PK_ID_INSTITUICAO),
	
	FOREIGN KEY (FK_PORTE_ID)
	REFERENCES TB_PORTE(PK_ID_PORTE),
	
	FOREIGN KEY (FK_ATIVIDADE_COMERCIAL_ID)
	REFERENCES TB_ATIVIDADE_COMERCIAL(PK_ID_ATIVIDADE_COMERCIAL),
	
	FOREIGN KEY (FK_NATUREZA_JURIDICA_ID)
	REFERENCES TB_NATUREZA_JURIDICA(PK_ID_NATUREZA_JURIDICA),
	
	FOREIGN KEY (FK_SEDE_ID)
	REFERENCES TB_SEDE(PK_ID_SEDE)

);