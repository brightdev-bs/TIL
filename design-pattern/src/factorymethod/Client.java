package factorymethod;

public class Client {

    private static Dialog dialog;

    public static void main(String[] args) {
        configure("myButton");
        run();
    }

    static void configure(String button) {
        if(button.equals("myButton")) {
            dialog = new MyDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }
    static void run() {
        dialog.renderWindow();
    }
}
