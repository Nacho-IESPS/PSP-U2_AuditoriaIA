package psp.ud2.c13;

import java.util.concurrent.atomic.LongAdder;
public class Caso13 {
    static LongAdder admitidos=new LongAdder();
    public static void main(String[] args) throws InterruptedException {
        Thread[] usuarios=new Thread[30];
        for(int i=0;i<30;i++) {
            usuarios[i]=new Thread(()->{
                if(admitidos.sum()<10){
                    try {Thread.sleep(10);}catch(InterruptedException e){Thread.currentThread().interrupt();return;}
                    admitidos.increment();
                }
            }); usuarios[i].start();
        }
        for(Thread t:usuarios)t.join();
        System.out.println("ADMITIDOS="+admitidos.sum()+" ESPERADO=10");
    }
}
