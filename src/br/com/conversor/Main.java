package br.com.conversor;


import br.com.conversor.moeda.Moeda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        double quantidade;
        Moeda moeda = new Moeda();
        Scanner teclado = new Scanner(System.in);

        System.out.println("1) Dólar >>> Peso Argentino");
        System.out.println("2) Peso Argentino >>> Dólar");
        System.out.println("3) Dólar >>> Real Brasileiro");
        System.out.println("4) Real Brasileiro >>> Dólar");
        System.out.println("5) Dólar >>> Peso Colombiano");
        System.out.println("6) Peso Colombiano >>> Dólar");
        System.out.println("7) sair");
        opcao = teclado.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Quantidade: ");
                quantidade = teclado.nextDouble();
                moeda.dolarParaPesoArgentino("USD",quantidade);
            break;
            case 2:
                System.out.println("Quantidade: ");
                quantidade = teclado.nextDouble();
                moeda.PesoArgentinoParadolar("ARS",quantidade);
            break;
            case 3:
                System.out.println("Quantidade: ");
                quantidade = teclado.nextDouble();
                moeda.DolarParaReal("USD",quantidade);
            break;
            case 4:
                System.out.println("Quantidade: ");
                quantidade = teclado.nextDouble();
                moeda.RealParaDolar("BRL",quantidade);
            break;
            case 5:
                System.out.println("Quantidade: ");
                quantidade = teclado.nextDouble();
                moeda.DolarParaPesoComlombiano("USD",quantidade);
            break;
            case 6:
                System.out.println("Quantidade: ");
                quantidade = teclado.nextDouble();
                moeda.DolarParaPesoComlombiano("COP",quantidade);
            break;
            case 7:
                System.out.println("saindo");
            break;
            default:
                System.out.println("Opção invalida");
            break;




        }



    }
}
