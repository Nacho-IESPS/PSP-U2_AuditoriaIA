package psp.ud2.c18;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class Caso18 {
    static ReentrantLock lock=new ReentrantLock(true);
    static void operacion(){lock.lock();System.out.println("PRIMERO=hecho");}
    public static void main(String[] args) throws InterruptedException {
        Thread uno=new Thread(Caso18::operacion);uno.start();uno.join();
        Thread dos=new Thread(()->{
            try {boolean ok=lock.tryLock(150,TimeUnit.MILLISECONDS);
                System.out.println("SEGUNDO="+ok+" ESPERADO=true");
                if(ok)lock.unlock();
            }catch(InterruptedException e){Thread.currentThread().interrupt();}
        });dos.start();dos.join();
    }
}
