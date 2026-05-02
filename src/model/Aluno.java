package model;

public class Aluno {

    private String nome;
    private int idade;
    private String turma;
    private final int ID;

    private static int contador = 0;


    public Aluno(String nome, int idade, String turma){
        this.nome = nome;
        this.idade = idade;
        this.turma = turma;
        ID = contador++;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTurma() {
        return turma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getId() {
        return ID;
    }



    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Idade: " + idade +
                ", Turma: " + turma;
    }

}
