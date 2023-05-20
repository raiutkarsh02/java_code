import java.util.*;
class circle {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("The value of pi: 3.14");
        int r=in.nextInt();
        double result1=2*3.14*r;
        double result2=3.14*r*r;
        System.out.println("Perimetr: "+result1);
        System.out.println("Area:  "+result2);
    }
}
