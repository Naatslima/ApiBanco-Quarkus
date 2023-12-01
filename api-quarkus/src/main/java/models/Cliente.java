package models;

public class Cliente {

    private String nome;
    private String cpf;

    public Cliente () {}

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    @Override
    public String toString(){
        return "Nome: " + nome +
                "CPF: " + cpf;
    }
}

