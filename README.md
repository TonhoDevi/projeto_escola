# Projeto Escola

Este projeto foi desenvolvido com objetivo educacional para ajudar alunos a aprenderem os conceitos básicos de Java, orientação a objetos, CRUD e interação com o usuário via terminal.

## Objetivo

O projeto simula um sistema simples de cadastro de alunos, permitindo:

- cadastrar um aluno;
- listar os alunos cadastrados;
- atualizar informações de um aluno;
- remover um aluno;
- navegar por um menu em console.

Ele foi pensado como um exemplo didático para estudantes que estão começando a programação em Java.

## Estrutura do projeto

```text
projeto_escola/
├── src/
│   ├── Main.java
│   ├── controller/
│   │   └── AlunoController.java
│   ├── model/
│   │   └── Aluno.java
│   ├── repository/
│   │   └── AlunoRepository.java
│   └── service/
│       └── AlunoService.java
├── README.md
└── projeto_escola.iml
```

## Conceitos trabalhados

- Classes e objetos
- Encapsulamento
- MVC simples (Model, View, Controller)
- CRUD em memória
- Validação de entrada do usuário
- Laços de repetição
- Tratamento de exceções com try/catch
- Uso de listas em Java
- Organização por pacotes

## Como executar

Abra o terminal na pasta do projeto e rode:

```bash
javac src/*.java src/controller/*.java src/model/*.java src/repository/*.java src/service/*.java
java -cp src Main
```

## Exemplo de uso

Ao iniciar o programa, o menu aparecerá assim:

```text
=== MENU DE ACESSO ===
1 - Cadastrar aluno
2 - Listar alunos
3 - Atualizar aluno
4 - Remover aluno
5 - Sair
```

## Observação

Este projeto é educativo e foi criado para fins de aprendizado. Ele mostra uma base simples de como estruturar um sistema em Java, porém pode ser expandido com banco de dados, interface gráfica, testes e regras mais avançadas.

## Autor

Projeto desenvolvido para fins didáticos no contexto de estudo de programação Java.
