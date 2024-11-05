package com.luis.backend;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Robot {

    private int x;
    private int y;
    private char direction;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
    }

    public String getCoordinates() {
        return String.format("(%d, %d, %s)", x, y, direction);
    }


}
