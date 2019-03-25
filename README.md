# Back-end Challenge
## Desafio proposto pela [@webedia-brasil](https://github.com/webedia-brasil)
### O desafio consiste em criar uma API REST para um blog onde irá conter artigos, autores e comentários.
Para rodar a API você precisa ter instalado o [STS](https://spring.io/tools) e um banco de dados MySQL rodando, recomendo o [XAMPP](https://www.apachefriends.org/download.html), baixe o projeto do GitHub :octocat: ou dê um clone nele para seu repositório local <code>git clone https://github.com/MrS4w/webedia-backend-challenge.git</code> com seu servidor de banco de dados rodando, crie um banco de dados chamado "blog", se caso precisar mudar configurações como login vá em [application.properties](https://github.com/MrS4w/API-REST/blob/master/src/main/resources/application.properties "application.properties")  que fica dentro da pasta [src/main/resourses](https://github.com/MrS4w/API-REST/tree/master/src/main/resources) e altere seus dados de login e senha para o banco de dados, com o banco já rodando abra seu STS, importe o projeto, espere o Maven baixar as dependências, clique com o botão direito em cima do projeto, em seguida cliquem em "Run As" e depois em "Spring Boot App" e por último rode a base de teste no formato SQL do arquivo `scripts.sql`.
<br/>Após isso tudo, você já pode testar a API com o [Postman](https://www.getpostman.com/apps).<br/>
### Endpoints:<br/>
- #### Para todos os artigos: <code>localhost:8080/artigos</code> <br/>
- #### Para todos os autores: <code>localhost:8080/autores</code> <br/>
- #### Para todos os comentários: <code>localhost:8080/comentarios</code> <br/>
- #### Para artigos específicos: <code>localhost:8080/artigos/artigoID</code> <br/>
- #### Para autores específicos: <code>localhost:8080/autores/autorID</code> <br/>
- #### Para comentários específicos: <code>localhost:8080/comentarios/comentarioID</code> <br/>
_(Basta trocar "ID" pelo atributo "id" do registro ex: artigo1, autor2, comentario3, etc)_ <br/>
##### Exemplo de paginação com parâmentros:<br>
<code>localhost:8080/endpoint/page?linesPerPage=2&page=1&direction=DESC</code> <br/>
### Sumário:
- #### _endpoint_: artigos, autores ou comentarios. <br />
- #### _linesPerPage_: São a quantidade de resultados por página. (padrão 24) <br/>
- #### _page_: Página que deseja visualizar. (padrão 0) <br/>
- #### _direction_: Ordem crescente (ASC) ou decrescente (DESC). (padrão ASC)
