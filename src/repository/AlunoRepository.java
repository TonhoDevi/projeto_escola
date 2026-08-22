package repository;

import model.Aluno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlunoRepository {
    // Lista estática que guarda todos os alunos cadastrados no programa.
    public static List<Aluno> cadastros = new ArrayList<>();

    // Método para adicionar um aluno na lista.
    public void create(Aluno aluno) {
        cadastros.add(aluno);
    }

    // Método para retornar todos os alunos cadastrados.
    public List<Aluno> readAll() {
        return cadastros;
    }

    // Método para remover um aluno pela ID.
    public boolean deleteById(int id) {
        // Percorre a lista com iterator para remover com segurança.
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

    // Método para atualizar os dados de um aluno pela ID.
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
