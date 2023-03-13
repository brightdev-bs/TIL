package factorymethod;

public abstract class Dialog {

    public void renderWindow() {
        // ... other code ...
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}
