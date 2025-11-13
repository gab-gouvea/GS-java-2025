# 🌍 Plataforma de Upskilling e Reskilling 2030+
### Global Solution 2025 – O Futuro do Trabalho
**Curso:** Engenharia de Software  
**Integrantes:** Gabriel Gouvea, Thiago Ferreira e Miguel Kapicius 

---

## 📘 Contexto

O futuro do trabalho está sendo transformado por tecnologias como **Inteligência Artificial**, **automação** e **ambientes híbridos**.  
Ao mesmo tempo, cresce a necessidade de:

- **Requalificação (reskilling)** de profissionais com atividades em risco de automação.  
- **Aperfeiçoamento contínuo (upskilling)** para acompanhar novas demandas do mercado.  
- **Educação permanente**, focada em competências tecnológicas e humanas.

Essa API foi desenvolvida para apoiar esses objetivos, permitindo que pessoas se cadastrem, acessem trilhas de aprendizagem e se preparem para as **profissões de 2030+**.

---

## 🎯 Objetivo

Desenvolver uma **API RESTful** em **Java + Spring Boot** que permita:
- Cadastro de usuários na plataforma;
- Consulta e gerenciamento de trilhas de aprendizagem;
- Segurança por autenticação **JWT**;
- Persistência em banco de dados relacional (**MySQL**).

A solução está alinhada com os **Objetivos de Desenvolvimento Sustentável (ODS)**:
- **ODS 4:** Educação de qualidade  
- **ODS 8:** Trabalho decente e crescimento econômico  
- **ODS 9:** Indústria, inovação e infraestrutura  
- **ODS 10:** Redução das desigualdades  

---

## 🧩 Estrutura do Projeto

O projeto segue uma **arquitetura em camadas**:
Controller → Service → Repository → Database


### 📂 Pacotes principais

- `controller/` → Recebe e responde às requisições HTTP.  
- `service/` → Regras de negócio e validações.  
- `repository/` → Comunicação com o banco de dados via JPA.  
- `model/` → Entidades do domínio (`Usuario`, `Trilha`, `Inscricao`).  
- `security/` → Configuração JWT e autenticação.  
- `dto/` → Objetos de transferência de dados com validações (`@NotBlank`, `@Email`, etc.).  
- `exception/` → Exceções customizadas e tratamento global.

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Versão / Observação |
|-------------|---------------------|
| **Java** | 21 |
| **Spring Boot** | 3.5.7 |
| **Spring Data JPA** | Persistência com MySQL |
| **Spring Security + JWT** | Autenticação e Autorização |
| **Bean Validation (Jakarta Validation)** | Validação de campos |
| **Swagger / Springdoc OpenAPI** | Documentação da API |
| **MySQL** | Banco relacional |
| **Maven** | Gerenciador de dependências |

---

## 🗄️ Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/futuro_trabalho
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

```
O banco é criado automaticamente ao subir o projeto.

## 🚀 Como Executar o Projeto

Clonar o repositório:

```bash 
git clone https://github.com/seu-usuario/futuro-trabalho-api.git
cd futuro-trabalho-api
```

Acessar o swagger: 
```bash
http://localhost:8080/swagger-ui.html
```



