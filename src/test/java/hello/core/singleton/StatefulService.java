package hello.core.singleton;

public class StatefulService {

    private int price;

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 이런게 문제..! 값이 바뀌어버림
        return price;
    }

    public  int getPrice() {
        return price;
    }
}
