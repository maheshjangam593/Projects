package movingpackage;

public class Threads {


    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            for (int i = 0;  i < 5; i++) {
                System.out.println("hellp");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        );
        Thread t2=new Thread(()->{
            for (int i = 0;  i < 5; i++) {
                System.out.println("hi");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        );
        t1.setName("helo thread");
        t2.setName("hi thread");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.start();
        Thread.sleep(500);
        t2.start();
        /*t1.join();*/
        t2.join(); // will stop the execution of main thread untill t2 thread completes its task
        System.out.println("Hello world!");
    }
}