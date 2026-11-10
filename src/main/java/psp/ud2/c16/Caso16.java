package psp.ud2.c16;

public class Caso16 {
    static class Cuenta { final int id; int saldo=100; Cuenta(int id){this.id=id;} }
    static void transferir(Cuenta origen, Cuenta destino) {
        synchronized(origen) {
            try {Thread.sleep(100);}catch(InterruptedException e){Thread.currentThread().interrupt();return;}
            synchronized(destino){origen.saldo-=10;destino.saldo+=10;}
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Cuenta a=new Cuenta(1),b=new Cuenta(2);
        Thread t1=new Thread(()->transferir(a,b));Thread t2=new Thread(()->transferir(b,a));
        t1.setDaemon(true);t2.setDaemon(true);
        t1.start();t2.start();t1.join(450);t2.join(450);
        System.out.println("VIVOS="+t1.isAlive()+","+t2.isAlive()+" ESPERADO=false,false");
    }
}
