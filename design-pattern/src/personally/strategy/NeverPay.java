package personally.strategy;

public class NeverPay implements PayStrategy {

    private String id;
    private String password;

    public NeverPay(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println("네버페이로 " + amount + " 결제하였습니다.");

    }
}
