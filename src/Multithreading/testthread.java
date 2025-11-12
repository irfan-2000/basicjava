package Multithreading;

public class testthread extends Thread
{
    private String name;
    private int waitTime;
    private Thread secondaryThread;

    public testthread(String name,int waitTime,Thread secondaryThread)
    {
            this.name = name;
            this.waitTime = waitTime;
            this.secondaryThread =secondaryThread;

    }

    @Override
    public void run()
    {
        try
        {
            if(secondaryThread != null && secondaryThread instanceof  Thread)
            {
                secondaryThread.join();

            }
            for (int i = 0;i<= 3; i++)
            {
                System.out.println(this.name + ":" + i);
                Thread.sleep(this.waitTime);
            }

        }catch (Exception ex)
        {
            System.out.println(this.name + "was interrupted");

        }
    }

}
