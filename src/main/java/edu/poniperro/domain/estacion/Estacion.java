package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.*;
import edu.poniperro.domain.tarjetausuario.*;

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
        int anclajesLibres = 0;
        for (Anclaje anclaje : anclajes()) {
            anclajesLibres = anclaje.isOcupado()? anclajesLibres: ++anclajesLibres;
        }
        return anclajesLibres;
    }

    public void anclarBicicleta(Movil bici) {
        int posicion = 0;
        boolean posicionElegida = false;
        while(!posicionElegida){
            posicion = anclajes.seleccionarAnclaje();
            if (!anclajes.isAnclajeOcupado(posicion)) {
                posicionElegida = true;
            }
        }
        anclajes.ocuparAnclaje(posicion, bici);
        mostartAnclaje(anclajes.getBiciAt(posicion), posicion);
    }

    public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjetaUsuario) {
        if (!leerTarjetaUsuario(tarjetaUsuario)) {
            System.out.println("Tarjeta invalida!");
            return;
        }
        int posicion = 0;
        boolean posicionElegida = false;
        while(!posicionElegida){
            posicion = anclajes.seleccionarAnclaje();
            if (anclajes.isAnclajeOcupado(posicion)) {
                posicionElegida = true;
            }
        }
        mostrarBicicleta(anclajes.getBiciAt(posicion), posicion);
        anclajes.liberarAnclaje(posicion);
    }

    private void mostrarBicicleta(Movil bici, int posicion) {
        System.out.println("La bicicleta con id " + bici.getId() + " ha sido retirada del anclaje numero " + posicion);
    }

    private void mostartAnclaje(Movil bici, int posicion) {
        System.out.println("El anclaje numero " + posicion + " ha sido ocupado por la bicicleta con id " + bici.getId());
    }

    public void consultarAnclajes() {
        String texto;
        for (int i = 0; i < anclajes.numAnclajes(); i++) {
            texto = "Anclaje " + i + ": ";
            if (anclajes.isAnclajeOcupado(i)) {
                texto += "Bici " + anclajes.getBiciAt(i).getId();
            } else {
                texto += "Libre";
            }
            System.out.println(texto);
        }
    }
}
