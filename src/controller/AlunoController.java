package controller;

import model.Aluno;
import service.AlunoService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlunoController {

    private final AlunoService service = new AlunoService();
    private final Scanner scan;

    public AlunoController(Scanner scan) {
        this.scan = scan;
    }

    public void createAluno() {
        String nome = lerTexto("Digite o nome do aluno:");
        int idade = lerInteiro("Digite a idade do aluno:");
        String turma = lerTexto("Digite a turma do aluno:");

        service.create(nome, idade, turma);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void readAlunos() {
        List<Aluno> alunos = service.read();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("Lista de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId() + " | " + aluno);
        }
    }

    public void updateAluno() {
        int id = lerInteiro("Digite o ID do aluno que deseja atualizar:");
        String nome = lerTexto("Digite o novo nome do aluno:");
        int idade = lerInteiro("Digite a nova idade do aluno:");
        String turma = lerTexto("Digite a nova turma do aluno:");

        boolean atualizado = service.update(id, nome, idade, turma);

        if (atualizado) {
            System.out.println("Aluno atualizado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void deleteAluno() {
        int id = lerInteiro("Digite o ID do aluno que deseja remover:");

        boolean removido = service.remove(id);

        if (removido) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private String lerTexto(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String valor = scan.nextLine();
                if (valor == null || valor.trim().isEmpty()) {
                    throw new IllegalArgumentException("Valor inválido.");
                }
                return valor.trim();
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
    }

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
