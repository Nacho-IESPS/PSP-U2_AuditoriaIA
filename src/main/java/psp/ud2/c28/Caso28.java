package psp.ud2.c28;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
public class Caso28 {
    public static void main(String[] args) {
        AtomicBoolean lista=new AtomicBoolean();
        CompletableFuture<String> origen=CompletableFuture.supplyAsync(()->"pedido");
        origen.thenApplyAsync(s->{
            try{Thread.sleep(180);}catch(InterruptedException e){Thread.currentThread().interrupt();}
            lista.set(true);return s.toUpperCase();
        });
        origen.join();
        System.out.println("ETAPA_FINAL="+lista.get()+" ESPERADO=true");
    }
}
