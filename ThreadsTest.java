package task7_2;

import java.util.Random;
import java.text.DecimalFormat;

class Threads extends Thread implements Runnable   {
    public void run()   {
        int min1 = 2;
        int max1 = 25;
        double min = 1;
        double max = 100;
        Random r = new Random();
        int count = 0;
        String s;
        double x;
        Konto k = new Konto(0.0);
        int randomValue1 = r.nextInt(10) + 2;
        for(int i = 0; i < randomValue1; i++)  {
            try{
                double randomValue2 = min + (max - min) * r.nextDouble();
                s = roundOffTo2DecPlaces(randomValue2);
                x = Double.parseDouble(s.replace(",", "."));
                Thread.sleep(1000);
                k.einzahlen(x);
                count++;
                System.out.printf("%.2f", k.getKontostand());
                System.out.println(" Euro");
            } catch (InterruptedException e)    {
                interrupt();
            } 
        }
        System.out.println("Es wurden insgesamt " + count + " Additionen von durchgeführt");
    }
    
    String roundOffTo2DecPlaces(double val) {
        return String.format("%.2f", val);
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
