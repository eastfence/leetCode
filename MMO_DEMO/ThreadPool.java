import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void execute(Runnable r) {
        executor.execute(r);
    }
}
