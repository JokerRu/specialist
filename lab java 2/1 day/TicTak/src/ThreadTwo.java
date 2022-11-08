public class ThreadTwo implements Runnable
{
    private final Thread self;
    private final Object monitor;

    public Thread getSelf()
    {
        return self;
    }

    public ThreadTwo(Object mon)
    {
        monitor = mon;
        self = new Thread (this);
    }

    @Override
    public void run()
    {
        try {
//            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    System.out.println(2);
                    monitor.notify();
                    if (i < TicTak.num - 1) {
                        monitor.wait();
                    }
                }
            }
        }
        catch (InterruptedException e) { }
    }
}