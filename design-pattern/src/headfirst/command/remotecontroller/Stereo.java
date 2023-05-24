package headfirst.command.remotecontroller;

public class Stereo {
    public void on() {
        System.out.println("오디오가 켜졋습니다.");
    }

    public void setCD() {
        System.out.println("CD가 선택되었습니다.");
    }

    public void setVolume(int sound) {
        System.out.println("볼륨은 = " + sound + " 입니다");
    }
}
