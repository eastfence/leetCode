import java.util.concurrent.locks.LockSupport;

public class BossConsumer {
    public static void start() {
        ThreadPool.execute(() -> {
            while (true) {
                Integer userId = BossQueue.poll();
                if (userId == null) {
                    LockSupport.parkNanos(1000000); // 1ms
                    continue;
                }
                System.out.println(userId + " 攻击了");
            }
        });
    }
    public static void start2() {
        while (true) {
            Integer userId = BossQueue.poll();
            if (userId == null) {
                LockSupport.parkNanos(1000000);
                continue;
            }
            System.out.println(userId + " 攻击了");
        }
    }
}