package headfirst.command;

public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Tv tv = new Tv(); // 리시버

        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        TvOnCommand tvOnCommand = new TvOnCommand(tv); // 커맨드 객체

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
        remote.setCommand(tvOnCommand);
        remote.buttonWasPressed();
    }
}
