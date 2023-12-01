class User{

    String name , email , phNo;
    int homeTownPin; 

    public User(String name , String email , String phNo , int pin){
        this.name = name;
        this.email = email;
        this.phNo = phNo;
        this.homeTownPin = pin;
    }

    public void printProfile(){
        System.out.println("called from User class.");
        System.out.println("name: "+this.name);
        System.out.println("email "+this.email);
        System.out.println("phone number: "+this.phNo);
    }

    boolean fromSameLocality(User u){
        return u.homeTownPin==this.homeTownPin;
    }

    String getName(){
        return this.name;
    }

    String getEmail(){
        return this.email;
    }

    String getPhNo(){
        return this.phNo;
    }
}

class Student extends User{
    private String mentorEmail;
    private double CGR;
    private int scholarship;

    public Student(String name , String email , String phNo , int pin){
        super(name , email , phNo , pin);
    }

    public void printProfile(){
        System.out.println("called from Student class.");
        System.out.println("name: "+this.name);
        System.out.println("email "+this.email);
        System.out.println("phone number: "+this.phNo);
    }

    int calculateFee(){
        int fee = 500000;
        int feeDeduction = this.scholarship*fee/100;
        return fee-feeDeduction;
    }

    void setMentorEmail(String email){
        this.mentorEmail = email;
    }

    void setCGR(double cgr){
        this.CGR = cgr;
    }

    void setScholarship(int sch){
        this.scholarship = sch;
    }

    String getMentorEmail(){
        return this.mentorEmail;
    }

    double getCGR(){
        return this.CGR;
    }

    int getScholarship(){
        return this.scholarship;
    }
    
}

class Mentor extends User{
    private String company;
    private String jobProfile;
    private int yearsOfExp;

    public Mentor(String name , String email , String phNo , int pin){
        super(name , email , phNo , pin);

    }
}



public class Inheritance{


    public static void main(String[] args){

        Student s1 = new Student("kartik","kartik@gmail.com","7769011588" , 440012);
        Student s2 = new Student("nishan","nish@gm.com","9723452",445567);
        s1.printProfile();
        System.out.println(s1.fromSameLocality(s2));//Student is a user , mentor is a user. hence we can pass an object of student where user object is expected.
        Mentor m1 = new Mentor("mentor","mentor@gamil.com","9665098901",440012);
        System.out.println(s1.fromSameLocality(m1));//can compare objects of student and mentor also.

    }
}