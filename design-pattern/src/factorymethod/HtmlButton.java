package factorymethod;

public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("HTML Button입니다.");
    }

    @Override
    public void onClick() {
        System.out.println("HTML Button이 클릭되었습니다.");
    }
}
