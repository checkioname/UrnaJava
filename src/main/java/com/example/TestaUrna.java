package com.example;

public class TestaUrna {
    public static void main(String[] args) {
        Urna urna = new Urna();
        urna.cadastrarEleitor();
        urna.cadastrarCandidato();
        urna.vota();
        urna.apurar();
    }
}
