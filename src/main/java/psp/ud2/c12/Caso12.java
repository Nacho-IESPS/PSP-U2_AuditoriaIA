package psp.ud2.c12;

import java.util.concurrent.atomic.AtomicInteger;
public class Caso12 {
    static AtomicInteger saldo = new AtomicInteger(50);
    static AtomicInteger aprobadas = new AtomicInteger();
    static void retirar(int importe) {
        if(saldo.get()>=importe) {
            try {Thread.sleep(15);} catch(InterruptedException e){Thread.currentThread().interrupt();return;}
            saldo.addAndGet(-importe);
            aprobadas.incrementAndGet();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos=new Thread[12];
        for(int i=0;i<12;i++){hilos[i]=new Thread(()->retirar(10));hilos[i].start();}
        for(Thread t:hilos)t.join();
        System.out.println("SALDO="+saldo.get()+" APROBADAS="+aprobadas.get()+" ESPERADO=saldo>=0 y aprobadas<=5");
    }
}
