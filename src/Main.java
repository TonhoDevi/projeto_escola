import controller.AlunoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria o scanner para ler o que o usuário digita no terminal.
        Scanner scanner = new Scanner(System.in);
        // Cria o controller responsável por chamar as ações do CRUD.
        AlunoController controller = new AlunoController(scanner);
        // Variável que guarda a opção escolhida no menu.
        int opcao = 0;

        // Loop principal do programa, fica repetindo até o usuário escolher sair.
        while (opcao != 5) {
            try {
                // Exibe as opções do menu para o usuário.
                System.out.println("\n=== MENU DE ACESSO ===");
                System.out.println("1 - Cadastrar aluno");
                System.out.println("2 - Listar alunos");
                System.out.println("3 - Atualizar aluno");
                System.out.println("4 - Remover aluno");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma opção: ");

                // Lê a opção escolhida pelo usuário.
                opcao = scanner.nextInt();
                scanner.nextLine();

                // Direciona para a opção escolhida.
                switch (opcao) {
                    case 1:
                        // Chama o método de cadastro de aluno.
                        controller.createAluno();
                        break;
                    case 2:
                        // Chama o método para listar os alunos.
                        controller.readAlunos();
                        break;
                    case 3:
                        // Chama o método para atualizar aluno.
                        controller.updateAluno();
                        break;
                    case 4:
                        // Chama o método para remover aluno.
                        controller.deleteAluno();
                        break;
                    case 5:
                        // Encerra o programa.
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        // Caso o usuário digite uma opção que não existe.
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Captura erro quando o usuário digita texto em vez de número.
                System.out.println("Opção inválida. Digite um número de 1 a 5.");
                scanner.nextLine();
            }
        }

        // Fecha o scanner ao final do programa.
        scanner.close();
    }
}