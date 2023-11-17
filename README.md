# Desafio Programador Fullstack Unoesc

Esse é o nosso desafio para a vaga de programador fullstack na [Unoesc](https://www.unoesc.edu.br/). Serão testadas as habilidades e qualidade de código ao transformar requisitos limitados em uma aplicação web.

## DESAFIO

Você terá que desenvolver uma aplicação web responsável por registrar pessoas e seus dados de contato e endereço. Para esse cadastro é muito importante que o endereço preenchido seja um endereço válido. Portanto, torna-se necesária a validação do CEP e preenchimento do endereço através da API ViaCEP. 

Documentação da API disponível aqui: https://viacep.com.br

### ESCOPO DO DESAFIO

**Requisitos**
- O cadastro de pessoas deve conter: Nome, CPF, data de nascimento e gênero; 
- O cadastro de contato deve conter: Telefone e enderereço de e-mail;
- O cadastro de endereço deve conter: CEP, logradouro, número, bairro, município e estado;
  -  O CEP deve ser validado e o endereço deve ser autocompletado pela API;
  - Após o preenchimento do CEP apenas as inforamções que não são retornadas da API podem ser editadas, as demais devem ser bloqueadas para edição. 
- Deve ser possível consultar, editar e excluir os cadastros;
- A aplicação deve ser protegida por um login. Porém, não é necessário que exista uma tela para cadastro de usuários.

**Atenção!**
- Não há requisitos quando ao formato de exibição das telas de cadastro e consulta, fica livre a escolha do candidato.
- Versionar o projeto realizando commits com comentários do que está sendo implementado;
- Soluções parciais serão aceitas, porém o que for submetido deve estar funcionando.
- Documentar todas as suposições realizadas sobre o desafio no arquivo README.md.
  - Exemplo de suposição: "Não é obrigatório o preenchimento do endereço de e-mail no cadastro do endereço". 

Para auxiliar no entendimento, elaboramos um diagrama de classes simples contendo apenas classes e atributos: 

![diagramadeclasse](https://user-images.githubusercontent.com/4011040/197817709-3e4cfb77-e863-4096-a610-8290f71b8aef.png)

**Tecnologias a serem utilizadas:**
- Java;
- Spring Boot;
- Maven;
- Thymeleaf;
- MySQL 5.7.X;
- GIT;

### AVALIAÇÃO

**O código será avaliado de acordo com os critérios:**
- Build e execução da aplicação;
- Completude das funcionalidades;
- Qualidade de código (design pattern, manutenibilidade, clareza); 
- Histórico do GIT; 
- Boas práticas de UI (Interface com o Usuário);
- Sentido e coerência nas respostas aos questionamentos na entrevista de apresentação do desafio realizada pelo candidato.

**Não esqueça de documentar o processo necessário para rodar a aplicação.**

### Como rodar a aplicacao

Partindo do Banco de dados -  caso ja tenha algum banco para testar a aplicao, alterar o url(conexao) no application.properties, caso contrario criar database e configurar no application.properties.
Em tese ao rodar a aplicacao sera verificado se existe as tabelas e as colunas, caso exista sera verificado a diferenca caso tenha colunas diferentes. Em resumo a aplicacao criara as tabelas automaticamente.

A aplicacao foi desenvolvida seguindo os requitos, Java, spring boot, maven .....
Antes de rodar a aplicacao rodar um clean, e outros comandos que achar pertinente, no maven.

Foi desenvolvido usando o VisualStudio Code, entao no caso uso o F5 atalho para Run debugging, aparecendo uma mensagem semelhante a essa no terminal (Hibernate: select count(*) from usuario u1_0 )  a aplicaco esta rodando.

Localizada no dominio http://localhost:8080/login (a porta pode variar conforme configuracao)
 para fazer o login, foi criado 3 usuarios pre cadastrados, localizados no DataInitializer.java. 

Apos login sera encaminhado para a pagina home, onde é listado todas as pessoas cadastradas( usuarios pre cadastrados estao em outra tabaela como se fosse adm)
A botao de Cadastro de pessoa, para fazer o cadastro da pessoa.
para acessar as outras telas de cadastro, o usuario deve voltar para a tela home, clicar no nome da pessoa que deseja adicionar informações.
Assim sera encaminhado para outra tela, tendo a escolha de adicionar contatos e enderecos, a 2 accordions para exibir os dados ja cadastrados.
Os botoes aparentes nas telas sao funcionais e fazem sua respectiva funcao.



### Comentarios / suposições 
Requisito 5 -  supus a possibilidade de pre cadastrar usuarios para fazer o login, nao havendo necessidade de criar uma tela para cadastro de usuario. supondo tambem um ambiente onde apenas certos usuairos podem fazer cadastro e edicao de dados das pessoas.

Alguns campos dos cadastros nao sao obrigatorios. 

Como fiz a pouco tempo o TCC nos mesmos modelos, tive reutilizacao de codigo, principalmente no html e CSS 

Script do Banco se encontra em Banco de dados/ ScriptDB

