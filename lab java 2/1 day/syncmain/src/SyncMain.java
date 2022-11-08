class Data
{
    int count =0;
    static int countSt =0;
}

class MyThread implements Runnable {

    Data obj;

    MyThread(Data d){
        obj = d;
        new Thread(this).start();
    }
    void Add()
    {
        synchronized(Thread.class){
            try {
                Thread.sleep(5);
                int n=obj.count;
                n++;
                Thread.sleep(5);
                obj.count=n;
            } catch (InterruptedException ex) {       }
        }
    }
    synchronized static void AddStatic() {
        try {
            Thread.sleep(5);
            int n=Data.countSt;
            n++;
            Thread.sleep(5);
            Data.countSt=n;
        } catch (InterruptedException ex) {       }
    }
    public void run() {
        for(int i=0; i<10; i++) Add();
        for(int i=0; i<10; i++) AddStatic();
    }
}

public class SyncMain {

    public static void main(String[] args) throws Exception {
        Data d=new Data();
        MyThread t1=new MyThread(d);
        MyThread t2=new MyThread(d);

        Thread.sleep(3000);
        System.out.println(d.count);
        System.out.println(Data.countSt); //выводит 20
    }
}

/*
Data d1=new Data();
        Data d2=new Data();

        MyThread t1=new MyThread(d1);
        MyThread t2=new MyThread(d2);

        Thread.sleep(3000);
        System.out.println(d1.count);
        System.out.println(d2.count);

        System.out.println(d1.countSt);
        System.out.println(d2.countSt);   //будет 10,10 и 20,20
 */