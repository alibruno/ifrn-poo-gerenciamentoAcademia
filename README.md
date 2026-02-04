# Projeto final da disciplina de POO

## Sumário

### 1. [Tema](#1-tema)

### 2. [Especificações](#2-especificações)
- [2.1. Requisitos Funcionais](#21-requisitos-funcionais)
- [2.2. Requisitos Técnicos](#22-requisitos-técnicos)
- [2.3. Funcionalidades Adicionais](#23-funcionalidades-adicionais)
- [2.4. Entregáveis](#24-entregáveis)
- [2.5. Critérios de Avaliação](#25-critérios-de-avaliação)

## 1. Tema

### **Sistema de Gerenciamento de Academia**:
- Cadastro de alunos, instrutores e planos de treino.
- Controle de frequência e pagamentos.
- Geração de relatórios de desempenho.

## 2. Especificações

### 2.1. **Requisitos Funcionais**:
- O sistema deve permitir o **cadastro, edição, exclusão e consulta** das entidades principais (ex: livros, usuários, produtos, etc.).
- Deve haver funcionalidades específicas para o domínio do sistema (ex: empréstimo de livros, fechamento de pedidos, agendamento de consultas, etc.).
- O sistema deve gerar **relatórios** ou listagens relevantes (ex: listar todos os livros emprestados, produtos com estoque baixo, consultas agendadas, etc.).

### 2.2. **Requisitos Técnicos**:
- **Classes e Objetos**: Criar classes que representem as entidades do sistema, com atributos e métodos bem definidos.
- **Records**: Usar `records` quando for o caso.
- **Encapsulamento**: Utilizar atributos privados e métodos públicos (getters e setters) para garantir o encapsulamento.
- **Herança e Polimorfismo**: Criar hierarquias de classes e utilizar polimorfismo quando aplicável.
- **Interfaces**: Definir interfaces para comportamentos comuns (ex: `Emprestavel`, `Pagavel`, etc.).
- **Coleções**: Utilizar coleções como `ArrayList`, `HashMap`, etc., para armazenar listas de objetos.
- **Exceções**: Implementar tratamento de exceções para situações de erro (ex: tentativa de emprestar um livro já emprestado).
- ~~**Persistência de Dados**: Salvar e carregar dados em arquivos (ex: `.txt`, `.csv`).~~

### 2.3. **Funcionalidades Adicionais**:
- **Validação de Dados**: Validar entradas do usuário (ex: CPF, e-mail, datas, etc.).
- **Interface de Usuário**: Implementar uma interface simples via console ou, opcionalmente.

### 2.4. **Entregáveis**:
- **Código Fonte**: O projeto completo, organizado em pacotes e seguindo as boas práticas de POO.
- **Diagrama**: Diagrama de Classes com todas as classes, interfaces e records do sistema.
- **Documentação**: Comentários no código e um arquivo `README.md` explicando como executar o projeto e suas funcionalidades.
- ~~**Relatório**: Um relatório descrevendo as decisões de projeto, desafios enfrentados e soluções implementadas.~~

### 2.5. **Critérios de Avaliação**:
- **Funcionalidade**: O sistema deve atender a todos os requisitos funcionais.
- **Qualidade do Código**: O código deve ser modular, bem organizado e seguir as boas práticas de POO.
- **Originalidade**: O sistema deve ser único e criativo, evitando cópias de projetos prontos.
- **Complexidade**: O projeto deve demonstrar um nível adequado de complexidade, utilizando os conceitos aprendidos na disciplina.
