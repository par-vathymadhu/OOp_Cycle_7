/**1. Write a Java program that implements a multi-threaded program which has three threads. First
thread generates a random integer every 1 second. If the value is even, second thread computes the
square of the number and prints. If the value is odd the third thread will print the value of cube of
the number.**/

import java.util.*;

class sq extends Thread
{
    int x;
    sq(int x)
    {
        this.x=x;
    }
    public void run()
    {
        System.out.println("Thread-2:Square of "+x+" is "+(x*x));
    }
}
class cu extends Thread
{
    int x;
    cu(int x)
    {
        this.x=x;
    }
    public void run()
    {
        System.out.println("Thread-3:Cube of "+x+" is "+(x*x*x));
    }
}

class Cycle_7_qn_1 extends Thread
{
    public void run()
    {
  	    Random r = new Random();
  	    for(int i=0;i<5;i++)
  	    {
  	        int a = r.nextInt(100); 
  	        System.out.println("Thread-1:Random integer generated is "+a);
  	        if(a%2==0)
  	        {
   		        sq t2 = new sq(a);
   		        t2.start();
   		    }       	
  	        else
  	        {
   		        cu t3 = new cu(a);
   	        	t3.start();
   	        }
  	        try
  	        {
  		        Thread.sleep(100);
  	        }
  	        catch(Exception e)
  	        {}
  	    }
    }
    public static void main(String args[])
    {
     	Cycle_7_qn_1 t1 = new Cycle_7_qn_1();
  	    t1.start();
    }
}