package resources;


import java.time.LocalDateTime;

public class Submittion {
    static int id = 0;
    int x;
    float y;
    int r;
    String localtime;
    String time;
    String result;
    public Submittion(long start, Point point){
        id++;
        this.x = point.getX();
        this.y = point.getY();
        this.r = point.getR();
        this.localtime = LocalDateTime.now().toString();
        this.result = point.check();
        this.time = String.valueOf((System.nanoTime() - start) / 1_000_000);
    }

    public Submittion() {
    }

    public static void setId(int id) {
        Submittion.id = id;
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

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
