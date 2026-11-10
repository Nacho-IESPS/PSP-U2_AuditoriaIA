package psp.ud2.c20;

import java.util.ArrayDeque;
import java.util.Queue;
public class Caso20 {
    static class Buzon {
        Queue<String> cola=new ArrayDeque<>();
        synchronized String recibir() throws InterruptedException {
            if(cola.isEmpty()) wait();
            return cola.poll();
        }
        synchronized void enviar(String texto){cola.add(texto);notifyAll();}
    }
    public static void main(String[] args) throws InterruptedException {
        Buzon b=new Buzon();
        Runnable lee=()->{try{System.out.println("MENSAJE="+b.recibir());}catch(InterruptedException e){Thread.currentThread().interrupt();}};
        Thread a=new Thread(lee),c=new Thread(lee);
        a.start();c.start();Thread.sleep(100);b.enviar("UNO");Thread.sleep(80);b.enviar("DOS");
        a.join(1000);c.join(1000);
        System.out.println("ESPERADO=UNO y DOS, nunca null");
    }
}
