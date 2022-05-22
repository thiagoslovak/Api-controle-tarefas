## API controle-tarefas

Api desenvolvida utilizando padrões REST e MVC:

- Java 11.
- PostgreSql.
- Spring Boot.
- Spring Data.
- Junit.
- Docker.

### Instruções de uso da aplicação:

- Import o arquivo [controle-tarefas.postman_collection.json](https://github.com/thiagoslovak/Api-controle-tarefas/blob/master/controle-tarefas.postman_collection.json), no Postman.
- Usando Docker:
  - Vá até a pasta src/main/docker e rode esse comando no CLI : docker-compose up. Irá subir a aplicação no docker com o banco de dados.

- Com aplicação rodando e já importado a collection, vá até o Postman.

  - Recomendo começar pelo Usuário:

    - Primeiro de um POST para cadastra um usuário.
    - Segundo de um GET e verifique que foi cadastrado o usuário.
    - Terceiro de um novo POST com o mesmo usuário, para poder testar o PUT.
    - Quarto de um PUT, e verifique com o GET que o usuário foi atualizado.
    - Quinto de um DELETE, e verifique com o GET que o usuário foi deletado.

    

  - Projeto:

    - Primeiro de um POST para cadastra um projeto.
    - Segundo de um GET e verifique que foi cadastrado o projeto.
    - Terceiro de um PUT e verifique com o GET que o projeto foi atualizado.
    - Quarto de um POST com o mesmo projeto para testar o DELETE.
    - Quinto de um DELETE e verifique com o GET que o projeto foi deletado.

    

  - Tarefa:

    - Seguindo a historia do teste:

      - Como usuário eu preciso cadastrar uma tarefa:

        - Primeiro de um POST para cadastrar um tarefa.

          

      - Como usuário eu preciso visualizar as tarefas ordenadas de acordo com o status:

        - Primeiro de um GET - VisualizarTarefa(status).

          

      - Como usuário eu desejo receber as tarefas PENDENTES organizadas de forma que a duração de todas as tarefas não ultrapasse o limite diário estabelecido:

        - Primeiro de um GET - VisualizarTarefaLimiteDiario(nome).

      

      - Como usuário eu preciso visualizar quais as tarefas PENDENTES de um determinado período de tempo:

        - Primeiro de um GET - VisualizarTarefaPendente(data).

          

      - Como usuário eu desejo visualizar tarefas vinculadas a um determinado Projeto:

        - Primeiro de um GET - VisualizarTarefaViculadaProjeto.

          

      - Testando o PUT:

        - Primeiro de um novo POST para testar o PUT.

        - Segundo de um PUT e um GET - VisualizarTarefa, para verificar que foi atualizado.

          

      - Testando o DELETE:

        - Primeiro de um novo POST para testar o DELETE.
        - Segundo de um DELETE e um GET - VisualizarTarefa, para verificar que foi deletado.

      

​	
