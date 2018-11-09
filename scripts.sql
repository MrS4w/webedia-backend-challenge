INSERT INTO `artigo` (`id`, `conteudo`, `data_publicacao`, `subtitulo`, `titulo`, `ultima_atualizacao`) VALUES 
(NULL, 'conteudo do artigo1', '2018-11-09 00:00:00', 'subtitulo artigo1', 'titulo artigo1', '2018-11-10 00:00:00'), 
(NULL, 'conteudo do artigo2', '2018-11-09 00:00:00', 'subtitulo artigo2', 'titulo artigo2', '2018-11-10 00:00:00');


INSERT INTO `autor` (`id`, `nome`) VALUES (NULL, 'Victor'), (NULL, 'Antonio'), (NULL, 'Barbosa'), (NULL, 'Silva');

INSERT INTO `comentario` (`id`, `comentario`) VALUES (NULL, 'Gostei'), (NULL, 'Nota 10'), (NULL, 'Muito bom'), (NULL, 'Ajudou muito'), (NULL, 'Bem escrito');

INSERT INTO `artigo_comentario` (`comentario_id`, `artigo_id`) VALUES ('1', '1'), ('2', '1'), ('3', '2'), ('4', '2'), ('5', '2');

INSERT INTO `artigo_autor` (`autor_id`, `artigo_id`) VALUES ('1', '1'), ('2', '2'), ('3', '2'), ('4', '2');
