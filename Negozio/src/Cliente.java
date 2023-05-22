public class Cliente {
    private String name;
    private int age;
    private int pointsCoupon = 0;

    public Cliente(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPointsCoupon() {
        return pointsCoupon;
    }

    public void setPointsCoupon(int pointsCoupon) {
        this.pointsCoupon = pointsCoupon;
    }
}
