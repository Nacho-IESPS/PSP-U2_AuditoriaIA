package psp.ud2.c10;

public class Caso10 {
    static volatile int total = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos=new Thread[6];
        for(int i=0;i<6;i++){
            hilos[i]=new Thread(()->{for(int j=0;j<100_000;j++)total++;});hilos[i].start();
        }
        for(Thread t:hilos)t.join();
        System.out.println("TOTAL="+total+" ESPERADO=600000");
    }
}
