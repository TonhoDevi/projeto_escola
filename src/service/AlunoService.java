package service;

import model.Aluno;
import repository.AlunoRepository;

import java.util.List;

public class AlunoService {
    // Cria o repositório responsável por guardar os alunos em memória.
    public AlunoRepository repository = new AlunoRepository();

    // Método que cadastra um aluno com validações.
    public void create(String nome, int idade, String turma) {
        // Valida a idade mínima permitida.
        if (idade < 18) {
            System.out.println("Aluno menor de idade, não é permitido o cadastro");
            return;
        }
        // Valida o nome mínimo.
        if (nome == null || nome.trim().length() < 3) {
            System.out.println("Nome do aluno muito curto, não é permitido o cadastro");
            return;
        }

        // Cria um novo objeto Aluno com os dados recebidos.
        Aluno alunoTemp = new Aluno(nome.trim(), idade, turma.trim());
        // Salva no repositório.
        repository.create(alunoTemp);
    }

    // Método para listar todos os alunos.
    public List<Aluno> read() {
        return repository.readAll();
    }

    // Método para remover um aluno pelo ID.
    public boolean remove(int id) {
        return repository.deleteById(id);
    }

    // Método para atualizar um aluno já existente.
    public boolean update(int id, String nome, int idade, String turma) {
        // Validação da idade antes de atualizar.
        if (idade < 18) {
            System.out.println("Aluno menor de idade, não é permitido o cadastro");
            return false;
        }
        // Validação do nome antes de atualizar.
        if (nome == null || nome.trim().length() < 3) {
            System.out.println("Nome do aluno muito curto, não é permitido o cadastro");
            return false;
        }

        // Tenta atualizar no repositório.
        if (!repository.updateById(id, nome.trim(), idade, turma.trim())) {
            return false;
        }

        return true;
    }
}
