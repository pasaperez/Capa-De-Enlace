package receptor;

import java.lang.reflect.Array;

public class Enlace implements Runnable {
    InterfazFisicaEnlace ife;
    InterfazEnlaceRed ier;
    String finTrama = "01";
    String comienzoTrama = "10";
    Thread a;
    
    void setInterfazFisicaEnlace(InterfazFisicaEnlace ife){
        this.ife = ife;
    }
    void setInterfazEnlaceRed(InterfazEnlaceRed ier){
        this.ier = ier;
    }
    boolean recibir(String msg){
        //revisa comienzo y fin de trama
        if(msg.startsWith(comienzoTrama))
        {
            if(msg.endsWith(finTrama))
            {
                msg = msg.substring(2, 14);//eliminar el comienzo y fin de trama
            }
        }
        //buscar el codigo original
        String entregarRed = Hamming.receive(msg, 4);       
        String[] binarioPartes = entregarRed.split("");
        StringBuilder sb = new StringBuilder(8);
        
        for(int i=0;i<binarioPartes.length;i++){
            if(binarioPartes[i].charAt(0) == '0'){
                sb.append(binarioPartes[i]);        
            }
            if(binarioPartes[i].charAt(0)== '1'){
                    sb.append(binarioPartes[i]);
                }
        }
        entregarRed = sb.toString();
        
        //enviar a interfazEnlaceRed
        boolean b = ier.recibir(entregarRed);
        //si b es verdadero significa que llego a la capa de red y se envia el ack
        if(b)
        {
            return true;
        }
        else return false;
    }

    @Override
    public void run() {
      
    }
}