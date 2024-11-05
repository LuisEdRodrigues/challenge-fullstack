package com.luis.backend;

import org.springframework.stereotype.Service;

@Service
public class RobotService {

    private final Robot robot;

    public RobotService() {
        this.robot = new Robot();
    }

    public String moveRobot(String moves) {
        resetState();

        if (moves == null || moves.isEmpty()) {
            return null;
        }

        moves = moves.toUpperCase();

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    turnRight();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'M':
                    moveForward();
                    break;
                default:
                    return null;
            }
            if (robot.getX() > 2 || robot.getX() < -2) return null;
            if (robot.getY() > 2 || robot.getY() < -2) return null;
        }
        return robot.getCoordinates();
    }

    public Robot getRobot() {
        return robot;
    }

    public void moveForward() {
        switch (robot.getDirection()) {
            case 'N':
                robot.setY(robot.getY() + 1);
                break;
            case 'S':
                robot.setY(robot.getY() - 1);
                break;
            case 'E':
                robot.setX(robot.getX() + 1);
                break;
            case 'W':
                robot.setX(robot.getX() - 1);
                break;

        }
    }

    public void turnLeft() {
        switch (robot.getDirection()) {
            case 'N':
                robot.setDirection('W');
                break;
            case 'W':
                robot.setDirection('S');
                break;
            case 'S':
                robot.setDirection('E');
                break;
            case 'E':
                robot.setDirection('N');
                break;
        }
    }

    public void turnRight() {
        switch (robot.getDirection()) {
            case 'N':
                robot.setDirection('E');
                break;
            case 'E':
                robot.setDirection('S');
                break;
            case 'S':
                robot.setDirection('W');
                break;
            case 'W':
                robot.setDirection('N');
                break;
        }
    }

    public void resetState(){
        robot.setDirection('N');
        robot.setX(0);
        robot.setY(0);
    }

}
