package myJavaProject.test;

class Monitor extends Student{

    String creationDate;

    public Monitor(String name, 
    String surname, 
    String branch, 
    String rollNo, 
    String creationDate){
        super.setName(name);
        super.setSurname(surname);
        super.setBranch(branch);
        super.setRollNumber(rollNo);
        this.creationDate = creationDate;
    }

    @Override
    public String getName(){
        String returnedValue = super.getName() + " is a monitor"
        return returnedValue;
    }

}