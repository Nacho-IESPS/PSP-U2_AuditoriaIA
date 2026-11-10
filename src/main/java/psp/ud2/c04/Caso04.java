package psp.ud2.c04;

public class Caso04 {
    public static void main(String[] args) throws InterruptedException {
        Thread tarea = new Thread(() -> {
            int procesadas = 0;
            for (int i=0; i<8; i++) {
                try { Thread.sleep(50); }
                catch (InterruptedException e) { System.out.println("AVISO=interrupción recibida"); }
                procesadas++;
            }
            System.out.println("PROCESADAS="+procesadas+" ESPERADO=menos de 8");
        });
        tarea.start(); Thread.sleep(85); tarea.interrupt(); tarea.join();
    }
}
