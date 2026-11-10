package psp.ud2.c25;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public class Caso25 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool=Executors.newFixedThreadPool(3);
        AtomicInteger hechas=new AtomicInteger();
        for(int i=0;i<20;i++) pool.submit(()->{
            try {Thread.sleep(40);hechas.incrementAndGet();}
            catch(InterruptedException e){Thread.currentThread().interrupt();}
        });
        pool.shutdownNow();pool.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("COMPLETADAS="+hechas.get()+" ESPERADO=20");
    }
}
