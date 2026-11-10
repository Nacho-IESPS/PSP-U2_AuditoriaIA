package psp.ud2.c29;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;
public class Caso29 {
    static record Envio(String zona,int numero){}
    public static void main(String[] args) throws Exception {
        BlockingQueue<Envio> pendientes=new ArrayBlockingQueue<>(3);
        ConcurrentHashMap<String,Integer> porZona=new ConcurrentHashMap<>();
        AtomicInteger procesados=new AtomicInteger();
        ExecutorService equipo=Executors.newFixedThreadPool(4);
        for(int w=0;w<4;w++) equipo.submit(()->{
            while(!Thread.currentThread().isInterrupted()){
                try{
                    Envio e=pendientes.poll(100,TimeUnit.MILLISECONDS);
                    if(e==null)break;
                    int anterior=porZona.getOrDefault(e.zona(),0);
                    porZona.put(e.zona(),anterior+1);
                    procesados.incrementAndGet();
                    Thread.sleep(4);
                }catch(InterruptedException ex){Thread.currentThread().interrupt();}
            }
        });
        String[] zonas={"Norte","Centro","Sur"};
        for(int i=0;i<60;i++)pendientes.offer(new Envio(zonas[i%3],i));
        equipo.shutdownNow();equipo.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("PROCESADOS="+procesados.get()+" ESPERADO=60");
        System.out.println("ZONAS="+porZona+" ESPERADO={Norte=20,Centro=20,Sur=20}");
    }
}
