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

insert into professor (id, matricula, nome) values (1, 'PRF001', 'Professor Nome I');
insert into professor (id, matricula, nome) values (2, 'PRF002', 'Professor Nome II');
insert into professor (id, matricula, nome) values (3, 'PRF003', 'Professor Nome III');
insert into professor (id, matricula, nome) values (4, 'PRF004', 'Professor Nome IV');
insert into professor (id, matricula, nome) values (5, 'PRF005', 'Professor Nome V');

insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (1, 'TRM001', CURRENT_DATE, CURRENT_DATE, 1, 1);  
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (2, 'TRM002', CURRENT_DATE, CURRENT_DATE, 2, 2); 
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (3, 'TRM003', CURRENT_DATE, CURRENT_DATE, 3, 3);
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (4, 'TRM004', CURRENT_DATE, CURRENT_DATE, 4, 4); 
insert into turma (id, codigo, inicio, termino, id_modulo, id_professor) values (5, 'TRM005', CURRENT_DATE, CURRENT_DATE, 5, 5);  
