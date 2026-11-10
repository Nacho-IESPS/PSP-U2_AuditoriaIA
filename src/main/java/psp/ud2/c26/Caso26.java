package psp.ud2.c26;

import java.util.concurrent.*;
import java.util.*;
public class Caso26 {
    public static void main(String[] args) throws Exception {
        ExecutorService pool=Executors.newFixedThreadPool(4);
        List<Future<Integer>> resultados=new ArrayList<>();
        for(int i=0;i<8;i++) resultados.add(pool.submit(()->{Thread.sleep(70);return 100;}));
        int total=0;
        for(Future<Integer> f:resultados)if(f.isDone())total+=f.get();
        pool.shutdown();pool.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("TOTAL="+total+" ESPERADO=800");
    }
}
