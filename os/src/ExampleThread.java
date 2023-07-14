public class ExampleThread extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(this.getName());
        }
    }
}
