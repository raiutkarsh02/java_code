import java.util.*;
class number {
    public static void main(String [] args){
        Scanner in= new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a= in.nextInt();
        System.out.println("Enter the second number: ");
        int b= in.nextInt();
        int result1=a*b;
        int result2=a+b;
        int result3=a-b;
        int result4=a/b;
        System.out.println("Multiplication:  "+result1);
        System.out.println("Addition:  "+result2);
        System.out.println("Subtract:  "+result3);
        System.out.println("Division:  "+result4);
        }
    }
