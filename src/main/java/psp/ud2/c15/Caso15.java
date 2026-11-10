package psp.ud2.c15;

public class Caso15 {
    static int a=100,b=100;
    static volatile boolean fin=false;
    public static void main(String[] args) throws InterruptedException {
        Thread transferir=new Thread(()->{
            for(int i=0;i<10_000;i++) {
                synchronized(Caso15.class) {a--;}
                Thread.yield();
                synchronized(Caso15.class) {b++;}
                synchronized(Caso15.class) {b--;a++;}
            }
            fin=true;
        });
        transferir.start();int inconsistencias=0;
        while(!fin){synchronized(Caso15.class){if(a+b!=200)inconsistencias++;}}
        transferir.join();
        System.out.println("INCONSISTENCIAS="+inconsistencias+" ESPERADO=0");
    }
}
