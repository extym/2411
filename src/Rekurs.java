public class Rekurs {

    public static void main(String[] args) {

        Thread  thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                show();
            }
        });

        thread1.start();
        for (int i=0; i<40;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void show(){
        while (true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());

            }
        }

    }
}
