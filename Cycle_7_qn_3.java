/**Write a Java program to create two threads: One for displaying all odd number between 1 and
100 and second thread for displaying all even numbers between 1 and 100.**/

import java.util.*;

class odd extends Thread
{
    public void run()
    {
        for(int i=1;i<=100;i+=2)
        {
            System.out.print(i+",");
        }
    }
}
class even extends Thread
{
    public void run()
    {
        for(int i=2;i<=100;i+=2)
        {
            System.out.print(i+",");
        }
    }
}
class Cycle_7_qn_3
{
        public static void main(String args[])
        {
            odd t1 = new odd();
            even t2=new even();
            System.out.println("ODD NUMBERS:");
            t1.start();
            try
            {
                t1.join();
                System.out.println("\nEVEN NUMBERS:");
                t2.start();
            }
            catch(Exception e)
            {}
        }
}