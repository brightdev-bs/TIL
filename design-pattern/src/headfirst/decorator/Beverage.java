package headfirst.decorator;

public abstract class Beverage {
    public enum Size {TALL, GRANDE, VENTI,}

    Size size = Size.TALL;

    public String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
