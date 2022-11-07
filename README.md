# Beyond Banking Back

# 1. Instalando dependências

É necessário que vocÊ possuo o [Docker](https://docs.docker.com/desktop/install/windows-install/), o [Maven](https://maven.apache.org/download.cgi) e o [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) instalados em seu computador para executar o projeto.

Após a instalação de ambos também será necessário instalar o [PostgreSQL](https://www.postgresql.org/download/) e (talvez) um SGDB para auxiliar na criação dos schemas

Com o Postgres instalado é necessário criar o seguinte banco de dados com os seguintes schemas:
Nome banco de dados:

- beyond-banking

Nome schemas:

- usuario
- servico

O próximo passo é iniciar o [Apache Kafka](https://kafka.apache.org). Por sorte não precisamos baixar este, para inicia-lo basta clonar esté repositório com:

```console
git clone https://github.com/KhawanC/beyond-banking-back
```

Logo após, dentro da pasta do repositório executar o comando:

```console
docker compose up -d
```

Com isso será baixado e iniciado os containers Docker do Kafka e do Zookeeper

# 2. Iniciando aplicação

Para iniciar a aplicação você tem 2 opções, utilizando alguma IDE (Eclipse ou InteliJ) ou compilar o projeto. Se você instalou o Maven dentro de alguma API execute o comando:

```console
mvn clean package -Dmaven.test.skip=true
```

Após isso, localize o arquivo .jar dentro da pasta da API e execute o comando: 

```console
nohup java -jar {nome/caminho_do_arquivo_dentro_do_target}.jar &
```

Caso você possua uma IDE, apenas executea por ela.

## Aviso

Atente-se de que a ordem para iniciar as APIs são:

1 - eureka

2 - gateway

3 - servicos

3 - usuario

O Eureka precisa de alguns segundos para ser levantando, caso alguma outra API caia pode ser por conta do tempo que o Eureka demora para carregar.

# 3. Utilizando as APIs

Nome das APIs (será utilizado pelo gateway):

* - usuario: bynd-usuario
* - servico: bynd-servico

Todas as APIs possuem o Open Api (Interface para documentação) instalados. Para consultar a documentação de cada acesse:

1 - Eureka API: http://localhost:8761 (Possui interface)

2 - Gateway API: http://localhost:8765/{nome_da_api}/{end_point} (Não possui interface)

3 - Usuario API: http://localhost:{porta_api}/{end_point} (Possui interface)

4 - Servico API: http://localhost:{porta_api}/{end_point} (Possui interface)

As portas para as APIs de Usuario e Servico são **ALEATORIAS**, portando, você deve consultalas ou nos logs da aplicação ou pela sua IDE.
Por outro lado, o gateway permite que as APIs sejam chamados apelas pelo seu **NOME**, sendo possível subir mais de uma instancia de uma mesma API para realizar balanceamento de carga
**NÃO** é possível acessar a interface do Open API de outras APIs pelo gateway, somente os endpoint

Ao acessar o Open API vocÊ irá se deparar com:
![Exemplo Open API](https://imgur.com/1vMsmtv.png)

![Exemplo 2 Open API](https://imgur.com/ePaRucD.png)


# 4. Jornadas

API de Usuario:

* - As roles são criadas automáticamente ao inicializar a API, com um enum possuindo: 	ROLE_ADMIN, ROLE_INSTITUICAO, ROLE_RESPONSAVEL, ROLE_ESTUDANTE
* - Endpoints para criação de usuário **RESPONSAVEL** e **ESTUDANTE** no 'usuario-resource'
* - Endpoints para adicionar dependentes ao responsavel no 'responsavel-resource'
* - Endpoint para criar uma instituição e adicionar matriculas no 'instituicao-resource'

API de Serviço:

* - Endpoint para criação de extrato, onde o saldo do extrato é descontado do saldo do usuário
* - Endpoint para criação de atividades, onde o campo 'premio' é o crédito que o estudante ganhará ao completar uma atividade
* - Endpoint para concluir uma atividade para resgatar o estudante pelo cpf e adicionar os créditos a sua conta