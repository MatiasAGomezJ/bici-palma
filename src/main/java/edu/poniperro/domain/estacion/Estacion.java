package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;

import java.util.Arrays;

public class Estacion {
    private final int id;
    private final String direccion;
    public final Anclajes anclajes;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        anclajes = new Anclajes(numAnclajes);
    }

    private int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "id: " + id + ", direccion: " + direccion + ", anclaje: " + anclajes;
    }

    private Anclaje[] anclajes() {
        return anclajes.anclajes();
    }

    private int numAnclajes() {
        return anclajes.numAnclajes();
    }

    public void consultarEstacion() {
        System.out.println(this);
    }

    public int anclajesLibres() {
        return Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).count();
    }

    public void anclarBicicleta(Movil bici) {
        int posicion = anclajes.seleccionarAnclaje();
        anclajes.anclajes()[posicion].anclarBici(bici);
    }
}