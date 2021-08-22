import java.util.concurrent.Semaphore;

public class FirstTask {

    static Semaphore hydrogenMolecule = new Semaphore (2);
    static Semaphore oxygenMolecule = new Semaphore (1);

    static class Hydrogen extends Thread {

        public void releaseHydrogen(){
            System.out.print ("H");
            try{
                hydrogenMolecule.acquire ();
            } catch (Exception e) {
                e.printStackTrace ();
            }
            hydrogenMolecule.release ();
        }

        @Override
        public void run() {
            releaseHydrogen ();
        }
    }

    static class Oxygen extends Thread {

        public void releaseOxygen (){
            System.out.print ("O");
            try{
                oxygenMolecule.acquire (1);
            } catch (Exception e) {
                e.printStackTrace ();
            }
            oxygenMolecule.release ();
        }

        @Override
        public void run() {
            releaseOxygen ();
        }
    }




    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Hydrogen ().start ();
            new Hydrogen ().start ();
            new Oxygen ().start ();
        }
    }
}
