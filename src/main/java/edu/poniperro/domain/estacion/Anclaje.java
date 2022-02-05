package edu.poniperro.domain.estacion;
import edu.poniperro.domain.bicicleta.Movil;

public class Anclaje {
    private boolean ocupado = false;
    private Movil bici = null;

    Anclaje() {};

    boolean isOcupado(){
        return ocupado;
    }

    Movil getBici(){
        return bici;
    }

    void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    void liberarBici() {
        this.bici = null;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return "ocupado: " + ocupado;
    }
}
