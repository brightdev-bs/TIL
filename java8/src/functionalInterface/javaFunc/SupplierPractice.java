package functionalInterface.javaFunc;

import java.util.function.Supplier;

public class SupplierPractice {

    public static void main(String[] args) {

    }

    public static String even() {
        return "짝수입니다.";
    }

    public static void isEven(int i, Supplier<String> answer) {
        if(i % 2 == 0) {
            answer.get();
        } else {
            System.out.println(i + " 인덱스");
        }
    }
}
