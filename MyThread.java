package task7_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FIni
 */
class MyThread extends Thread implements Runnable {
	
    public void run()   {
        System.out.println("Begin run");
        for(int i = 0; i < 5; i++)  {
            try{
                Thread.sleep(1000);
                System.out.println("HIP");
                Thread.sleep(1000);
                System.out.println("HOP");
            } catch (InterruptedException e)    {
                interrupt();
            }
        }
    }
    public static void main(String[] args)  {
    	
        MyThread t = new MyThread();
        t.start();
        
        for (int i = 0; i < 14850; i++)
        	;
        
        MyThread s = new MyThread();
        try{
            Thread.sleep(2500);
            s.start();
            } catch (InterruptedException e)    {
                
            } finally	{
            	System.out.println(t.getName() + " Priorität: " + t.getPriority());
            	System.out.println(s.getName() + " Priorität: " + s.getPriority());
            }
    	
    }
}