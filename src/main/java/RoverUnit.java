public class RoverUnit {
    private int x;
    private int y;
    private DirectionEnum direction;

    public RoverUnit() {
    }

    public RoverUnit(int x, int y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        String result = new String();

        return result.concat(Integer.toString(x)
                .concat(" ")
                .concat(Integer.toString(y))
                .concat(" ")
                .concat(direction.name()));
    }
}
