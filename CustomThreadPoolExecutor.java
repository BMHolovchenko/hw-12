import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {


    public CustomThreadPoolExecutor(int corePoolSize) {
        super (corePoolSize, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<> (10));
    }

    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor =
                new CustomThreadPoolExecutor (10);
        customThreadPoolExecutor.execute (new MyRunnable ());
        customThreadPoolExecutor.shutdown ();
    }

    @Override
    public void execute(Runnable command) {
        int count = command.getClass ().getAnnotation (Repeat.class).executions ();
        while (count > 0) {
            count--;
            super.execute (command);
        }
    }
}