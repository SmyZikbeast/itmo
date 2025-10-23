public class Main {
    public static void main(String[] args){
        int number = Integer.parseInt(args[0]);
        String result = "";
        while (number!=0) {
            if (number>0) {
                result = String.valueOf((number % (-10))) + result;
            }
            else{
                result = String.valueOf(10+(number % (-10))) + result;
                number-=(10+(number % (-10)));
            }
            number/=(-10);
        }
        System.out.println(result);
    }
}