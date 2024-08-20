package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Random numeroaleatorio = new Random();
    Scanner leitor = new Scanner(System.in);

    while(true){
    System.out.println("Pergunta 1: Que ambientação você prefere?");
    System.out.println("1. Sci-fi");
    System.out.println("2. Medieval");
    Integer amb = leitor.nextInt();

    System.out.println("Pergunta 2: Que gênero você prefere?");
    System.out.println("1. Comédia");
    System.out.println("2. Drama");
    Integer gen = leitor.nextInt();

    if(amb != 1 && amb != 2 && gen != 1 && gen != 2){
        return;
    } else if (gen == 1 && amb ==1) {
        System.out.println("Homens de preto");
    } else if (gen ==2 && amb ==1) {
        System.out.println("Shrek");
    } else if (gen == 1 && amb == 2) {
        System.out.println("Arrival");
    } else if (gen == 2 && amb == 2) {
        System.out.println("Gladiador");
    }


    }
    }
}