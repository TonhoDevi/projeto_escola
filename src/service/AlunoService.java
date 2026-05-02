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
        return
    }

    public boolean remove(String nome){
        return repository.
    }







}
