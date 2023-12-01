public class Rectangle{

    double length;
    double breadth;

    public Rectangle(double l , double b){
        this.length = l;
        this.breadth = b;
    }

    public double getArea(){
        return this.length*this.breadth;
    }

    public double getPerimeter(){
        return 2*(this.length+this.breadth);
    }

    public boolean isSquare(){
        if(this.length==this.breadth){
            return true;
        }
        return false;
    }

    public boolean equals(Rectangle r){
        if(this.length==r.length && this.breadth==r.breadth){
            return true;
        }
        return false;
    }


    public static void main(String[] args){

        Rectangle r1 = new Rectangle( 2.1 , 3.2 );
        Rectangle r2 = new Rectangle( 2.1 , 3.0002 );

        System.out.println("area of first: "+r1.getArea());
        System.out.println("perimeter of first: "+r1.getPerimeter());
        System.out.println();
        System.out.println("area of second: "+r2.getArea());
        System.out.println("perimeter of second: "+r2.getPerimeter());
        System.out.println();
        System.out.println("rectangles are equal: "+r1.equals(r2));
    }
}


//----ONLY THE CLASS WHICH HAS MAIN METHOD CAN BE PUBLIC----//