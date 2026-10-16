package resources;

public class Point {
    int x;
    float y;
    int r;
    public String check(){
        if (x <= 0 && y >= 0 && Math.pow(x,2) + Math.pow(y,2) <= Math.pow(r,2)){
            return "hit";
        }
        if (x <= 0 && y <= 0 && y >= -r && x >= -r/2.0){
            return "hit";
        }
        if (x >= 0 && y <= 0 && y >= x - r) {
            return "hit";
        }
        return "miss";
    }

    public int getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public Point(int x, float y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Point() {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }
}
