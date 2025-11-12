package Multithreading;

import org.w3c.dom.css.Counter;

  class Restaurant_Counter
{
    private String dish;
    private boolean available = false;

    synchronized  void produce(String dishname) throws  InterruptedException
    {
        while(available)
        {
            System.out.println("[chef] waiting... counter is full");
            wait();
        }

        this.dish =     dishname;
        available = true;
        System.out.println("[chef] cooked and placed : " + dish);
        notify(); //wakeup  waiter

    }


    synchronized void consume() throws InterruptedException
    {
        while(!available)
        {
            System.out.println("[waiter] waiting.... No dish is counter");
            wait();
        }

        System.out.println("[waiter] Pickedup and served:" +dish );
        available = false;
        notify();
    }
}

class chef extends  Thread
{
    private Restaurant_Counter counter;
    private String[] dishes = {"pasta", "burger","pizza","sandwich","salad"};

    chef(Restaurant_Counter counter)
    {

        this.counter = counter;
    }

    public void run()
    {
        try
        {
            for(String dish:dishes)
            {
                counter.produce(dish);
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}


class Waiter extends Thread {
    private Restaurant_Counter counter;

    Waiter(Restaurant_Counter counter) {
        this.counter = counter;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                counter.consume();
                Thread.sleep(1500); // simulate time to serve
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class RestaurantDemo
{

    public static  void main(String[] args)
    {
        Restaurant_Counter counter = new  Restaurant_Counter();
        chef chef = new chef(counter);
        Waiter waiter = new Waiter(counter);

        chef.start();
        waiter.start();
    }
}
