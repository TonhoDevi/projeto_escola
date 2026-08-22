package controller;

import model.Aluno;
import service.AlunoService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlunoController {

    // Cria o serviço que contém a lógica de negócio do CRUD.
    private final AlunoService service = new AlunoService();
    // Scanner usado para ler dados digitados pelo usuário.
    private final Scanner scan;

    // Construtor que recebe um Scanner externo para evitar vários scanners no programa.
    public AlunoController(Scanner scan) {
        this.scan = scan;
    }

    // Método para cadastrar um aluno.
    public void createAluno() {
        // Lê o nome do aluno.
        String nome = lerTexto("Digite o nome do aluno:");
        // Lê a idade do aluno.
        int idade = lerInteiro("Digite a idade do aluno:");
        // Lê a turma do aluno.
        String turma = lerTexto("Digite a turma do aluno:");

        // Envia os dados para o service.
        service.create(nome, idade, turma);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Método para listar todos os alunos cadastrados.
    public void readAlunos() {
        // Busca a lista de alunos no serviço.
        List<Aluno> alunos = service.read();

        // Verifica se a lista está vazia.
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        // Exibe cada aluno encontrado.
        System.out.println("Lista de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId() + " | " + aluno);
        }
    }

    // Método para atualizar um aluno existente.
    public void updateAluno() {
        // Lê o ID do aluno a ser atualizado.
        int id = lerInteiro("Digite o ID do aluno que deseja atualizar:");
        // Lê o novo nome.
        String nome = lerTexto("Digite o novo nome do aluno:");
        // Lê a nova idade.
        int idade = lerInteiro("Digite a nova idade do aluno:");
        // Lê a nova turma.
        String turma = lerTexto("Digite a nova turma do aluno:");

        // Chama o serviço para tentar atualizar.
        boolean atualizado = service.update(id, nome, idade, turma);

        // Informa ao usuário se deu certo ou não.
        if (atualizado) {
            System.out.println("Aluno atualizado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método para remover um aluno.
    public void deleteAluno() {
        // Lê o ID do aluno a ser removido.
        int id = lerInteiro("Digite o ID do aluno que deseja remover:");

        // Chama o serviço para remover.
        boolean removido = service.remove(id);

        // Informa ao usuário o resultado.
        if (removido) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método auxiliar para ler textos do usuário com validação.
    private String lerTexto(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String valor = scan.nextLine();
                // Se o valor estiver vazio, lança erro para repetir a leitura.
                if (valor == null || valor.trim().isEmpty()) {
                    throw new IllegalArgumentException("Valor inválido.");
                }
                return valor.trim();
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
    }

    // Método auxiliar para ler números inteiros do usuário.
    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String valor = scan.nextLine();
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
    }
}
