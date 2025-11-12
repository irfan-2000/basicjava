package Multithreading;

import java.lang.Thread;

 public  class TestThread1 extends  Thread
{
    @Override
    public void run()
    {
        for (int i=1;i<=5;i++)
        {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}

