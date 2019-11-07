package Transmisor;

import Transmisor.Enlace;
import javax.comm.NoSuchPortException;

public class interfaceRedEnlace {
    Enlace e;    
    
    void recibir(char mensaje) throws NoSuchPortException{
    e.recibir(mensaje);    
    }

    public Enlace getE() {
        return e;
    }

    public void setE(Enlace e) {
        this.e = e;
    }   
}