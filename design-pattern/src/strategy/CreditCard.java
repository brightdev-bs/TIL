package strategy;

public class CreditCard implements PayStrategy {

    private String cardNumber;
    private int cvc;
    private String company;

    public CreditCard(String cardNumber, int cvc, String company) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.company = company;
    }

    @Override
    public void pay(int amount) {
        System.out.println(this.company + "카드로 " + amount + " 결제하였습니다.");

    }
}
