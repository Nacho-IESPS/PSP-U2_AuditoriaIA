package psp.ud2.c27;

import java.util.concurrent.*;
public class Caso27 {
    static final Object ventanilla=new Object();
    public static void main(String[] args) throws Exception {
        long inicio=System.nanoTime();
        try(ExecutorService pool=Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?>[] trabajos=new Future[40];
            for(int i=0;i<40;i++) trabajos[i]=pool.submit(()->{
                synchronized(ventanilla) {
                    try{Thread.sleep(35);}catch(InterruptedException e){Thread.currentThread().interrupt();}
                }
            });
            for(Future<?> f:trabajos)f.get();
        }
        System.out.println("DURACION_MS="+((System.nanoTime()-inicio)/1_000_000)+" ESPERADO=mucho menos de 1200");
    }
}
