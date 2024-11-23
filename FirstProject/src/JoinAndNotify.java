class Q {

    int a;
    boolean valueSet = false;

    public synchronized void put(int t) {
        while (valueSet) {
            try {
                wait();
                System.out.println("hel");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("put " + t);
        this.a = t;
        valueSet = true;
        notify();


    }

    public synchronized void get() {
        while (!valueSet) {

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        valueSet = false;
        notify();
        System.out.println("get " + a);
    }

}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "producer");
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {

            q.put(i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Consumer implements Runnable {

    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "consumer");
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class JoinAndNotify {
    public static void main(String[] args) {

        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
    }
}
