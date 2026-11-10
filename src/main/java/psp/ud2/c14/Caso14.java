package psp.ud2.c14;

public class Caso14 {
    static class Inventario {
        int unidades;
        void anadir(){ synchronized(new Object()) {unidades++;} }
    }
    public static void main(String[] args) throws InterruptedException {
        Inventario inv=new Inventario();Thread[] hilos=new Thread[10];
        for(int i=0;i<10;i++){hilos[i]=new Thread(()->{for(int j=0;j<50_000;j++)inv.anadir();});hilos[i].start();}
        for(Thread t:hilos)t.join();
        System.out.println("TOTAL="+inv.unidades+" ESPERADO=500000");
    }
}
