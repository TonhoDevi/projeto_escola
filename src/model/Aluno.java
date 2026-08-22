package model;

public class Aluno {

    // Atributos do aluno.
    private String nome;
    private int idade;
    private String turma;
    private final int ID;

    // Contador para gerar IDs únicos.
    private static int contador = 0;

    // Construtor para criar um aluno com nome, idade e turma.
    public Aluno(String nome, int idade, String turma){
        this.nome = nome;
        this.idade = idade;
        this.turma = turma;
        ID = contador++;
    }

    // Getters para acessar os valores.
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTurma() {
        return turma;
    }

    // Setters para alterar os valores depois do cadastro.
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    // Retorna o ID do aluno.
    public int getId() {
        return ID;
    }

    // Converte os dados do aluno em texto para mostrar no console.
    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Idade: " + idade +
                ", Turma: " + turma;
    }

}
