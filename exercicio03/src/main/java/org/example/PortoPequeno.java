package org.example;

public class PortoPequeno extends BasePorto {

    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.getTamanho() <= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println(barco.getNome() + " não pode ser atracado no " + nome + " devido ao seu tamanho.");
        }
    }
}
