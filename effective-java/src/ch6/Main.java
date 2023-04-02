package ch6;

public class Main {

    public static void makeAppleSauce(Apple apple) {
        if(apple == Apple.FUJI) {
            System.out.println("APPLE FUJI");
        } else if(apple == Apple.PIPPIN) {
            System.out.println("APPLE PIPPIN");
        } else if(apple == Apple.GRANNY_SMITH) {
            System.out.println("AP9PLE_GRANNY_SMITH");
        }
    }

    public static void main(String[] args) {
//        makeAppleSauce(Apple.PIPPIN);

        for (Apple apple : Apple.values()) {
            System.out.println(apple.toString());
            System.out.println(apple.name() + " : " + apple.getPrice());
        }
    }
}
