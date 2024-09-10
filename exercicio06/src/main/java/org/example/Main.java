package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Homen Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Avatar", 25.0, 10));
        cinema.adicionarFilme(new Filme("Jumanji", 15.0, 8));
        cinema.adicionarFilme(new Filme("O Rei Leão", 18.0, 6));
        cinema.adicionarFilme(new Filme("Jurassic Park", 22.0, 14));

        while (true) {
            try {
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();
                Filme filmeEscolhido = null;

                for (Filme filme : cinema.getFilmesDisponiveis()) {
                    if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                        filmeEscolhido = filme;
                        break;
                    }
                }

                if (filmeEscolhido == null) {
                    System.out.println("Filme não encontrado!");
                    continue;
                }

                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine();

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);
                Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);

                cinema.venderIngresso(ingresso);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
