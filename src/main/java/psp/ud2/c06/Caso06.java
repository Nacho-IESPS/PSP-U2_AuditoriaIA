package psp.ud2.c06;

public class Caso06 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try { Thread.sleep(200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        long inicio=System.nanoTime(); t.start();
        long medido=System.nanoTime()-inicio;
        System.out.printf("MEDIDA_MS=%.2f ESPERADO=aproximadamente 200 ms%n", medido/1_000_000.0);
        t.join();
    }
}
