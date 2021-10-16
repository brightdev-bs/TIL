package GUI.classType;

public class NestedClassEx {
    private String name = "Year";
    private String message = "Summer";
    protected class Inner {
        private String message = "Winter";
        public void show() {
            System.out.println(name + "" + message + "" + NestedClassEx.this.message);
        }
    }
    public void moveInner() {
        Inner inner = new Inner();
        inner.show();
    }
    public static void main(String[] args) {
        new NestedClassEx().moveInner();
    }
}
