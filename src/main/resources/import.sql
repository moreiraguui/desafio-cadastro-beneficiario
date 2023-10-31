INSERT INTO beneficiario(nome, telefone, data_nascimento) VALUES ('Guilherme','12345-33', '23-12-1997');
INSERT INTO beneficiario(nome, telefone, data_nascimento) VALUES ('Joao','99999-34', '13-10-1995');

INSERT INTO documento(beneficiario_id, tipo_documento, descricao) VALUES (1, 'RG', '1234567-89');
INSERT INTO documento(beneficiario_id, tipo_documento, descricao) VALUES (1, 'CPF', '1234567-89');
INSERT INTO documento(beneficiario_id, tipo_documento, descricao) VALUES (2, 'CARTEIRA TRABALHO', '1234567-89');
INSERT INTO documento(beneficiario_id, tipo_documento, descricao) VALUES (2, 'CERTIDAO', '1234567-89');