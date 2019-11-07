package Transmisor;

import java.util.Arrays;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.NoSuchPortException;

public class Enlace {
    interfaceEnlaceFisica ief;
    String comienzoTrama = "10";
    String finTrama = "01";
     
    void recibir (char mensaje) throws NoSuchPortException{
        //Convertir char en array de ints para agregarle bits de codigo hamming 
        String trama = Integer.toBinaryString(mensaje);
        if(trama.length()==7)
        {
           trama = "0" + trama;
        }
        String[] binarioPartes = trama.split("");
        int[] ints = new int[binarioPartes.length];
        
        for(int i=0;i<binarioPartes.length;i++)
        {
            ints[i] = Integer.parseInt(binarioPartes[i]);
        }
        //agregar bits para correcion de errores
        int[] codeDevuelto = new int[Hamming.generateCode(ints).length];
        
        codeDevuelto = Hamming.generateCode(ints);
        
        //volver a string el codigo devuelto
        StringBuilder sb = new StringBuilder(codeDevuelto.length);
        for (int i : codeDevuelto) {
             sb.append(i);
        }
        String codigoDevuelto;
        codigoDevuelto = sb.toString();
        
        //principio y fin de trama
        trama = comienzoTrama + codigoDevuelto + finTrama;
        final String tramaEnviada = trama; 
       //enviar trama a capa fisica
        Timer temporizador = new Timer();
        temporizador.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                    ief.recibir(tramaEnviada);
                } catch (NoSuchPortException ex) {
                    Logger.getLogger(Enlace.class.getName()).log(Level.SEVERE, null, ex);
                }        
            }
        }, 0, 5000);
        
    }
    public boolean ack(int ack){
    if(ack==0)
    {
    return true;
    }
    else
        return false;
    }
    
    public interfaceEnlaceFisica getIef() {
        return ief;
    }

    public void setIef(interfaceEnlaceFisica ief) {
        this.ief = ief;
    }
    
    
}
