public class Creeper extends Personagem {

    public Creeper(String nome, int vida, int ataque) {
        super(nome, vida, ataque);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(nome + " está explodindo em " + alvo.getNome() + "!");
        super.atacar(alvo);
    }
}
