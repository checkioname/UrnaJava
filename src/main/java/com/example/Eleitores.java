package com.example;

public class Eleitores {
    private String nome;
    private String cpf;

    public Eleitores(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public Eleitores(){}
    
    //getters
    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    } 
}