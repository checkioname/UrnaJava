package com.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public final class Urna {
    private ArrayList<Presidente> listaPresidentes = new ArrayList<Presidente>();
    private ArrayList<Governador> listaGovernadores = new ArrayList<Governador>();
    private ArrayList<Prefeito> listaPrefeitos = new ArrayList<Prefeito>();
    private ArrayList<Eleitores> listaEleitores = new ArrayList<Eleitores>();
    
    private ArrayList<Integer> votosPresidente = new ArrayList<Integer>();
    private ArrayList<Integer> votosGovernador = new ArrayList<Integer>();
    private ArrayList<Integer> votosPrefeito = new ArrayList<Integer>();

    private ArrayList<Integer> votosBrancoPresidente = new ArrayList<Integer>();
    private ArrayList<Integer> votosNuloPresidente = new ArrayList<Integer>();
    private ArrayList<Integer> votosBrancoGovernador = new ArrayList<Integer>();
    private ArrayList<Integer> votosNuloGovernador = new ArrayList<Integer>();
    private ArrayList<Integer> votosBrancoPrefeito = new ArrayList<Integer>();
    private ArrayList<Integer> votosNuloPrefeito = new ArrayList<Integer>();
    
    public Urna() {
        //default
    }

    public void cadastrarCandidato(){
        Scanner ler = new Scanner(System.in);
        System.out.println("CADASTRO DE CANDIDATOS\n");
        
        while (true){
            System.out.println("DIGITE O NÚMERO INDICADO PARA O CARGO DESEJADO:\n1 - PRESIDENTE\n2 - GOVERNADOR\n3 - PREFEITO\n");
            int resp1 = ler.nextInt();
            
            if (resp1 == 1){
                System.out.println("Qual o nome do presidenciável?\n");
                String nome = ler.next();

                System.out.println("Qual o partido do presidenciável?\n");
                String partido = ler.next();

                System.out.println("Qual o número do presidenciável (DOIS DÍGITOS)?\n");
                int numCandidato = ler.nextInt();

                Presidente presidente = new Presidente(nome, partido, numCandidato, "presidente");
                listaPresidentes.add(presidente);
            }
            
            else if (resp1 == 2){
                System.out.println("Qual o nome do governador?\n");
                String nome = ler.next();

                System.out.println("Qual o partido do governador?\n");
                String partido = ler.next();

                System.out.println("Qual o número do governador (TRÊS DÍGITOS)?\n");
                int numCandidato = ler.nextInt();

                Governador governador = new Governador(nome, partido, numCandidato, "governador");
                listaGovernadores.add(governador);
            }
            
            else if (resp1 == 3){
                System.out.println("Qual o nome do Prefeito?\n");
                String nome = ler.next();

                System.out.println("Qual o partido do prefeito?\n");
                String partido = ler.next();

                System.out.println("Qual o número do prefeito (QUATRO DÍGITOS)?\n");
                int numCandidato = ler.nextInt();

                Prefeito prefeito = new Prefeito(nome, partido, numCandidato, "prefeito");
                listaPrefeitos.add(prefeito);
            }
            
            System.out.println("\nDeseja inserir um novo candidato?");
            String resposta = ler.next();
            System.out.println("\n");

            if (resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao")){
                break;

            } else {continue;}
        }
    }

    public void cadastrarEleitor(){
        Scanner ler = new Scanner(System.in);
        System.out.println("CADASTRO DE ELEITORES\n");

        while (true){
            System.out.println("Qual o nome do eleitor?\n");
            String nome = ler.next();

            System.out.println("Qual o cpf do eleitor?\n");
            String cpf = ler.next();         
            
            Eleitores eleitor = new Eleitores(nome, cpf);
            listaEleitores.add(eleitor);

            System.out.println("\nDeseja inserir um novo eleitor?");
            String resposta = ler.next();
            System.out.println("\n");

            if (resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao")){
                break;
            } else {continue;}
        }
    }

    public void vota(){
        Scanner ler = new Scanner(System.in);
        System.out.println("ETAPA DE VOTAÇÃO\n");
        System.out.println("REGRAS DE VOTAÇÃO:\nEtapas: Prefeito -> Governador -> Presidente\nVoto branco: digitar -1\nVoto nulo: digitar -2\n");

        int counter = 0;
        while (counter <= listaEleitores.size()){
            for (int i = 0; i < listaEleitores.size(); i++){
                System.out.println("Nome do eleitor: " + listaEleitores.get(i).getNome());

                System.out.println("\nLista de presidenciáveis:");
                for (int j = 0; j < listaPresidentes.size(); j++){
                    System.out.println("Nome: " + listaPresidentes.get(j).getNome());
                    System.out.println("Número do candidato: " + listaPresidentes.get(j).getNum_candidato());
                    System.out.println("Partido: " + listaPresidentes.get(j).getPartido() + "\n");
                }
                System.out.println("----------------------------------------------\n");
                
                while (true){
                    System.out.println("DIGITE O NÚMERO DO SEU CANDIDATO PARA PRESIDENTE (DOIS DÍGITOS):\n");
                    int numPresidente = ler.nextInt();
                    System.out.println("CONFIRMA O VOTO EM " + numPresidente + "?\n");
                    String respostaP = ler.next();
                    System.out.println("\n");

                    if (respostaP.equalsIgnoreCase("sim")){
                        if (numPresidente == -1){
                            votosBrancoPresidente.add(numPresidente);
                        } else if (numPresidente == -2){
                            votosNuloPresidente.add(numPresidente);
                        } else {
                            votosPresidente.add(numPresidente);
                        }
                        counter++;
                        break;
                    } else {continue;}
                }

                System.out.println("Lista de governadores:");
                for (int j = 0; j < listaGovernadores.size(); j++){
                    System.out.println("Nome: " + listaGovernadores.get(j).getNome());
                    System.out.println("Número do candidato: " + listaGovernadores.get(j).getNum_candidato());
                    System.out.println("Partido: " + listaGovernadores.get(j).getPartido() + "\n");
                }
                System.out.println("----------------------------------------------\n");
                
                while (true){
                    System.out.println("DIGITE O NÚMERO DO SEU CANDIDATO PARA GOVERNADOR (TRÊS DÍGITOS):\n");
                    int numGovernador = ler.nextInt();
                    System.out.println("CONFIRMA O VOTO EM " + numGovernador + "?\n");
                    String respostaG = ler.next();
                    System.out.println("\n");

                    if (respostaG.equalsIgnoreCase("sim")){
                        if (numGovernador == -1){
                            votosBrancoGovernador.add(numGovernador);
                        } else if (numGovernador == -2){
                            votosNuloGovernador.add(numGovernador);
                        } else {
                            votosGovernador.add(numGovernador);
                        }
                        counter++;
                        break;
                    } else {continue;}
                }

                System.out.println("Lista de prefeitos:");
                for (int j = 0; j < listaPrefeitos.size(); j++){
                    System.out.println("Nome: " + listaPrefeitos.get(j).getNome());
                    System.out.println("Número do candidato: " + listaPrefeitos.get(j).getNum_candidato());
                    System.out.println("Partido: " + listaPrefeitos.get(j).getPartido() + "\n");
                }
                System.out.println("----------------------------------------------\n");

                while (true){
                    System.out.println("DIGITE O NÚMERO DO SEU CANDIDATO PARA PREFEITO (QUARTO DÍGITOS):\n");
                    int numPrefeito = ler.nextInt();
                    System.out.println("CONFIRMA O VOTO EM " + numPrefeito + "?\n");
                    String respostaPR = ler.next();
                    System.out.println("\n");

                    if (respostaPR.equalsIgnoreCase("sim")){
                        if (numPrefeito == -1){
                            votosBrancoPrefeito.add(numPrefeito);
                        } else if (numPrefeito == -2){
                            votosNuloPrefeito.add(numPrefeito);
                        } else {
                            votosPrefeito.add(numPrefeito);
                        }
                        counter++;
                        break;
                    } else {continue;}
                }
            }
        }
    }

    private int[] apuraPresidente(){
        int totalVotos = votosPresidente.size() + votosBrancoPresidente.size() + votosNuloPresidente.size();
        int counterBrancos = votosBrancoPresidente.size();
        int counterNulos = votosNuloPresidente.size();
        int counterValidos = totalVotos - (counterBrancos + counterNulos);

        int [] listaGeral = new int[4];
        listaGeral[0] = totalVotos;
        listaGeral[1] = counterValidos;
        listaGeral[2] = counterBrancos;
        listaGeral[3] = counterNulos;

        return listaGeral;
    }

    private int[] apuraGovernador(){
        int totalVotos = votosGovernador.size() + votosBrancoGovernador.size() + votosNuloGovernador.size();
        int counterBrancos = votosBrancoGovernador.size();
        int counterNulos = votosNuloGovernador.size();
        int counterValidos = totalVotos - (counterBrancos + counterNulos);

        int [] listaGeral = new int[4];
        listaGeral[0] = totalVotos;
        listaGeral[1] = counterValidos;
        listaGeral[2] = counterBrancos;
        listaGeral[3] = counterNulos;

        return listaGeral;
    }

    private int[] apuraPrefeitos(){
        int totalVotos = votosPrefeito.size() + votosBrancoPrefeito.size() + votosNuloPrefeito.size();
        int counterBrancos = votosBrancoPrefeito.size();
        int counterNulos = votosNuloPrefeito.size();
        int counterValidos = totalVotos - (counterBrancos + counterNulos);

        int [] listaGeral = new int[4];
        listaGeral[0] = totalVotos;
        listaGeral[1] = counterValidos;
        listaGeral[2] = counterBrancos;
        listaGeral[3] = counterNulos;

        return listaGeral;
    }

    public void apurar(){
        System.out.println("VOTOS PARA PRESIDENTE");
        Map<Integer, Integer> votosP = new HashMap<>();
        votosPresidente.forEach(num -> votosP.compute(num, (chave, valor) -> (valor == null ? 1 : valor + 1)));
        votosP.forEach((chave, valor) -> System.out.println(String.format("N° do partido: %d - %d voto(s)", chave, votosP.get(chave))));

        int [] listaGeralP = apuraPresidente();
        double validosP = listaGeralP[1];
        double brancosP = listaGeralP[2];
        double nulosP = listaGeralP[3];
        System.out.println("\nTOTAL DE VOTOS = " + listaGeralP[0]);
        System.out.println("TOTAL DE VOTOS VÁLIDOS E % = " + listaGeralP[1] + " voto(s) (" + String.format("%.2f", (validosP/listaGeralP[0]) * 100) + "%)");
        System.out.println("TOTAL DE VOTOS BRANCOS E % = " + listaGeralP[2] + " voto(s) (" + String.format("%.2f", (brancosP/listaGeralP[0]) * 100) + "%)");
        System.out.println("TOTAL DE VOTOS NULOS E % = " + listaGeralP[3] + " voto(s) (" + String.format("%.2f", (nulosP/listaGeralP[0]) * 100) + "%)");
        System.out.println("\n");

        System.out.println("VOTOS PARA GOVERNADOR");
        Map<Integer, Integer> votosG = new HashMap<>();
        votosGovernador.forEach(num -> votosG.compute(num, (chave, valor) -> (valor == null ? 1 : valor + 1)));
        votosG.forEach((chave, valor) -> System.out.println(String.format("N° do partido: %d - %d voto(s)", chave, votosG.get(chave))));

        int [] listaGeralG = apuraGovernador();
        double validosG = listaGeralG[1];
        double brancosG = listaGeralG[2];
        double nulosG = listaGeralG[3];
        System.out.println("\nTOTAL DE VOTOS = " + listaGeralG[0]);
        System.out.println("TOTAL DE VOTOS VÁLIDOS E % = " + listaGeralG[1] + " voto(s) (" + String.format("%.2f", (validosG/listaGeralG[0]) * 100) + "%)");
        System.out.println("TOTAL DE VOTOS BRANCOS E % = " + listaGeralG[2] + " voto(s) (" + String.format("%.2f", (brancosG/listaGeralG[0]) * 100) + "%)");
        System.out.println("TOTAL DE VOTOS NULOS E % = " + listaGeralG[3] + " voto(s) (" + String.format("%.2f", (nulosG/listaGeralG[0]) * 100) + "%)");
        System.out.println("\n");

        System.out.println("VOTOS PARA PREFEITO");
        Map<Integer, Integer> votosPR = new HashMap<>();
        votosPrefeito.forEach(num -> votosPR.compute(num, (chave, valor) -> (valor == null ? 1 : valor + 1)));
        votosPR.forEach((chave, valor) -> System.out.println(String.format("N° do partido: %d - %d voto(s)", chave, votosPR.get(chave))));

        int [] listaGeralPR = apuraPrefeitos();
        double validosPR = listaGeralPR[1];
        double brancosPR = listaGeralPR[2];
        double nulosRP = listaGeralPR[3];
        System.out.println("\nTOTAL DE VOTOS = " + listaGeralPR[0]);
        System.out.println("TOTAL DE VOTOS VÁLIDOS E % = " + listaGeralPR[1] + " voto(s) (" + String.format("%.2f", (validosPR/listaGeralPR[0]) * 100) + "%)");
        System.out.println("TOTAL DE VOTOS BRANCOS E % = " + listaGeralPR[2] + " voto(s) (" + String.format("%.2f", (brancosPR/listaGeralPR[0]) * 100) + "%)");
        System.out.println("TOTAL DE VOTOS NULOS E % = " + listaGeralPR[3] + " voto(s) (" + String.format("%.2f", (nulosRP/listaGeralPR[0]) * 100) + "%)");
        System.out.println("\n");
    }

    public void estatistica(){
        int [] listaGeral = apuraPresidente();
        int totalVotos = listaGeral[0];

        System.out.println("LISTA DE ELEITORES QUE VOTARAM:");
        for (int i = 0; i < listaEleitores.size(); i++){
            System.out.println("Nome: " + listaEleitores.get(i).getNome());
            System.out.println("CPF: " + listaEleitores.get(i).getCpf() + "\n");
        }
        System.out.println("----------------------------------------------\n");

        System.out.println("AUDITORIA DE VOTOS:");
        System.out.println("QUANTIDADE DE ELEITORES: " + listaEleitores);
        System.out.println("QUANTIDADE DE VOTOS: " + totalVotos);
        System.out.println("AUDITORIA: OK!");
        System.out.println("----------------------------------------------\n");


    }
}
