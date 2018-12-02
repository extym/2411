import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class TestThread extends JFrame {
    Thread thread =new Thread();

    public TestThread() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//закрыть через стандартный выход
        setSize(400, 300);
        JTextField field = new JTextField("Timer");
        add(field, BorderLayout.CENTER);
        JButton button = new JButton("Start");
        add(button, BorderLayout.SOUTH);
        pack();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                        long startTime = System.currentTimeMillis();
                        long currentTime=0;
                        while (currentTime<10000
                        //(!Thread.currentThread().isInterrupted()
                        ) {
                            field.setText(dateFormat.format(System.currentTimeMillis() - startTime)+" "+ Thread.currentThread().getName() );
                            System.out.println(dateFormat.format(currentTime)+" "+ Thread.currentThread().getName());
                            try {
                                Thread.currentThread().sleep(1000);
                            } catch (InterruptedException e) {
                                return;

                            }
                        }
                    }
                });

                //thread.setDaemon(true);
                //thread.setPriority(Thread.MIN_PRIORITY);
                thread.start();
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("start window");
        TestThread test=new TestThread();
        test.setVisible(true);
        try {
            test.thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("start main");

        for (int i=0;i<5;i++){
            System.out.println(i*i+"Close main");
        }
    }

}

