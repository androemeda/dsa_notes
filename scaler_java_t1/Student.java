class StudentClass{

    private String name , email , phoneNo , mentorEmail ; //keep object of mentor class here.
    private int pincode , scholarshipPercent ;
    private double cgr ;

    //constructor.
    public StudentClass(String name , String email , String phoneNo , int pincode){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.pincode = pincode;
    }

    int getScholarship(){
        return this.scholarshipPercent;
    }

    void setScholarship(int s){
        if(s<=50 && s>=0){
            this.scholarshipPercent = s ;
        }else{
            System.out.println("scholarship value is invalid.");
        }
        
    }

    public void printProfile(){
        System.out.println("name: "+name);
        System.out.println("email "+email);
        System.out.println("phone number: "+phoneNo);
        System.out.println("mentor email: "+mentorEmail);
        System.out.println("pin code: "+pincode);
        System.out.println("scholarship percentage: "+scholarshipPercent);
        System.out.println("CGR: "+cgr);
    }

    public boolean belongToSameLocality(StudentClass s){
        return this.pincode==s.pincode ;
    }

    public float calculateFee(){
        int fee = 500000;
        return ((100-this.scholarshipPercent)*(fee));
    }
}

public class Student{
    public static void main(String[] args){

        StudentClass s1 = new StudentClass("kartik" , "kartik@sst.com" , "+91-7769011588" , 440012);

        s1.printProfile();

        s1.scholarshipPercent = 25;

        System.out.println(s1.calculateFee());
    }
}

/*
MENTOR CLASS

ATTRIBUTES
name
email
phone no.
company
home town pin
years of experience
role

FUNCTIONS
print profile
fromSameLocality

set of attributes and functions is same to mentor and student ---> to avoid duplicacy we will use inheritence.


---HW---READ ABOUT INHERITENCE----
*/