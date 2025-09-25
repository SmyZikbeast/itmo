public class Laba1 {
    static final int UPPER_BRACKET1 = 21;
    static final int LOWER_BRACKET1 = 5;
    static  final  int UPPER_BRACKET2=14;
    static  final  int LOWER_BRACKET2=-3;
    public static void main(String[] args) {
        int[] w = new int[((UPPER_BRACKET1 - LOWER_BRACKET1) / 2) + 1];
        float[] x = new float[20];
        float[][] k = new float[9][20];
        int pointer = 0;
        for (int l = UPPER_BRACKET1; l >= 5; l -= 2) {
            w[pointer] = l;
            pointer += 1;
        }
        for(int l = 0; l<x.length;l++) {
            x[l] = (float) (Math.random() * (UPPER_BRACKET2-LOWER_BRACKET2) + LOWER_BRACKET2);
        }
        for(int i =0;i<9;i++){
            for(int j=0;j<20;j++){
                k[i][j]=calc(w[i],x[j]);
            }
        }
        print(k);

    }
    public static float calc(int w,float x){
        if (w == 11){
            return (float) Math.asin(Math.cos(Math.pow((2*Math.cos(x)),Math.cbrt(x))));
        } else if ((w ==9) | (w==13) | (w==17) | (w==21)) {
            return (float) Math.pow((Math.atan((Math.pow(((x+5.5)/17),2)))),(Math.pow((Math.cos(x)),Math.pow(2*x,2)+Math.PI)-1)/2);
        }
        else {
            return (float) Math.tan(Math.tan((Math.pow(Math.log(Math.abs(x))/2,4*x))));
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
