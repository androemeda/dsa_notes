import java.util.*;

public class Circle1{

    int radius;

    public Circle1(int radius){
        this.radius = radius;
    }

    public double perimeter(){
        return (2*3.14*this.radius);
    }

    public double area(){
        return (3.14*this.radius*this.radius);
    }

    public boolean equals(Circle1 c2){
        if(this.radius==c2.radius){
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("enter radius of first: ");
        int r1 = sc.nextInt();
        Circle1 c1 = new Circle1(r1);
        System.out.println("perimeter is: "+ c1.perimeter() );
        System.out.println("area is: "+ c1.area()+"\n");

        System.out.print("enter radius of second: ");
        int r2 = sc.nextInt();
        Circle1 c2 = new Circle1(r2);
        System.out.println("perimeter is: "+ c2.perimeter());
        System.out.println("area is: "+ c2.area()+"\n");

        System.out.println("both circles are equal: "+ c1.equals(c2));

        
        
    }
}