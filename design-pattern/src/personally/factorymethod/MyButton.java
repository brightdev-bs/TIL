package personally.factorymethod;

public class MyButton implements Button {

    @Override
    public void render() {
        System.out.println("MyButton 입니다.");
    }

    @Override
    public void onClick() {
        System.out.println("MyButton이 클릭되었습니다.");
    }
}
