package personally.factorymethod;

public class MyDialog extends Dialog {

    @Override
    public Button createButton() {
        return new MyButton();
    }
}
