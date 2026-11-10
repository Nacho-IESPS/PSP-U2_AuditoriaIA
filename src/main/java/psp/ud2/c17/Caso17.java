package psp.ud2.c17;

import java.util.concurrent.atomic.AtomicInteger;
public class Caso17 {
    static AtomicInteger hechos=new AtomicInteger();
    static class Persona implements Runnable {
        final AtomicInteger miTurno;
        final AtomicInteger turnoDelOtro;
        Persona(AtomicInteger miTurno, AtomicInteger turnoDelOtro) {
            this.miTurno=miTurno;this.turnoDelOtro=turnoDelOtro;
        }
        @Override public void run(){
            miTurno.set(1); // Quiere pasar
            for(int intento=0;intento<100;intento++){
                if(turnoDelOtro.get()==1) {Thread.yield();continue;} // Cede el paso
                hechos.incrementAndGet();miTurno.set(0);return;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger aQuiere=new AtomicInteger(1), bQuiere=new AtomicInteger(1);
        Thread a=new Thread(new Persona(aQuiere,bQuiere));
        Thread b=new Thread(new Persona(bQuiere,aQuiere));
        a.start();b.start();a.join();b.join();
        System.out.println("COMPLETADOS="+hechos.get()+" ESPERADO=2");
    }
}
