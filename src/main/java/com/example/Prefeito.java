package com.example;

public class Prefeito extends Candidato {
    Candidato candidato;

    public Prefeito(String nome, String partido, String cargo, int numCandidato, int qntdVotos){
        super(nome, partido, cargo, numCandidato, qntdVotos);
    }

}