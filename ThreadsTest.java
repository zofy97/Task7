package task7_2;

import java.util.Random;

class Threads extends Thread implements Runnable   {
	Konto k = new Konto(0.0);
    public void run()   {
        double min = 1;
        double max = 100;
        Random r = new Random();
        int count = 0;
        
        int randomValue1 = r.nextInt(10) + 2;
        for(int i = 0; i < randomValue1; i++)  {
            try{
                double randomValue2 = min + (max - min) * r.nextDouble();
                Thread.sleep(1000);
                
                k.einzahlen(randomValue2);
                count++;
                System.out.printf("%.2f", k.getKontostand());
                System.out.println(" Euro");
            } catch (InterruptedException e)    {
                interrupt();
            } 
        }
        System.out.println("Es wurden insgesamt " + count + " Additionen von durchgeführt.");
    }
}
public class ThreadsTest {    
    public static void main(String[] args)  {
        System.out.println("Begin\n");
        Threads t = new Threads();
        t.start();
        Threads s = new Threads();
        s.start();
        Threads r = new Threads();
        r.start();
    }
}