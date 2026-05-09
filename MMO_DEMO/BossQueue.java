import java.util.concurrent.ConcurrentLinkedQueue;

public class BossQueue {
    private static final ConcurrentLinkedQueue<Integer> QUEUE = new ConcurrentLinkedQueue<>();

    public static void add(int userId) {
        QUEUE.add(userId);
    }

    public static Integer poll() {
        return QUEUE.poll();
    }
}