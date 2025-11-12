package Multithreading;

public class demo
{

    public static  void main(String[] args)
    {
//        Thread t = new Thread(()-> System.out.println("Inside thread 2" +Thread.currentThread().getName() ));
//        t.start();
//        MyThread t1 = new MyThread();
//        t1.start();
//        System.out.println("In the main thread" + Thread.currentThread().getName());

//        MyThread t1 = new MyThread("This is thread-1");
//        MyThread t2 = new MyThread("This is thread-2");
//
//        t1.start();
//        t2.start();

        //testthread t1 = new testthread("Thread-1",2,new Thread());
        // testthread t2 = new testthread("Thread-2",5,new Thread());

       //  t1.start();
       //  t2.start();


        TestThread1 testThread11 = new TestThread1();
        testThread11.start();

    }
}
