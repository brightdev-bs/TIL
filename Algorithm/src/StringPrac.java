public class StringPrac {

    public static void main(String[] args) {
        String s = "ORG 0 //It is just a practice";
        System.out.println(s.indexOf("//"));

        String answer = s.substring(0,6);
        String comment = s.substring(6);
        System.out.println(answer);
        System.out.println(comment);
    }
}
