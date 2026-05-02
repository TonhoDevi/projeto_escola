package service;

import model.Aluno;
import repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    public AlunoRepository repository = new AlunoRepository();

    public void cadastrar(String nome, int idade, String turma){
        Aluno alunoTemp = new Aluno(nome, idade, turma);
        repository.cadastros.add(alunoTemp);
    }

    public List<Aluno> listar(){
        List<Aluno> alunos = repository.cadastros;
        return alunos;
    }

    public boolean remove(int ID){
        for (Aluno aluno : repository.cadastros) {
            if (aluno.getId() == ID) {
                repository.cadastros.remove(aluno);
                return true;
            }
        }   
        
        return false; 
    }







}
