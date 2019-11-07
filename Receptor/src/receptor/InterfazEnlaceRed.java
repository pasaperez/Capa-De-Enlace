package receptor;

public class InterfazEnlaceRed {
    Red r;
    boolean recibir(String paquete){
        boolean b = r.recibir(paquete);
        return b;
    }
    void setRed(Red r){
        this.r = r;
    }
}