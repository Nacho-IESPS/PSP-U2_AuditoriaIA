package psp.ud2.c07;

public class Caso07 {
    static int pedidos;
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos=new Thread[8];
        for(int i=0;i<hilos.length;i++) {
            hilos[i]=new Thread(()->{for(int j=0;j<100_000;j++) pedidos++;}); hilos[i].start();
        }
        for(Thread t:hilos)t.join();
        System.out.println("TOTAL="+pedidos+" ESPERADO=800000");
    }
}
