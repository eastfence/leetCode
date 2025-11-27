//此demo主要熟悉java语法 java新特效 恢复手感
//2025年11月27日14:32:53

class NewRecord {
    public static void main(String[] args) {

        //17新特性 record
        var player = new Player(10086, "移动");
        System.out.println(player.userId + player.userName);


    }
    record Player(int userId, String userName) {
        // 此类相当于在内部定义了 toString equals hashCode方法
        /*private final int userId;
        private final String userName;

        public Player(int userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }*/
    }
}


class PlayerMonsterDeco {
    public static void main(String[] args) {
        var players = new String[]{"战士", "法师", "射手"};
        var healths = new int[]{100, 90, 80};
        var damage = 20;

        for (int i = 0; i < players.length; i++) {
            var newHealth = healths[i] - damage;
            if (newHealth instanceof int h && h <= 0) {
                System.out.println(players[i] + "死亡");
            } else {
                System.out.println(players[i] + "剩余血量" + newHealth);
            }
        }

        // 新的switch表达式
        var role = "法师";
        var attackType = switch (role) {
            case "战士" -> "物理攻击";
            case "法师" -> "魔法攻击";
            case "射手" -> "远程攻击";
            default -> throw new IllegalStateException("Unexpected value: " + role);
        };
        System.out.println(role + "攻击类型是" + attackType);
        //老的swith表达
        switch (role) {
            case "1":
                System.out.println(111);
                break;
            case "2":
                System.out.println(333);
                break;
            default:
                System.out.println(444);
        }
    }
}

public class Demo01 {
    public static void main(String[] args) {
        // 1.基础类型
        int age = 18;
        long userId = 123456789987654321L;
        long orderId = 1_234_567_89876_54321L; // 7+以后支持下划线
        double salary = 25.5_000;

        // 2.jdk10特性 var
        var userName = "张三"; //编辑器会自动推断为String类型
        var userScores = new int[]{90, 85, 80}; //自动推断未int数组
        var inVip = true;

        // 3.字符串增强 jdk11+
        var emptyStr = "";
        System.out.println("字符串是否为空" + emptyStr.isBlank());
        var newLine = "java\n基础测试";
        //jdk11新增lines(),拆分多行字符串为Stream
        newLine.lines().forEach(System.out::println);
    }
}
