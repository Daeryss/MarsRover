import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RoverMovementLogic {
    private Scanner scanner;
    private ArrayList<String> results = new ArrayList<>(); // rovers in finish positions here
    private Map<RoverUnit, String> roversRoutsMap = new LinkedHashMap<>(); // rovers in start positions plus rout
    private int pl_x;
    private int pl_y;

    public void reading() {
        scanner = new Scanner(System.in);

        try {
            pl_x = scanner.nextInt();
            pl_y = scanner.nextInt();
            if (pl_x <= 0 || pl_y <= 0) {
                System.out.println("\u001B[31m" + "The dimensions of the plateau must be greater than 0");
                return;

            }
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31m" + "Warning! Incorrect data input in field size. Please restart application and enter correct data");
            e.printStackTrace();
        }

        String empty = scanner.nextLine().trim(); //required to move to the next line
        if (!empty.equals("")) {
            System.out.println("\u001B[31m" + "Please enter the data for the starting location of the rover from a new line");
        }

        while (scanner.hasNext()) {
            String roverPosition = scanner.nextLine().trim();
            String route = scanner.nextLine().trim();
            roversRoutsMap.put(parcingRoverData(roverPosition), route);
        }
    }


    private RoverUnit parcingRoverData(String roverStartPoint) {
        RoverUnit unit;
        int unit_x = Integer.parseInt(roverStartPoint.split(" ")[0]);
        int unit_y = Integer.parseInt(roverStartPoint.split(" ")[1]);

        if (unit_x < 0 || unit_y < 0 || unit_y > pl_y || unit_x > pl_x) {
            System.out.printf("The rover's starting point should be located within the plateau %d x %d", pl_x, pl_y);
            return null;
        }

        switch (roverStartPoint.split(" ")[2]) {
            case "N":
                unit = new RoverUnit(unit_x, unit_y, DirectionEnum.N);
                break;
            case "S":
                unit = new RoverUnit(unit_x, unit_y, DirectionEnum.S);
                break;
            case "E":
                unit = new RoverUnit(unit_x, unit_y, DirectionEnum.E);
                break;
            case "W":
                unit = new RoverUnit(unit_x, unit_y, DirectionEnum.W);
                break;
            default:
                unit = null;
                System.out.println("\u001B[31m" + "Incorrect input in line " + roverStartPoint);
                return null;
        }

        return unit;
    }

    public void moving() {
        for (RoverUnit unit : roversRoutsMap.keySet()) {
            if (unit != null) {
                String[]route = roversRoutsMap.get(unit).split("");
                for (String action : route) {
                    if (action.trim().equals("")) {
                        results.add(unit.toString());
                        break;
                    }
                    switch (action.toUpperCase()) {
                        case "L":
                            switch (unit.getDirection()) {
                                case E:
                                    unit.setDirection(DirectionEnum.N);
                                    break;
                                case S:
                                    unit.setDirection(DirectionEnum.E);
                                    break;
                                case W:
                                    unit.setDirection(DirectionEnum.S);
                                    break;
                                case N:
                                    unit.setDirection(DirectionEnum.W);
                                    break;
                            }
                            break;
                        case "R":
                            switch (unit.getDirection()) {
                                case E:
                                    unit.setDirection(DirectionEnum.S);
                                    break;
                                case S:
                                    unit.setDirection(DirectionEnum.W);
                                    break;
                                case W:
                                    unit.setDirection(DirectionEnum.N);
                                    break;
                                case N:
                                    unit.setDirection(DirectionEnum.E);
                                    break;
                            }
                            break;
                        case "M":
                            switch (unit.getDirection()) {
                                case E:
                                    unit.setX(unit.getX() + 1);
                                    break;
                                case S:
                                    unit.setY(unit.getY() - 1);
                                    break;
                                case W:
                                    unit.setX(unit.getX() - 1);
                                    break;
                                case N:
                                    unit.setY(unit.getY() + 1);
                                    break;
                            }
                            break;
                        default:
                            results.add("incorrect data in the line describing the route");
                            break;
                    }
                }
                if (unit.getX() <= pl_x && unit.getY() <= pl_y) {
                    results.add(unit.toString());
                } else {
                    results.add("The rover has gone beyond the borders of the plateau");
                }
            } else {
                results.add("incorrect entry of rover position data");
            }

        }
    }

    public void showResult(){
        results.forEach(System.out::println);
    }
}
