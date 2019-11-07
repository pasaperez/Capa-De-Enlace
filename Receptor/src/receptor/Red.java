package receptor;

public class Red {
    boolean recibir(String paquete)
    {
        char c = (char)Integer.parseInt(paquete, 2);
        
        System.out.println(c);
        return true;
    }
}