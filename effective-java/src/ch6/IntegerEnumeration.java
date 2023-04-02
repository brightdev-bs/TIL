package ch6;

public class IntegerEnumeration {

    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;


    public static void makeSauce(int orange) {
        if(ORANGE_NAVEL == 0) {
            System.out.println("ORANGE_NAVEL입니다.");
        } else if(ORANGE_TEMPLE == 1) {
            System.out.println("ORAGNE_TEMPLE입니다.");
        } else if(ORANGE_BLOOD == 2) {
            System.out.println("ORANGE_BLOOD");
        }
    }

    public static void main(String[] args) {
        makeSauce(APPLE_FUJI);
    }
}
