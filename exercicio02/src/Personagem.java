public class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (vida <= 0) {
            System.out.println(nome + " foi derrotado!");
            this.vida = 0;
        }
    }

    public void atacar(Personagem alvo) {
        if (alvo.getVida() > 0) {
            alvo.receberDano(this.ataque);
        } else {
            System.out.println("O ataque falhou, " + alvo.getNome() + " já foi derrotado!");
        }
    }
}
