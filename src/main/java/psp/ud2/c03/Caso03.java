package psp.ud2.c03;

public class Caso03 {
    public static void main(String[] args) throws InterruptedException {
        Thread trabajador = new Thread(() -> {
            int hechas = 0;
            for (int i=0; i<40; i++) {
                long hasta = System.nanoTime()+3_000_000L;
                while (System.nanoTime()<hasta) { /* cálculo */ }
                hechas++;
            }
            System.out.println("HECHAS="+hechas+" ESPERADO=menos de 40");
        });
        trabajador.start(); Thread.sleep(15); trabajador.interrupt(); trabajador.join();
    }
}
