package edu.poniperro.domain.estacion;
import java.util.concurrent.ThreadLocalRandom;
import edu.poniperro.domain.bicicleta.Movil;

import java.util.Arrays;

public class Anclajes {

    private final Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
    }

    private void creaAnclajes() {
        for (int index = 0; index < numAnclajes(); index++) {
            anclajes[index] = new Anclaje();
        }
    }

    Anclaje[] anclajes() {
        return anclajes;
    }

    int numAnclajes() {
        return anclajes.length;
    }

    void ocuparAnclaje(int posAnclaje, Movil bici) {
        anclajes[posAnclaje].anclarBici(bici);
    }

    boolean isAnclajeOupado(int posAnclaje) {
        return anclajes[posAnclaje].isOcupado();
    }

    void liberarAnclaje(int posAnclaje) {
        anclajes[posAnclaje].liberarBici();
    }

    Movil getBiciAt(int posAnclaje) {
        return anclajes[posAnclaje].getBici();
    }

    int seleccionarAnclaje() {
        Integer idAnclaje = ThreadLocalRandom.current().nextInt(0, numAnclajes());
        return idAnclaje;
    }

    @Override
    public String toString() {
        return "anclajes: " + Arrays.toString(anclajes);
    }
}
