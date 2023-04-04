package ch6;

import java.io.IOException;
import java.io.Serializable;

public class MyOutputStream {

    public final void writeObject(Serializable obj, boolean b) throws IOException {
        writeObject(obj, false);
    }

}
