package psp.ud2.c02;

import java.util.concurrent.atomic.AtomicInteger;
public class Caso02 {
    public static void main(String[] args) {
        AtomicInteger realizadasEnMain = new AtomicInteger();
        Runnable una = () -> {
            if (Thread.currentThread().getName().equals("main")) realizadasEnMain.incrementAndGet();
            System.out.println("TAREA=preparar: " + Thread.currentThread().getName());
        };
        Runnable dos = () -> {
            if (Thread.currentThread().getName().equals("main")) realizadasEnMain.incrementAndGet();
            System.out.println("TAREA=etiquetar: " + Thread.currentThread().getName());
        };
        una.run(); dos.run();
        System.out.println("MAIN=" + realizadasEnMain.get() + " ESPERADO=0");
    }
}
