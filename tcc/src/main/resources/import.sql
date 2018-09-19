insert into curso (id, codigo, nome) values (1, 'CRS001', 'Eng. Soft. Java');
insert into curso (id, codigo, nome) values (2, 'CRS002', 'Big Data');
insert into curso (id, codigo, nome) values (3, 'CRS003', 'Arquitetura de Software');
insert into curso (id, codigo, nome) values (4, 'CRS004', 'Gestão de Projetos');
insert into curso (id, codigo, nome) values (5, 'CRS005', 'Administração de Redes');

insert into bloco (id, codigo, nome, curso_id) values (1, 'BLC001', 'Bloco I'  ,1);
insert into bloco (id, codigo, nome, curso_id) values (2, 'BLC002', 'Bloco II' ,2);
insert into bloco (id, codigo, nome, curso_id) values (3, 'BLC003', 'Bloco III',3);
insert into bloco (id, codigo, nome, curso_id) values (4, 'BLC004', 'Bloco IV' ,4);
insert into bloco (id, codigo, nome, curso_id) values (5, 'BLC005', 'Bloco V'  ,5);

insert into modulo (id, codigo, nome, bloco_id) values (1, 'MDL001', 'Módulo I'  ,1);
insert into modulo (id, codigo, nome, bloco_id) values (2, 'MDL002', 'Módulo II' ,2);
insert into modulo (id, codigo, nome, bloco_id) values (3, 'MDL003', 'Módulo III',3);
insert into modulo (id, codigo, nome, bloco_id) values (4, 'MDL004', 'Módulo IV' ,4);
insert into modulo (id, codigo, nome, bloco_id) values (5, 'MDL005', 'Módulo V'  ,5);

insert into professor (id, matricula, nome, sexo) values (1, 'PRF001', 'Professor Nome I', 'Masculino');
insert into professor (id, matricula, nome, sexo) values (2, 'PRF002', 'Professor Nome II', 'Masculino');
insert into professor (id, matricula, nome, sexo) values (3, 'PRF003', 'Professor Nome III', 'Feminino');
insert into professor (id, matricula, nome, sexo) values (4, 'PRF004', 'Professor Nome IV', 'Masculino');
insert into professor (id, matricula, nome, sexo) values (5, 'PRF005', 'Professor Nome V', 'Feminino');

insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (1, 'TRM001', CURRENT_DATE, CURRENT_DATE, 1, 1);  
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (2, 'TRM002', CURRENT_DATE, CURRENT_DATE, 2, 2); 
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (3, 'TRM003', CURRENT_DATE, CURRENT_DATE, 3, 3);
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (4, 'TRM004', CURRENT_DATE, CURRENT_DATE, 4, 4); 
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (5, 'TRM005', CURRENT_DATE, CURRENT_DATE, 5, 5); 

insert into aluno (id, matricula, sexo, nome, email) values (1, 'ALN001', 'Masculino', 'Aluno Nome I'  , 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (2, 'ALN002', 'Feminino',  'Aluno Nome II' , 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (3, 'ALN003', 'Feminino',  'Aluno Nome III', 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (4, 'ALN004', 'Masculino', 'Aluno Nome IV' , 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (5, 'ALN005', 'Feminino',  'Aluno Nome V'  , 'email_aluno@email.com');
INSERT INTO aluno (id, matricula, sexo, nome, email) VALUES (6, 'ALN006', 'Masculino', 'Walter Almeida', 'walter.almeida@al.infnet.edu.br');
INSERT INTO aluno (id, matricula, sexo, nome, email) VALUES (7, 'ALN007', 'Feminino',  'Aluna Hackeada', 'walter.almeida@al.infnet.edu.br');

INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,1);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,2);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,3);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,4);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,5);

INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (2,6);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (2,7);


insert into categoria_questao (id, nome) values (1, 'Categoria 001');
insert into categoria_questao (id, nome) values (2, 'Categoria 002');
insert into categoria_questao (id, nome) values (3, 'Categoria 003');
insert into categoria_questao (id, nome) values (4, 'Categoria 004');
insert into categoria_questao (id, nome) values (5, 'Categoria 005');

insert into questao (id, enunciado, categoria_id) values (1, 'Enunciado da Questão  001', 1);
insert into questao (id, enunciado, categoria_id) values (2, 'Enunciado da Questão  002', 2);
insert into questao (id, enunciado, categoria_id) values (3, 'Enunciado da Questão  003', 3);
insert into questao (id, enunciado, categoria_id) values (4, 'Enunciado da Questão  004', 4);
insert into questao (id, enunciado, categoria_id) values (5, 'Enunciado da Questão  005', 5);

insert into modelo_avaliacao (id, assunto_email, codigo, mensagem_email, objetivo) values (1, 'Infnet - Avaliação da Disciplina - <modulo>', 'Q20180912121300', 'Prezad<o/a> <aluno>, \nPor favor, avalie a Disciplina <modulo>! \nLink: <link>', 'Avaliar a Disciplina');
insert into modelo_avaliacao (id, assunto_email, codigo, mensagem_email, objetivo) values (2, 'Assunto e-mail modelo 2', 'MODEL002', 'Mensagem email modelo 2', 'Objetivo modelo 2');
insert into modelo_avaliacao (id, assunto_email, codigo, mensagem_email, objetivo) values (3, 'Assunto e-mail modelo 3', 'MODEL003', 'Mensagem email modelo 3', 'Objetivo modelo 3');
insert into modelo_avaliacao (id, assunto_email, codigo, mensagem_email, objetivo) values (4, 'Assunto e-mail modelo 4', 'MODEL004', 'Mensagem email modelo 4', 'Objetivo modelo 4');
insert into modelo_avaliacao (id, assunto_email, codigo, mensagem_email, objetivo) values (5, 'Assunto e-mail modelo 5', 'MODEL005', 'Mensagem email modelo 5', 'Objetivo modelo 5');

insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 1);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 2);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 3);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 4);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 5);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (2, 1);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (2, 2);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (2, 3);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (2, 4);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (2, 5);

insert into avaliacao (id, codigo, convite_enviado, inicio, respondida, termino, id_modelo, id_aluno, id_turma) values (1, 'AVALIACAO001', NULL, CURRENT_DATE, NULL, CURRENT_DATE, 1, null, 1);
insert into avaliacao (id, codigo, convite_enviado, inicio, respondida, termino, id_modelo, id_aluno, id_turma) values (2, 'AVALIACAO002', NULL, CURRENT_DATE, NULL, CURRENT_DATE, 2, null, 2);

INSERT INTO role(role_id,role) VALUES (1,'ADMIN');
INSERT INTO role(role_id,role) VALUES(2,'USER');
 
INSERT INTO user (user_id,email, name, last_name,password,active) VALUES (1,'maaupe@gmail.com','Marcos', '','$2a$10$yAKeqZAXcD93UbtjaWGnju.Xaq/abUPLk7kq/dfdBWV.KgXaOpI5W' ,1);
INSERT INTO user (user_id,email, name, last_name,password,active) values (2,'aluno@infnet.com.br','rafael','', '$2a$10$yAKeqZAXcD93UbtjaWGnju.Xaq/abUPLk7kq/dfdBWV.KgXaOpI5W',1);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1), (2, 1);