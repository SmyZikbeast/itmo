import java.io.IOException;

class Main {
     public static void main(String[] args) {
         a.b();
         c.d();
     }
 }
 class a {
    public static void b() throws ArrayIndexOutOfBoundsException{
        int[] nums = {1, 2, 3};
        System.out.println(nums[5]);
    }
}
 class c {
     public static void d() throws IOException {
         int[] nums = {1, 2, 3};
         System.out.println(nums[5]);
     }
 }
