package psp.ud2.c24;

import java.util.concurrent.ConcurrentHashMap;
public class Caso24 {
    public static void main(String[] args) {
        var stock=new ConcurrentHashMap<String,Integer>();
        for(int i=0;i<3;i++) stock.merge("cajas",4,(antes,llegadas)->llegadas);
        System.out.println("CAJAS="+stock.get("cajas")+" ESPERADO=12");
    }
}
