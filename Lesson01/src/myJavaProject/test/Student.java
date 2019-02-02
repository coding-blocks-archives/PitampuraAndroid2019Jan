package myJavaProject.test;

// final
class Student{
    protected String name = "", surname = "", branch = "";
    protected Integer rollNumber = 0;
    protected String staticVar = "test";

    public static String getStaticVar(){
        returns staticVar;
    }

    //Also called the newInstance pattern
    public static Student getStudent(String studentName, 
    String studentSurName, 
    String studentBranch, 
    Integer studentRollNumber){
        Student s =  new Student(studentName,
        studentSurName,
        studentBranch,
        studentRollNumber);

        return s;
    }

    private Student(String studentName, 
    String studentSurName, 
    String studentBranch, 
    Integer studentRollNumber){
        name =studentName;
        surname = studentSurName;
        branch = studentBranch;
        rollNumber = studentRollNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}


// ___-____-____-___-___