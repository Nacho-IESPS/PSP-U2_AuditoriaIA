package psp.ud2.c19;

public class Caso19 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            try {Thread.sleep(300);}catch(InterruptedException e){Thread.currentThread().interrupt();}
        });
        System.out.println("ESTADO="+t.getState()+" ESPERADO=TIMED_WAITING");
        t.start();t.join();
    }
}
