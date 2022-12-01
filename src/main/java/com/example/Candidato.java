package com.example;

public class Candidato {
    private String nome, partido, cargo;
    private int qntdVotos, numCandidato;

    public Candidato(String nome, String partido, String cargo, int qntdVotos, int numCandidato){
        this.nome = nome;
        this.partido = partido;
        this.cargo = cargo;
        this.qntdVotos = qntdVotos;
        this.numCandidato = numCandidato;
    }
    public Candidato(){}

    public void addVoto(){
        this.qntdVotos ++;
    }

    /// Getters & Setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getPartido(){
        return this.partido;
    }
    public void setPartido(String partido){
        this.partido = partido;
    }

    public int getNumCandidato(){
        return this.numCandidato;
    }
    public void setNumCandidato(int numCandidato){
        this.numCandidato = numCandidato;
    }

    public String getCargo(){
        return this.cargo;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public int getQntdVotos(){
        return this.qntdVotos;
    }


}

