package repository;

import model.Aluno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlunoRepository {
    public static List<Aluno> cadastros = new ArrayList<>();

    public void create(Aluno aluno) {
        cadastros.add(aluno);
    }

    public List<Aluno> readAll() {
        return cadastros;
    }

    public boolean deleteById(int id) {
        Iterator<Aluno> iterator = cadastros.iterator();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateById(int id, String nome, int idade, String turma) {
        for (Aluno aluno : cadastros) {
            if (aluno.getId() == id) {
                aluno.setNome(nome);
                aluno.setIdade(idade);
                aluno.setTurma(turma);
                return true;
            }
        }
        return false;
    }
}
