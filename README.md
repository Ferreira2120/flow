# Flow

Backend do sistema Flow, responsável pelo gerenciamento e organização dos layouts de máquinas utilizados pelo front-end.  
Desenvolvido em **Java 17** com **Quarkus**, seguindo arquitetura limpa, separação por camadas e uso de DTOs para garantir clareza e manutenibilidade.

![Java](https://img.shields.io/badge/Java-17-blue)
![Quarkus](https://img.shields.io/badge/Quarkus-3.0-red)
![Status](https://img.shields.io/badge/Build-Estável-brightgreen)

---

## 📚 Sumário
- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Endpoints](#endpoints)
- [Estrutura do Código](#estrutura-do-código)
- [Como Rodar](#como-rodar)
- [Fluxo Interno](#fluxo-interno)

---

## 📌 Sobre

O backend do **Flow** gerencia os layouts e posições das máquinas de produção.  
Ele fornece uma API REST utilizada pelo front-end para exibir, posicionar, mover e atualizar máquinas dentro de uma grade visual.

O foco principal é:
- CRUD completo de layouts
- Padronização por DTOs
- Camada de serviço isolada
- Repositórios com Panache para operações de banco
- Código limpo e modular

---

## 🛠 Tecnologias

- **Java**
- **Quarkus**
- **Maven**
- **Docker**
- **SQL Developer**

---

## 🔗 Endpoints

### **GET `/layout-maquina`**
Retorna todos os layouts cadastrados.

### **GET `/layout-maquina/{id}`**
Retorna um layout específico pelo ID.  
Retorna **404** caso não exista.

### **POST `/layout-maquina`**
Cria um novo layout.  
Retorna **201** com o objeto criado.

### **PUT `/layout-maquina/{id}`**
Atualiza um layout existente.  
Retorna o objeto atualizado.

### **DELETE `/layout-maquina/{id}`**
Remove um layout existente.  
Retorna **204** quando removido.  
Retorna **404** caso o ID não exista.

---

## 🧩 Estrutura do Código
````
src/
└── main/
├── java/br/com/fiap/flow/
│ ├── domain/ → entidades (JPA)
│ ├── interfaces/ → controllers (REST)
│ ├── infraestructure/ → repositórios Panache
│ └── application/ → serviços e regras de negócio
└── resources/
├── application.properties
└── import.sql
````

---


### **Domain (Entidades)**
Contém as classes que representam tabelas do banco.  
Exemplo: `LtyMaquina.java`

### **Interfaces (Controllers)**
Contêm os endpoints REST.  
Exemplo: `LtyMaquinaRest.java`

### **Infraestructure (Repository)**
Repositórios usando **Panache** para acesso ao banco.  
Exemplo: `LtyMaquinaRepository.java`

### **Application (Service)**
Camada de regra de negócio.  
Converte Entity ↔ DTO.  
Exemplo: `LtyMaquinaService.java`

### **DTOs**
Objetos usados para entrada e saída.  
Evita expor a entidade diretamente.

---

## 🔗 Link API

 - Flow Api: [Flow](https://flow-fkxo.onrender.com)
