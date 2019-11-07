package receptor;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.comm.CommPort;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;

public class Fisica {
    CommPortIdentifier portId;	
    CommPortIdentifier portId2;   
    SerialPort serialport;
    SerialPort serialport2;
    InputStream entrada = null;
    OutputStream ack=null;
    InterfazFisicaEnlace ife;
    
    public void LecturaSerial() throws NoSuchPortException, PortInUseException{
        
        portId =CommPortIdentifier.getPortIdentifier("COM5");
        portId2 =CommPortIdentifier.getPortIdentifier("COM6");
        serialport= (SerialPort)portId.open("EscrituraSerial1", 500);
        serialport2= (SerialPort)portId2.open("EscrituraSerial2", 500);
        try 
        {
            entrada=serialport.getInputStream();
            ack=serialport2.getOutputStream();
            String trama;
            char a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
            a=(char) entrada.read();
            b=(char) entrada.read();
            c=(char) entrada.read();
            d=(char) entrada.read();
            e=(char) entrada.read();
            f=(char) entrada.read();
            g=(char) entrada.read();
            h=(char) entrada.read();
            i=(char) entrada.read();
            j=(char) entrada.read();
            k=(char) entrada.read();
            l=(char) entrada.read();
            m=(char) entrada.read();
            n=(char) entrada.read();
            o=(char) entrada.read();
            p=(char) entrada.read();
            trama=String.valueOf(a)+String.valueOf(b)+String.valueOf(c)+String.valueOf(d)+String.valueOf(e)+String.valueOf(f)+String.valueOf(g)+String.valueOf(h)+String.valueOf(i)+String.valueOf(j)+String.valueOf(k)+String.valueOf(l)+String.valueOf(m)+String.valueOf(n)+String.valueOf(o)+String.valueOf(p);
            System.out.println(trama);
            
            if(ife.recibir(trama))
            {
                ack.write(1);
            }
            else 
            {
                ack.write(0);
                serialport.close();
            }
        }
        catch (Exception e) 
        {
            System.out.println("Error 1");
        }
    }

    public InterfazFisicaEnlace getIfe() {
        return ife;
    }

    public void setIfe(InterfazFisicaEnlace ife) {
        this.ife = ife;
    }
}