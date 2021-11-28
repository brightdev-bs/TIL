package language;

public class ReturnUserInterface {
    public static void receiveData(String s) {
        String result = s;
        System.out.println(Integer.parseInt(result));
    }

    public static void main(String[] args) {
        ReturnData rd = new ReturnData();
        rd.start();
    }
}

