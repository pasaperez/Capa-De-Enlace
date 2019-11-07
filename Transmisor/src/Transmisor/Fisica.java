package Transmisor;

import java.io.InputStream;
import java.io.OutputStream;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.SerialPort;

public class Fisica {
    //busca todos los puertos y los guarda en el objeto puertos
    OutputStream ops; 
    InputStream ack;
    CommPortIdentifier portId; // identifica los puertos com
    CommPortIdentifier portId2; // identifica los puertos com
    SerialPort serialport;
    SerialPort serialport2;
    interfaceEnlaceFisica ief;  
    char[] a;
    String b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;
    
public void enviar(String trama) throws NoSuchPortException{
	
 	portId = CommPortIdentifier.getPortIdentifier("COM5"); //next elemento recorre uno por uno
 	portId2 = CommPortIdentifier.getPortIdentifier("COM6"); //next elemento recorre uno por uno
 	
	System.out.println(portId.getName()); 
        try {
            serialport= (SerialPort)portId.open("EscrituraSerial1",500);//tiempo en ms
            serialport2= (SerialPort)portId2.open("EscrituraSerial2",500);//tiempo en ms
            ops=serialport.getOutputStream();
            ack=serialport2.getInputStream();
            
            System.out.println(trama);
            a=trama.toCharArray();
            b=Character.toString(a[0]);
            c=Character.toString(a[1]);
            d=Character.toString(a[2]);
            e=Character.toString(a[3]);
            f=Character.toString(a[4]);
            g=Character.toString(a[5]);
            h=Character.toString(a[6]);
            i=Character.toString(a[7]);
            j=Character.toString(a[8]);
            k=Character.toString(a[9]);
            l=Character.toString(a[10]);
            m=Character.toString(a[11]);
            n=Character.toString(a[12]);
            o=Character.toString(a[13]);
            p=Character.toString(a[14]);
            q=Character.toString(a[15]);
            
            ops.write(b.getBytes());//get bytes transforma el string a bytes
            ops.write(c.getBytes());//get bytes transforma el string a bytes
            ops.write(d.getBytes());//get bytes transforma el string a bytes
            ops.write(e.getBytes());//get bytes transforma el string a bytes
            ops.write(f.getBytes());//get bytes transforma el string a bytes
            ops.write(g.getBytes());//get bytes transforma el string a bytes
            ops.write(h.getBytes());//get bytes transforma el string a bytes
            ops.write(i.getBytes());//get bytes transforma el string a bytes
            ops.write(j.getBytes());//get bytes transforma el string a bytes
            ops.write(k.getBytes());//get bytes transforma el string a bytes
            ops.write(l.getBytes());//get bytes transforma el string a bytes
            ops.write(m.getBytes());//get bytes transforma el string a bytes
            ops.write(n.getBytes());//get bytes transforma el string a bytes
            ops.write(o.getBytes());//get bytes transforma el string a bytes
            ops.write(p.getBytes());//get bytes transforma el string a bytes
            ops.write(q.getBytes());//get bytes transforma el string a bytes

            if(ief.ack(ack.read()))
            {
                ops.write(b.getBytes());//get bytes transforma el string a bytes
                ops.write(c.getBytes());//get bytes transforma el string a bytes
            }
            else 
            {
                ops.close(); 
                ack.close();
            }
            serialport.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error 2");
        }
    }
}