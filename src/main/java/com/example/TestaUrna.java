package com.example;
import java.util.Scanner;

public class TestaUrna {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean confirma = true;
        Urna urna = new Urna();

        while (confirma == true){
            int opcao;
            System.out.println("------------------ MENU SIMULADOR DE VOTAÇÃO -----------------------------");
            System.out.println("|                                                                        |");
            System.out.println("|          1 CADASTRAR CANDIDATOS                                        |");
            System.out.println("|          2 CADASTRAR ELEITORES                                         |");
            System.out.println("|          3 VOTAR                                                       |");
            System.out.println("|          4 APURAR RESULTADOS                                           |");
            System.out.println("|          5 RELATÓRIOS E ESTATÍSTICAS                                   |");
            System.out.println("|          6 ENCERRAR                                                    |");
            System.out.println("|                                                                        |");
            System.out.println("|          OPÇÃO ESCOLHIDA:                                              |");
            System.out.println("|                                                                        |");
            System.out.println("--------------------------------------------------------------------------");
            opcao = input.nextInt();
            if (opcao == 1){
                urna.cadastrarCandidato();
            }
            else if (opcao == 2){
                urna.cadastrarEleitor();
            }
            else if (opcao == 3){
                urna.votar();
                System.out.println("----------------- ETAPA DE VOTAÇÃO ENCERRADA --------------------------------\n");
            }
            else if (opcao == 4){
                urna.apurarResultados();
            }
            else if (opcao == 5){
                urna.relatorioEstatisticas();
            }
            else if(opcao == 6){
                break;
            }
            

        }





    }
}
