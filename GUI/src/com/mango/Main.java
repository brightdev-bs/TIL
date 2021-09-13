package com.mango;

import javax.swing.*;

class MyFrame extends JFrame {
    MyFrame() {
        setTitle("GUI 프로그래밍");
        setSize(300, 300);
        setVisible(true);
    }
}

public class Main {

    public static void main(String[] args) {
	    MyFrame mf = new MyFrame();
    }
}
