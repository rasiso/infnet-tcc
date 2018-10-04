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

insert into turma (id, codigo, nome, inicio, termino, id_modulo, id_professor) values (1, 'TRM001', 'Java Web com JSF',CURRENT_DATE, CURRENT_DATE, 1, 1);  
insert into turma (id, codigo, nome, inicio, termino, id_modulo, id_professor) values (2, 'TRM002', 'Usando Rest no Java',CURRENT_DATE, CURRENT_DATE, 2, 2); 
insert into turma (id, codigo, nome, inicio, termino, id_modulo, id_professor) values (3, 'TRM003', 'Java Básico',CURRENT_DATE, CURRENT_DATE, 3, 3);
insert into turma (id, codigo, nome, inicio, termino, id_modulo, id_professor) values (4, 'TRM004', 'Scrum',CURRENT_DATE, CURRENT_DATE, 4, 4); 
insert into turma (id, codigo, nome, inicio, termino, id_modulo, id_professor) values (5, 'TRM005', 'Inteligência Artificial com Java e Weka', CURRENT_DATE, CURRENT_DATE, 5, 5); 

insert into aluno (id, matricula, sexo, nome, email) values (1, 'ALN001', 'Masculino', 'Aluno Nome I'  , 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (2, 'ALN002', 'Feminino',  'Aluno Nome II' , 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (3, 'ALN003', 'Feminino',  'Aluno Nome III', 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (4, 'ALN004', 'Masculino', 'Aluno Nome IV' , 'email_aluno@email.com');
insert into aluno (id, matricula, sexo, nome, email) values (5, 'ALN005', 'Feminino',  'Aluno Nome V'  , 'email_aluno@email.com');
INSERT INTO aluno (id, matricula, sexo, nome, email) VALUES (6, 'ALN006', 'Masculino', 'Walter Almeida', 'infnet.tcc@gmail.com');
INSERT INTO aluno (id, matricula, sexo, nome, email) VALUES (7, 'ALN007', 'Feminino',  'Aluna Hackeada', 'infnet.tcc@gmail.com');

INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,1);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,2);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,3);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,4);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (1,5);

INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (2,6);
INSERT INTO turma_x_aluno (id_turma, id_aluno)  VALUES (2,7);

insert into categoria_questao (id, nome) values (1, 'Avaliação geral da Pós-Graduação');
insert into categoria_questao (id, nome) values (2, 'Avaliação do professor no módulo');
insert into categoria_questao (id, nome) values (3, 'Avaliação de conteúdo e infra-estrutura no módulo');

insert into questao (id, enunciado, categoria_id) values (1, 'Até agora, o curso está atingindo as minhas expectativas', 1);
insert into questao (id, enunciado, categoria_id) values (2, 'Até agora, eu indicaria o curso para um amigo', 1);
insert into questao (id, enunciado, categoria_id) values (3, 'Até agora, o curso me parece voltado para as necessidades do mercado', 1);
insert into questao (id, enunciado, categoria_id) values (4, 'Até agora, a coordenação pedagógica parece comprometida com a qualidade do curso', 1);
insert into questao (id, enunciado, categoria_id) values (5, 'Até agora, minha turma parece proporcionar um networking relevante para a minha carreira', 1);
insert into questao (id, enunciado, categoria_id) values (6, 'Até agora, o atendimento de Secretaria que recebi está atingindo as expectativas', 1);

insert into questao (id, enunciado, categoria_id) values (7, 'O professor contribuiu para o meu aprendizado', 2);
insert into questao (id, enunciado, categoria_id) values (8, 'O professor é atencioso e esteve disponível para tirar dúvidas', 2);
insert into questao (id, enunciado, categoria_id) values (9, 'O professor aproveitou bem o tempo em sala de aula', 2);
insert into questao (id, enunciado, categoria_id) values (10, 'O professor utilizou o Moodle e outros recursos didáticos para ajudar no meu aprendizado', 2);
insert into questao (id, enunciado, categoria_id) values (11, 'O professor aproveitou bem os recursos da sala de aula', 2);
insert into questao (id, enunciado, categoria_id) values (12, 'Gostaria de cursar outros módulos com esse professor', 2);

insert into questao (id, enunciado, categoria_id) values (13, 'Eu adquiri as competências propostas para o módulo', 3);
insert into questao (id, enunciado, categoria_id) values (14, 'O módulo foi útil para o meu crescimento profissional', 3);
insert into questao (id, enunciado, categoria_id) values (15, 'A carga horária do módulo foi apropriada', 3);
insert into questao (id, enunciado, categoria_id) values (16, 'O acervo da biblioteca atendeu as necessidades desse módulo', 3);
insert into questao (id, enunciado, categoria_id) values (17, 'A configuração do(s) computadore(s) e equipamentos da sala de aula e a qualidade do suporte foi apropriada', 3);

insert into modelo_avaliacao (id, assunto_email, codigo, mensagem_email, objetivo) values (1, 'Infnet - Avaliação da Disciplina <turma> - <modulo>', 'Q20180912121300', 'Prezad<o/a> <aluno>, \nPor favor, avalie a Disciplina <turma> - <modulo>! \nLink: <link>', 'Avaliar a Disciplina');

insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 1);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 2);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 3);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 4);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 5);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 5);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 6);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 7);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 8);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 9);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 10);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 11);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 12);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 13);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 14);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 15);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 16);
insert into modelo_avaliacao_x_questao (id_modelo_avaliacao, id_questao) values (1, 17);

insert into avaliacao (id, codigo, inicio, termino, id_modelo, id_turma) values (1, 'AVALIACAO001', CURRENT_DATE, CURRENT_DATE, 1, 2);

INSERT INTO formulario (id, convite_enviado, respondido, id_avaliacao, id_aluno) VALUES ('1', b'0', b'0', b'1', b'1');
INSERT INTO formulario (id, convite_enviado, respondido, id_avaliacao, id_aluno) VALUES ('2', b'0', b'0', b'1', b'2');

INSERT INTO resposta (id, id_aluno, id_formulario, id_questao, valor) VALUES ('1', '1', '1', '1', '3');
INSERT INTO resposta (id, id_aluno, id_formulario, id_questao, valor) VALUES ('2', '1', '1', '2', '1');
INSERT INTO resposta (id, id_aluno, id_formulario, id_questao, valor) VALUES ('3', '1', '1', '3', '2');
INSERT INTO resposta (id, id_aluno, id_formulario, id_questao, valor) VALUES ('4', '1', '1', '4', '1');
INSERT INTO resposta (id, id_aluno, id_formulario, id_questao, valor) VALUES ('5', '1', '1', '5', '4');




INSERT INTO role(role_id,role) VALUES (1,'ADMIN');
INSERT INTO role(role_id,role) VALUES(2,'USER');
 
INSERT INTO user (user_id,email, name, last_name,password,active) VALUES (1,'maaupe@gmail.com','Marcos', '','$2a$10$yAKeqZAXcD93UbtjaWGnju.Xaq/abUPLk7kq/dfdBWV.KgXaOpI5W' ,1);
INSERT INTO user (user_id,email, name, last_name,password,active) values (2,'aluno@infnet.com.br','rafael','', '$2a$10$yAKeqZAXcD93UbtjaWGnju.Xaq/abUPLk7kq/dfdBWV.KgXaOpI5W',1);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1), (2, 1);