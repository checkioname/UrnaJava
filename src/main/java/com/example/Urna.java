/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Urna {
    Scanner entrada = new Scanner(System.in);
    ArrayList<Candidato> listaPresidentes = new ArrayList<Candidato>();
    ArrayList<Candidato> listaGovernadores = new ArrayList<Candidato>();
    ArrayList<Candidato> listaPrefeitos = new ArrayList<Candidato>();
    ArrayList<Eleitores> listaEleitores = new ArrayList<Eleitores>();
    private int qtdNulo = 0;
    private int qtdBranco = 0;
    private boolean confirma = true;
    int numVotosPresidentes = 0;
    int numVotosGovernadores = 0;
    int numVotosPrefeitos = 0;
    int totalVotos = 0;
            
    public void cadastrarCandidato(){
        Candidato candidato;
        int opcao = 1;
        
        while (opcao != 0){
            candidato = new Candidato();
            
            System.out.println("Digite o nome do candidato: ");
            candidato.setNome(entrada.next());
            System.out.println("Digite o número do candidato: ");
            candidato.setNumCandidato(entrada.nextInt());
            System.out.println("Digite o partido do candidato: ");
            candidato.setPartido(entrada.next());
            System.out.println("Digite o cargo do candidato: ");
            candidato.setCargo(entrada.next());
            
            if (candidato.getCargo().contains("Presidente")){
                listaPresidentes.add(candidato);
            }else if(candidato.getCargo().contains("Governador")){
                listaGovernadores.add(candidato);
            }else if (candidato.getCargo().contains("Prefeito")){
                listaPrefeitos.add(candidato);
            }
            System.out.println("Deseja cadastrar mais um candidato? Digite 1 para sim ou 0 para nao");
            opcao = entrada.nextInt();
        }
    }
    
    public void cadastrarEleitor(){
        Eleitores eleitor;
        int opcao = 1;
        
        while (opcao != 0){
            eleitor = new Eleitores();
            
            System.out.println("Digite o nome do eleitor: ");
            eleitor.setNome(entrada.next());
            System.out.println("Digite o CPF do eleitor: ");
            eleitor.setCpf(entrada.next());
            System.out.println("Deseja inserir outro eleitor?");
            listaEleitores.add(eleitor);
            System.out.println("Digite 1 para sim ou 0 para nao");
            opcao = entrada.nextInt();
        }
    }
    
    public void votar(){
        Eleitores eleitor;
        for(int i = 0; i < listaEleitores.size(); i++){
            while(confirma == true){
                System.out.println("Digite seu voto para prefeito: ");
                int num = entrada.nextInt();
                Candidato candidato = getCandidatoByNum(num,1);
                    if(candidato != null){
                        candidato.addVoto();
                        System.out.print("Voto computado com sucesso!!\n");
                        confirma = false;
                    }else if(num == -2){
                        System.out.print("Voto nulo computado com sucesso!!\n");
                            confirma = false;
                            qtdNulo++;
                        
                    }else if(num == -1){
                        System.out.print("Voto branco computado com sucesso!!\n");
                            qtdBranco++;
                            confirma = false;
                        }
                  
                System.out.println("Digite seu voto para governador: ");
                num = entrada.nextInt();
                candidato = getCandidatoByNum(num,2);
                    if(candidato != null){
                        candidato.addVoto();
                        System.out.print("Voto computado com sucesso!!\n");
                        confirma = false;
                    }else if(num == -2){
                        System.out.print("Voto nulo computado com sucesso!!\n");
                            confirma = false;
                            qtdNulo++;
                        
                    }else if(num == -1){
                        System.out.print("Voto branco computado com sucesso!!\n");
                            qtdBranco++;
                            confirma = false;
                        }
                    
                System.out.println("Digite seu voto para presidente: ");
                num = entrada.nextInt();
                candidato = getCandidatoByNum(num,3);
                    if(candidato != null){
                        candidato.addVoto();
                        System.out.print("Voto computado com sucesso!!\n");
                        confirma = false;
                    }else if(num == -2){
                        System.out.print("Voto nulo computado com sucesso!!\n");
                            confirma = false;
                            qtdNulo++;
                        
                    }else if(num == -1){
                        System.out.print("Voto branco computado com sucesso!!\n");
                            qtdBranco++;
                            confirma = false;
                        
                    }
            }
            confirma = true;
        }
    }
        
    public Candidato getCandidatoByNum(int numero, int tipo){
            if(tipo == 1){ //prefeito
                for(Candidato candidato: listaPrefeitos){
                    if(candidato.getNumCandidato() == numero){
                        return candidato;
                    }
                }
            }else if(tipo == 2){ //governador
                for(Candidato candidato: listaGovernadores){
                    if(candidato.getNumCandidato() == numero){
                        return candidato;
                    }
                }
            }else if(tipo == 3){ //presidente
                for(Candidato candidato: listaPresidentes){
                    if(candidato.getNumCandidato() == numero){
                        return candidato;
                    }
                }
            }
            return null;
    }
    
    public int ranking(int tipo){
        if(tipo == 1){
            int maior = listaPresidentes.get(0).getQntdVotos();
            for(int i = 1; i < listaPresidentes.size(); i++){
                if(maior > listaPresidentes.get(i).getQntdVotos()){
                }else if(listaPresidentes.get(i).getQntdVotos() > maior){
                    maior = listaPresidentes.get(i).getQntdVotos();         
                }
            }
            return maior;
        }
        else if(tipo == 2){
            int maior = listaGovernadores.get(0).getQntdVotos();
            for(int i = 1; i < listaGovernadores.size(); i++){
                if(maior > listaGovernadores.get(i).getQntdVotos()){
                }else if(listaGovernadores.get(i).getQntdVotos() > maior){
                    maior = listaGovernadores.get(i).getQntdVotos();         
                }
            }
            return maior;
        }
        else if(tipo == 3){
            int maior = listaPrefeitos.get(0).getQntdVotos();
            for(int i = 1; i < listaPrefeitos.size(); i++){
                if(maior > listaPrefeitos.get(i).getQntdVotos()){
                }else if(listaPrefeitos.get(i).getQntdVotos() > maior){
                    maior = listaPrefeitos.get(i).getQntdVotos();         
                }
            }
            return maior;
        } return 0;
    }
    
    public void apurarResultados(){
            for(int i = 0; i < listaPresidentes.size(); i++){
                if (ranking(1) == listaPresidentes.get(i).getQntdVotos()){
                    System.out.println("Primeiro lugar Presidente: "+ listaPresidentes.get(i).getNome());
                    System.out.println("Partido "+ listaPresidentes.get(i).getPartido());
                }
            }
            for(int i = 0; i < listaGovernadores.size(); i++){
                if (ranking(2) == listaGovernadores.get(i).getQntdVotos()){
                    System.out.println("Primeiro lugar Governador: "+ listaGovernadores.get(i).getNome());
                    System.out.println("Partido "+ listaGovernadores.get(i).getPartido());
                }
            }
            for(int i = 0; i < listaPrefeitos.size(); i++){
                if (ranking(3) == listaPrefeitos.get(i).getQntdVotos()){
                    System.out.println("Primeiro lugar Prefeito: "+ listaPrefeitos.get(i).getNome());
                    System.out.println("Partido "+ listaPrefeitos.get(i).getPartido());
                }
            }
            for(int i = 0; i < listaPresidentes.size(); i++){
                numVotosPresidentes += listaPresidentes.get(i).getQntdVotos();
            }
            for(int i = 0; i < listaGovernadores.size(); i++){
                numVotosPresidentes += listaGovernadores.get(i).getQntdVotos();
            }
            for(int i = 0; i < listaPrefeitos.size(); i++){
                numVotosPresidentes += listaPrefeitos.get(i).getQntdVotos();
            }
            totalVotos = numVotosPresidentes + numVotosGovernadores + numVotosPrefeitos + qtdNulo + qtdBranco;
            int votosValidos = numVotosPresidentes + numVotosGovernadores + numVotosPrefeitos;
            System.out.println("Total de votos = "+totalVotos);
            System.out.println("Total de votos válidos = "+votosValidos+" = "+(votosValidos*100)/totalVotos+"%");
            System.out.println("Total de votos brancos = "+qtdBranco+" = "+(qtdBranco*100)/totalVotos+"%");
            System.out.println("Total de votos nulos = "+qtdNulo+" = "+(qtdNulo*100)/totalVotos+"%");
            
        }
    
    public void relatorioEstatisticas(){
        System.out.println("Lista de eleitores: ");
        for(int i = 0; i < listaEleitores.size(); i++){
            System.out.println(listaEleitores.get(i).getNome());
        }
        System.out.println("Total de eleitores = "+listaEleitores.size());
        System.out.println(listaEleitores.size()+" eleitores para 3 cargos = "+totalVotos+" votos");
    }
}

