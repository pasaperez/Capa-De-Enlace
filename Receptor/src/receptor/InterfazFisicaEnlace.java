package receptor;

public class InterfazFisicaEnlace {
    Enlace enlace;
    Fisica fisica;
    boolean recibir(String msg){
        boolean b = enlace.recibir(msg);
        return b;
    }
    void setEnlace(Enlace e){
        enlace = e; 
    }
}