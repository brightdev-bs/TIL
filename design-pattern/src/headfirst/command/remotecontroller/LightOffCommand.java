package headfirst.command.remotecontroller;

import headfirst.command.Command;
import headfirst.command.Light;

public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
