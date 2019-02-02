package myJavaProject.test;

class Main{

    final Student finalStudent;

    public static void main(String[] args){
        // Sudent student = new Student("Harshit", "Dwivedi", "ECE", 12);

        // student.name -> "Harshit"

        // String staticVar = Student.getStaticVar();

        finalStudent = = new Student("Harshit", "Dwivedi", "ECE", 12);

        Student staticStudent = Student.getStudent("Harshit", "Dwivedi", "ECE", 12)

        finalStudent.setName("Dwivedi"); Y

        finalStudent = new Student("Dwivedi", "Harshit", "CSE", 13); N

    }

    public void run(){
        
        // Student student = new Student("Dwivedi", "Harshit", "CSE", 13);
        // student = new Student("Dwivedi", "Harshit", "CSE", 13);

        Monitor monitor = new Monitor("Dwivedi", "Harshit", "CSE", 13, "27th Jan 2019")

        // Student monitor = (Student) new Monitor(
        //     "Dwivedi", 
        //     "Harshit", 
        //     "CSE", 
        //     13,
        //     "27th Jan 2019")

        String monitorName = monitor.getName(); //This will work and it prints "Dwivedi"
        //Dwivedi is a monitor

    }   

    //Final objects can't be initialized again
    //Final classes can't be extended
    //Final methods can't be overridden
    //Static methods and variables belong to the class instead of the instance of the class
}