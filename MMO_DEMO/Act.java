public class Act {

    public void attack(int user_id) {
        BossQueue.add(user_id);
    }

    public static void main(String[] args) {
        BossConsumer.start();
        var act = new Act();
        act.attack(123);
        act.attack(111);
        act.attack(222);
    }
}
