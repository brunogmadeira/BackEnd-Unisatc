import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Creeper> inimigos = new ArrayList<>();
        inimigos.add(new Creeper("Orc", 100, 10));
        inimigos.add(new Creeper("Goblin", 50, 5));
        inimigos.add(new Creeper("Creeper", 75, 15));

        Personagem jogador = new Personagem("Steve", 200, 100);

        Random random = new Random();

        while (jogador.getVida() > 0 && !todosInimigosDerrotados(inimigos)) {
            Personagem inimigo = inimigos.get(random.nextInt(inimigos.size()));
            jogador.atacar(inimigo);

            if (todosInimigosDerrotados(inimigos)) {
                break;
            }

            for (Creeper inim : inimigos) {
                if (inim.getVida() > 0 && jogador.getVida() > 0) {
                    inim.atacar(jogador);
                }
            }

            if (jogador.getVida() <= 0) {
                System.out.println(jogador.getNome() + " foi derrotado!");
                return;
            }
        }

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
