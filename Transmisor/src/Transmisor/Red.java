package Transmisor;

import java.io.IOException;
import java.util.Scanner;
import javax.comm.NoSuchPortException;

public class Red {
    char mensaje='a';
    interfaceRedEnlace ire;
    Scanner s=new Scanner(System.in);

    public interfaceRedEnlace getIre() {
        return ire;
    }

    public void setIre(interfaceRedEnlace ire) {
        this.ire = ire;
    }

    public void enviar() throws NoSuchPortException{  
    this.mensaje= s.next().charAt(0);
    ire.recibir(mensaje);
    }
    
}
