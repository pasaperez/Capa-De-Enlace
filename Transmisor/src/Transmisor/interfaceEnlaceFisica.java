package Transmisor;

import javax.comm.NoSuchPortException;

public class interfaceEnlaceFisica {
    Fisica f;
    Enlace e;

    public Fisica getF() {
        return f;
    }

    public void setF(Fisica f) {
        this.f = f;
    }
    
    public void recibir(String trama) throws NoSuchPortException{
        f.enviar(trama);
    
    }
    public boolean ack(int ack){
        return e.ack(ack); 
    }
    
}