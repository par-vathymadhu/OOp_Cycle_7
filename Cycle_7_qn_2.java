/**Write a Java program that simulate a banking environment using all the cases thread
synchronization concept( synchronisation method, synchronization block, static synchronization,
inter-process communication.**/

import java.util.*;

class process
{
	int x=10000;
	synchronized void withdraw(int x)
    {
	    if (this.x<x)
		{
            try
			{
			    wait();
		    }
		    catch(Exception e)
		    {}
	    }
		x=x-this.x;
		System.out.println("Withdraw completed...");
	}
	void deposit(int a)
	{
		synchronized (this)
		{
			x+=this.x;
			System.out.println("Deposit completed...");
			notify();
		}
	}
}
class t1 extends Thread
{
	process p;
	t1(process p)
	{
		this.p=p;
	}
	public void run()
	{
		p.withdraw(15000);
	}
}
class t2 extends Thread
{
	process p;
	t2(process p)
	{
		this.p=p;
	}
	public void run()
	{
		p.deposit(20000);
	}
}

class Cycle_7_qn_2
{
    public static void main(String args[])
	{
		process obj = new process();
		t1 tone = new t1(obj);
		t2 ttwo = new t2(obj);
		tone.start();
		ttwo.start();
	}
}

