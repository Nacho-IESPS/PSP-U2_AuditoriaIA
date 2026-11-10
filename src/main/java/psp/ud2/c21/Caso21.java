package psp.ud2.c21;

import java.util.ArrayDeque;
import java.util.Queue;
public class Caso21 {
    static class Buzon {
        Queue<Integer> cola=new ArrayDeque<>();
        synchronized void poner(int v) throws InterruptedException {
            while(cola.size()==1)wait();cola.add(v);notify();
        }
        synchronized int sacar() throws InterruptedException {
            while(cola.isEmpty())wait();int r=cola.remove();notify();return r;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Buzon b=new Buzon();Thread[] hilos=new Thread[6];
        for(int i=0;i<3;i++){
            int id=i;
            hilos[i]=new Thread(()->{for(int j=0;j<6;j++)try{b.poner(id*10+j);}catch(InterruptedException e){Thread.currentThread().interrupt();return;}});
            hilos[i+3]=new Thread(()->{for(int j=0;j<6;j++)try{b.sacar();}catch(InterruptedException e){Thread.currentThread().interrupt();return;}});
        }
        for(Thread t:hilos){t.setDaemon(true);t.start();}
        for(Thread t:hilos)t.join(700);
        int vivos=0;for(Thread t:hilos)if(t.isAlive())vivos++;
        System.out.println("VIVOS="+vivos+" ESPERADO=0");
    }
}
