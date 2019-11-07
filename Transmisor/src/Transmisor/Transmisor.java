package Transmisor;

import java.io.IOException;
import Transmisor.Enlace;
import Transmisor.Fisica;
import java.util.Arrays;
import javax.comm.NoSuchPortException;


public class Transmisor {

    public static void main(String[] args) throws IOException, NoSuchPortException {
        Fisica f=new Fisica();
        interfaceEnlaceFisica ief=new interfaceEnlaceFisica();
        Enlace e=new Enlace();
        interfaceRedEnlace ire=new interfaceRedEnlace();
        Red r=new Red();
        ief.setF(f);
        ire.setE(e);
        e.setIef(ief);
        r.setIre(ire);
        r.enviar();
                            
    }
}   