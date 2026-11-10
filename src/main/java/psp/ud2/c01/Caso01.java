package psp.ud2.c01;

public class Caso01 {
    static class Trabajador extends Thread {
        @Override public void run() { System.out.println("TRABAJADOR=" + Thread.currentThread().getName()); }
    }
    public static void main(String[] args) throws InterruptedException {
        Trabajador t = new Trabajador(); t.setName("operario-1");
        t.run();
        t.join();
        System.out.println("ESPERADO=operario-1");
    }
}
