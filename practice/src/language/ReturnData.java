package language;

import jdk.nashorn.internal.ir.ReturnNode;

import java.io.IOException;

public class ReturnData extends Thread {
    private String result = null;

    @Override
    public void run() {
        result = "35";
        ReturnUserInterface.receiveData(result);
    }

    //public String getResult() { return result; }
}
