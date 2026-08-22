package service;

import model.Aluno;
import repository.AlunoRepository;

import java.util.List;

public class AlunoService {
    public AlunoRepository repository = new AlunoRepository();

    public void create(String nome, int idade, String turma) {
        if (idade < 18) {
            System.out.println("Aluno menor de idade, não é permitido o cadastro");
            return;
        }
        if (nome == null || nome.trim().length() < 3) {
            System.out.println("Nome do aluno muito curto, não é permitido o cadastro");
            return;
        }

        Aluno alunoTemp = new Aluno(nome.trim(), idade, turma.trim());
        repository.create(alunoTemp);
    }

    public List<Aluno> read() {
        return repository.readAll();
    }

    public boolean remove(int id) {
        return repository.deleteById(id);
    }

    public boolean update(int id, String nome, int idade, String turma) {
        if (idade < 18) {
            System.out.println("Aluno menor de idade, não é permitido o cadastro");
            return false;
        }
        if (nome == null || nome.trim().length() < 3) {
            System.out.println("Nome do aluno muito curto, não é permitido o cadastro");
            return false;
        }

        if (!repository.updateById(id, nome.trim(), idade, turma.trim())) {
            return false;
        }

        return true;
    }
}
