# Projeto iDoe - API de Doações

O iDoe é uma plataforma de doações que conecta doadores, tanto pessoas físicas quanto empresas, a campanhas de arrecadação. Esta API RESTful, construída com Java e Spring Boot, gerencia todo o back-end da aplicação, desde o cadastro de usuários até a criação e contribuição em pedidos de doação.

---

## 🚀 Deploy & Acesso Online

Esta API está em deploy e pode ser acessada publicamente através do Replit.

* **URL Base da API:** `https://es-idoe.ericksousa5.repl.co`
* **Ambiente de Desenvolvimento (Replit):** [https://replit.com/@ErickSousa5/ES-IDOE](https://replit.com/@ErickSousa5/ES-IDOE)

**Importante:** Ao testar os endpoints abaixo, a URL base `https://es-idoe.ericksousa5.repl.co` já está incluída nos comandos.

---

## 🛠️ Arquitetura e Tecnologias

O projeto segue o padrão **Model-View-Controller (MVC)** e utiliza as seguintes tecnologias:

* **Java 17+**: Linguagem de programação principal.
* **Spring Boot**: Framework para criação da API REST.
* **Spring Data JPA (Hibernate)**: Para persistência de dados e mapeamento objeto-relacional.
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
* **Maven**: Para gerenciamento de dependências e build do projeto.

---

### Diagramas de Sequência

1.  **Listar Doações (`GET /doacoes`)**
    `[Imagem do Diagrama de Sequência para Listar Doações]`

2.  **Cadastrar Pessoa (`POST /usuarios`)**
    `[Imagem do Diagrama de Sequência para Cadastrar Pessoa]`

3.  **Listar Pessoas (`GET /usuarios`)**
    `[Imagem do Diagrama de Sequência para Listar Pessoas]`

4.  **Listar Pessoa Física ou Jurídica (`GET /usuarios/{id}`)**
    `[Imagem do Diagrama de Sequência para Listar Pessoa por ID]`

5.  **Criar Pedido de Doação (`POST /doacoes`)**
    `[Imagem do Diagrama de Sequência para Criar Pedido de Doação]`

6.  **Contribuir com Doação (`POST /doacoes/{id}/contribuir`)**
    `[Imagem do Diagrama de Sequência para Contribuir com Doação]`

---

## ⚙️ Configuração e Execução Local

### 1. Pré-requisitos
* JDK 17 ou superior.
* Maven 3.8 ou superior.
* Um cliente Git.

### 2. Executando a Aplicação
O projeto está configurado para usar o banco de dados em memória H2, que é iniciado e destruído junto com a aplicação, não exigindo nenhuma configuração manual.

1.  Clone o repositório:
    ```bash
    git clone [https://github.com/seu-usuario/idoe-api.git](https://github.com/seu-usuario/idoe-api.git)
    cd idoe-api
    ```

2.  Execute a aplicação com o Maven:
    ```bash
    mvn spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`. O console do banco H2 pode ser acessado em `http://localhost:8080/h2-console` para visualizar os dados em tempo real.

---

## 🧪 Fluxo Completo de Testes da API (Online)

Use os comandos `curl` abaixo para testar os endpoints da aplicação diretamente no ambiente de deploy.

**1. Criar Pessoa Física**
```bash
curl -X POST [https://es-idoe.ericksousa5.repl.co/usuarios](https://es-idoe.ericksousa5.repl.co/usuarios) \
 -H "Content-Type: application/json" \
 -d '{
   "nome": "João Silva",
   "email": "joao.silva@example.com",
   "telefone": "11999998888",
   "cep": "01234567",
   "cpf": "12345678901",
   "tipo": "FISICA"
 }'`
```
**2.Criar Pessoa Jurídica**
```bash
curl -X POST [https://es-idoe.ericksousa5.repl.co/usuarios](https://es-idoe.ericksousa5.repl.co/usuarios) \
 -H "Content-Type: application/json" \
 -d '{
   "nome": "Acme Ltda",
   "email": "contato@acme.com",
   "telefone": "1133334444",
   "cep": "98765432",
   "cnpj": "12345678000199",
   "tipo": "JURIDICA"
 }'
```
**3.Listar Todas as Pessoas**
```bash
curl -X GET [https://es-idoe.ericksousa5.repl.co/usuarios](https://es-idoe.ericksousa5.repl.co/usuarios) \
 -H "Accept: application/json"
```
**4.Buscar Pessoa por ID (Ex: ID = 1)**
```bash
curl -X GET [https://es-idoe.ericksousa5.repl.co/usuarios/1](https://es-idoe.ericksousa5.repl.co/usuarios/1) \
 -H "Accept: application/json"
```
**5. Buscar Pessoa por ID (Ex: ID = 2)**
```bash
curl -X GET [https://es-idoe.ericksousa5.repl.co/usuarios/2](https://es-idoe.ericksousa5.repl.co/usuarios/2) \
 -H "Accept: application/json"
```
**6. Criar Doação (para empresa com ID = 2)**
```bash
curl -X POST [https://es-idoe.ericksousa5.repl.co/doacoes](https://es-idoe.ericksousa5.repl.co/doacoes) \
 -H "Content-Type: application/json" \
 -d '{
   "data": "2025-08-05",
   "titulo": "Campanha Natal Solidário",
   "especificacao": "Arrecadação de brinquedos para crianças carentes.",
   "valor": 5000.00,
   "empresaId": 2
 }'
```
**7. Listar Todas as Doações**
```bash
curl -X GET [https://es-idoe.ericksousa5.repl.co/doacoes](https://es-idoe.ericksousa5.repl.co/doacoes) \
 -H "Accept: application/json"
```
**9. Contribuir para a Doação (Ex: ID = 1)**
[Este endpoint simula a geração de um QR Code para pagamento.]

```bash
curl -X POST [https://es-idoe.ericksousa5.repl.co/doacoes/1/contribuir](https://es-idoe.ericksousa5.repl.co/doacoes/1/contribuir) \
 -H "Accept: application/json"
