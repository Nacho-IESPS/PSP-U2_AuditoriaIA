package psp.ud2.c23;

import java.util.concurrent.ConcurrentHashMap;
public class Caso23 {
    static ConcurrentHashMap<String,Integer> mapa=new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos=new Thread[8];
        for(int i=0;i<8;i++){
            hilos[i]=new Thread(()->{
                for(int j=0;j<50_000;j++) {
                    int v=mapa.getOrDefault("visitas",0);
                    mapa.put("visitas",v+1);
                }
            });hilos[i].start();
        }
        for(Thread t:hilos)t.join();
        System.out.println("VISITAS="+mapa.get("visitas")+" ESPERADO=400000");
    }
}
