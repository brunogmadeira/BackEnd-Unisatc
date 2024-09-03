import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Criando os inimigos
        List<Creeper> inimigos = new ArrayList<>();
        inimigos.add(new Creeper("Orc", 100, 10));
        inimigos.add(new Creeper("Goblin", 50, 5));
        inimigos.add(new Creeper("Creeper", 75, 15));

        // Criando o jogador
        Personagem jogador = new Personagem("Steve", 200, 100);

        Random random = new Random();

        // Loop do jogo
        while (jogador.getVida() > 0 && !todosInimigosDerrotados(inimigos)) {
            // Jogador ataca um inimigo aleatório
            Personagem inimigo = inimigos.get(random.nextInt(inimigos.size()));
            jogador.atacar(inimigo);

            // Se todos os inimigos foram derrotados, o jogo termina
            if (todosInimigosDerrotados(inimigos)) {
                break;
            }

            // Inimigos atacam o jogador
            for (Creeper inim : inimigos) {
                if (inim.getVida() > 0 && jogador.getVida() > 0) {
                    inim.atacar(jogador);
                }
            }

            // Verificar se o jogador foi derrotado
            if (jogador.getVida() <= 0) {
                System.out.println(jogador.getNome() + " foi derrotado!");
                return;
            }
        }

        // Resultado final
        if (jogador.getVida() > 0) {
            System.out.println("Todos os inimigos foram derrotados!");
        }
    }

    public static boolean todosInimigosDerrotados(List<Creeper> inimigos) {
        for (Creeper inimigo : inimigos) {
            if (inimigo.getVida() > 0) {
                return false;
            }
        }
        return true;
    }
}
