package psp.ud2.c05;

public class Caso05 {
    static boolean guardarPedido() {
        try { Thread.sleep(250); }
        catch (InterruptedException e) { System.out.println("AVISO=se canceló la espera"); }
        return true;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("CONFIRMACION="+guardarPedido()+" ESPERADO=false"));
        t.start(); Thread.sleep(35); t.interrupt(); t.join();
    }
}
