import java.util.Scanner;

class Discount {
    public static void main(String[] args) {
        double og;
        double disST;
        double disSR;
        System.out.println("input ypur age");

        Scanner sc = new Scanner(System.in);
        int userAge = sc.nextInt();
        System.out.println("Age is: " + userAge);

        System.out.println("Are you student? Answer True or False");
        boolean Student = sc.nextBoolean();
        if (Student && userAge < 30){
            System.out.println("disST");

        }
        else if (userAge > 60 ){
            System.out.println("disSR");
        }
        else {
            System.out.println("og");
        }
    }
}