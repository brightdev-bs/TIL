package headfirst.command.remotecontroller;

import headfirst.command.Command;
import headfirst.command.Light;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
