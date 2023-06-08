package org.example;

import lombok.Setter;


public class Ford extends Automobile implements FrontWheelDrive {

    public Ford(String[] line) {
        super(line);
    }

    public Ford() {
        super();
    }
}

