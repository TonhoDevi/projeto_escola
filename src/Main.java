import controller.AlunoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoController controller = new AlunoController(scanner);
        int opcao = 0;

        while (opcao != 5) {
            try {
                System.out.println("\n=== MENU DE ACESSO ===");
                System.out.println("1 - Cadastrar aluno");
                System.out.println("2 - Listar alunos");
                System.out.println("3 - Atualizar aluno");
                System.out.println("4 - Remover aluno");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        controller.createAluno();
                        break;
                    case 2:
                        controller.readAlunos();
                        break;
                    case 3:
                        controller.updateAluno();
                        break;
                    case 4:
                        controller.deleteAluno();
                        break;
                    case 5:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número de 1 a 5.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}