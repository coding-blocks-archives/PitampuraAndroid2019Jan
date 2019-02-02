package myJavaProject.test;

class CB extends Object{

    private String address;
    private ArrayList<String> courses;
    private Array<String> mentors;
    private Integer age;
    private ArrayList<String> centers;

    public CB(String addr, ArrayList<String> courses,
    Array<String> mentors,
    Integer age,
    ArrayList<String> centers){
        this.address = address;
        this.courses = courses;
        this.mentors = mentors;
        this.age = age;
        this.centers = centers;
    }

    public getAge(){returns age;}

}


main(){
    ArrayList<String> courses = new ArrayList<String>();
    courses.add("Android");
    ArrayList<String> mentors = new ArrayList<String>();
    courses.add("Harshit");
    ArrayList<String> centers = new ArrayList<String>();
    courses.add("Pitampura");

    //Don't ever change this!!!
    final CB codingBlocks = new CB("47 Nishant Kunj", courses, mentors, 10, centers);
    // codingBlocks.age = 11; Throws an error saying that age is private in class CB

    Integer age = codingBlocks.getAge();

    //We can use singleton pattern to prevent this
    // final CB codingBlocks2 = new new CB("47 Dwarka Kunj", courses, mentors, 12, centers);

    cb.toString(); //Can either return the memory address of codingBlocks or 
               //it can return a pretty printed values of the object codingBlocks 
               //depending on the implementation
}