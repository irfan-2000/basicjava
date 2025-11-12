package Multithreading;

public class MyThread  extends Thread
{

    private final String name;

    public MyThread(String name)
    {
        this.name = name;
    }

    @Override
    public  void run()
    {
        for(int i=0;i<=3 ;i++)
        {
            try
            {
                System.out.println(this.name + ":" + i);

                Thread.sleep(500);
            }catch (Exception ex)
            {
                System.out.println("In the Catch " + Thread.currentThread().getName());

            }
        }
    }


}
