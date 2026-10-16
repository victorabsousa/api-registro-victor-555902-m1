# API Registro Meteorológico

API REST para gerenciamento de registros meteorológicos, desenvolvida com Java 25 e Spring Boot 4.0.8.

O projeto utiliza H2 para testes, MySQL para persistência dos dados e Flyway para controle das migrations.

## Tecnologias

- Java 25
- Spring Boot 4.0.8
- Spring Data JPA
- H2 / MySQL 8.4
- Flyway
- Swagger
- Docker

## Executando a aplicação

### H2 (test)

No terminal PowerShell, na pasta do projeto:

```powershell
$env:SPRING_PROFILES_ACTIVE="test"
.\mvnw.cmd spring-boot:run
```

### MySQL (dev)

Com o Docker Desktop aberto, iniciar o MySQL:

```powershell
docker compose up -d mysql
```

Executar a aplicação:

```powershell
$env:SPRING_PROFILES_ACTIVE="dev"
.\mvnw.cmd spring-boot:run
```

As migrations são executadas pelo Flyway durante a inicialização com o perfil dev.

## Docker

Construir a imagem:

```powershell
docker build -t api-registro-victor .
```

Executar utilizando H2:

```powershell
docker run --rm -p 8080:8080 -e SPRING_PROFILES_ACTIVE=test api-registro-victor
```

Executar utilizando MySQL, com o banco iniciado:

```powershell
docker run --rm -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev -e "DB_URL=jdbc:mysql://host.docker.internal:3306/registro_meteorologico" -e DB_USERNAME=root -e DB_PASSWORD=root api-registro-victor
```

A porta 8080 deve estar livre antes de iniciar o container.

## Endpoints

| Método | Rota |
|---|---|
| GET | /api/registros |
| GET | /api/registros/{id} |
| POST | /api/registros |
| PUT | /api/registros/{id} |
| DELETE | /api/registros/{id} |

Documentação Swagger:

http://localhost:8080/swagger-ui.html

## Migrations

Os scripts SQL ficam em `src/main/resources/db/migration`.

- V1: criação da tabela.
- V2: inserção dos três registros iniciais.

## Autor

Victor Andrade Baptista de Sousa  
RM: 555902
