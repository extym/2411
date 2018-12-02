import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Starter22 {

    public static void main(String[] args) {
        System.out.println();
        ExecutorService service = Executors.newFixedThreadPool();

        service.submit(test1);
        Future<Integer> e = service.submit(new threadCall());
        try {
            System.out.println(e).get());
        }
    }
}
