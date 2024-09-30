package _05_class._abstract;

public class Kim extends Student {
    public Kim(String name,String school, int age, String stdNum) {
        super(name, school, age, stdNum);
    }

    @Override
    void todo() {
        System.out.println("점심은 김가네 김밥");
    }
}
