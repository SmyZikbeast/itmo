public class Laba1 {
    static final int UPPER_BRACKET1 = 21;
    static final int LOWER_BRACKET1 = 5;
    static final int UPPER_BRACKET2 = 14;
    static final int LOWER_BRACKET2 = -3;
    public static void main(String[] args) {
        int[] w = new int[((UPPER_BRACKET1 - LOWER_BRACKET1) / 2) + 1];
        float[] x = new float[20];
        float[][] l = new float[9][20];
        int pointer = 0;
        for (int k = UPPER_BRACKET1; k >= 5; k -= 2) {
            w[pointer] = k;
            pointer += 1;
        }
        for(int k = 0; k<x.length;k++) {
            x[k] = (float) (Math.random() * (UPPER_BRACKET2-LOWER_BRACKET2) + LOWER_BRACKET2);
        }
        for(int i =0;i<9;i++){
            for(int j=0;j<20;j++){
                l[i][j]=calc(w[i],x[j]);
            }
        }
        print(l);
    }

    public static float calc(int w,float x) {
        switch (w) {
            case 11:
                return (float) Math.asin(Math.cos(Math.pow((2 * Math.cos(x)), Math.cbrt(x))));
            case 9:
            case 13:
            case 17:
            case 21:
                return (float) Math.pow((Math.atan((Math.pow(((x + 5.5) / 17), 2)))), (Math.pow((Math.cos(x)), Math.pow(2 * x, 2) + Math.PI) - 1) / 2);
            default:
                return (float) Math.tan(Math.tan((Math.pow(Math.log(Math.abs(x)) / 2, 4 * x))));
        }
    }

    public static void print(float [][] m){
        for(int i =0;i<9;i++){
            for(int j=0;j<20;j++){
                String val = String.format("%9.5f",m[i][j]);
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}