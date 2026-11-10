package psp.ud2.c09;

public class Caso09 {
    private static boolean abierto = true;
    public static void main(String[] args) throws InterruptedException {
        Thread trabajador=new Thread(()->{
            long vueltas=0;
            while(abierto) { vueltas++; }
            System.out.println("CIERRE_CONFIRMADO="+vueltas);
        });
        trabajador.setDaemon(true); trabajador.start();
        Thread.sleep(100); abierto=false;
        trabajador.join(350);
        System.out.println("PUEDE_SEGUIR="+trabajador.isAlive()+" ESPERADO=false");
    }
}
