package psp.ud2.c08;

import java.util.ArrayList;
import java.util.List;
public class Caso08 {
    record Pedido(List<String> productos) { }
    public static void main(String[] args) {
        var originales=new ArrayList<String>(); originales.add("Caja");
        Pedido pedido=new Pedido(originales);
        originales.add("Sobre");
        System.out.println("PRODUCTOS="+pedido.productos()+" ESPERADO=[Caja]");
    }
}
