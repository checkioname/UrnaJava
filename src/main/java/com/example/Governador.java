package com.example;

public class Governador {
    private String nome;
    private String partido;
    private int numCandidato;
    private String cargo;

    public Governador(String nome, String partido, int numCandidato, String cargo){
        this.nome = nome;
        this.partido = partido;
        this.numCandidato = numCandidato;
        this.cargo = cargo;
    }

    //getters
    public String getNome(){
        return this.nome;
    }

    public String getPartido(){
        return this.partido;
    }

    public int getNum_candidato(){
        return this.numCandidato;
    }

    public String getCargo(){
        return this.cargo;
    }

}