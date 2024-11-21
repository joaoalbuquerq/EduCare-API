# EduCareAPI

EduCareAPI é uma API RESTful desenvolvida para a EduCare, oferecendo funcionalidades para gerenciamento de dados educacionais. O projeto é construído com Java 17 e Spring Boot, utilizando PostgreSQL como banco de dados. Esta API possui uma documentação integrada, facilitando o entendimento e uso dos seus endpoints.

## Funcionalidades

- Gerenciamento de dados educacionais
- Validação de dados com Spring Boot Validation
- Migração de banco de dados com Flyway
- Documentação automática com OpenAPI
- Testes automatizados utilizando Spring Boot Starter Test

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **PostgreSQL**
- **Flyway** para controle de versão do banco de dados
- **Lombok** para reduzir o boilerplate do código
- **Springdoc OpenAPI** para geração de documentação
- **Docker** para execução de serviços de forma contêinerizada

## Requisitos

Para executar a EduCareAPI localmente, você precisará ter instalado:

- **Docker**
- **Docker Compose**

## Configuração

Clone o repositório para o seu ambiente local:

```bash
git clone https://github.com/joaoalbuquerq/EduCare-API.git
cd EduCare-API
```


## Executando a Aplicação

### Com Docker Compose
EduCareAPI inclui um arquivo docker-compose.yml para facilitar a configuração do banco de dados PostgreSQL e execução da API. Para iniciar a aplicação, execute:
```bash
docker-compose up -d
```

### Sem docker compose

Caso prefira executar a API sem Docker, configure as variáveis de ambiente no arquivo application.properties ou application.yml para apontar para o seu banco de dados PostgreSQL. Depois, compile e inicie a aplicação com os comandos:
```bash
./mvnw clean install
./mvnw spring-boot:run
```


## Documentação da API 

A documentação da API está disponível em formato OpenAPI, gerada automaticamente com Springdoc OpenAPI.

* Acesso à Documentação: Após iniciar a aplicação, você pode acessar a documentação interativa da API na URL:
```bash
http://localhost:8080/swagger-ui/index.html
```
A documentação fornece detalhes sobre todos os endpoints disponíveis, incluindo métodos HTTP, parâmetros, e exemplos de resposta.

## Contribuição

1. Realize um fork do repositório
2. Crie uma nova branch (git checkout -b feature/nova-funcionalidade)
3. Commit suas mudanças (git commit -m 'Adiciona nova funcionalidade')
4. Faça o push da branch (git push origin feature/nova-funcionalidade)
5. Abra um Pull Request

## <span style="color:red;">Limitações</span>
<p>
    O build do container docker pelo docker-compose.yml está em conflito com a aplicação, ou seja, a API não se conecta ao Banco em container.
    <span style="color:yellow;">Uma alternativa é buildar seu próprio container postgres com os comandos que seguem:</span>
</p>

```bash
# baixar a imagem do postgres
docker pull postgres:15

# rode o banco em background
docker run --name banco-educare -dt -e POSTGRES_PASSWORD=senha -p 65530:5432 postgres:15

# acesse o terminal interativo
docker exec -it banco-educare /bin/bash
```