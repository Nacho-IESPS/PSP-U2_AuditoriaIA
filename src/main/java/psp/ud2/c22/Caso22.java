package psp.ud2.c22;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class Caso22 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q=new ArrayBlockingQueue<>(2);
        Thread consumidor=new Thread(()->{
            int procesados=0;
            while(true){
                try{int n=q.take();if(n==-1)break;procesados++;Thread.sleep(12);}
                catch(InterruptedException e){Thread.currentThread().interrupt();return;}
            }
            System.out.println("PROCESADOS="+procesados+" ESPERADO=30");
        });
        consumidor.start();
        for(int i=0;i<30;i++)q.offer(i);
        q.put(-1);consumidor.join();
    }
}
