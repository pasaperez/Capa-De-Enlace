package receptor;

import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;

public class Receptor {

    public static void main(String[] args) throws NoSuchPortException, PortInUseException {
        Fisica f= new Fisica();
        InterfazFisicaEnlace ife = new InterfazFisicaEnlace();
        Enlace e = new Enlace();
        InterfazEnlaceRed ier = new InterfazEnlaceRed();
        Red r = new Red();
        
        f.setIfe(ife);
        ife.setEnlace(e);
        e.setInterfazFisicaEnlace(ife);
        e.setInterfazEnlaceRed(ier);
        ier.setRed(r);
        
        f.LecturaSerial();
        
        //ife.recibir("1011011101000101");       
    }
    
}