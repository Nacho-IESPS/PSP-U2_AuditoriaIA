package psp.ud2.c11;

import java.util.concurrent.atomic.AtomicInteger;
public class Caso11 {
    static AtomicInteger total=new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos=new Thread[8];
        for(int i=0;i<8;i++){
            hilos[i]=new Thread(()->{for(int j=0;j<50_000;j++)total.set(total.get()+1);});hilos[i].start();
        }
        for(Thread t:hilos)t.join();
        System.out.println("TOTAL="+total.get()+" ESPERADO=400000");
    }
}
