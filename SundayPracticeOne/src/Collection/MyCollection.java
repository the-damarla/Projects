package Collection;

import EmployeeClass.Employye;

public class MyCollection {
    Employye[] empArray = new Employye[400];
    public static int readCounter = 0;
    public static int writeCounter = 0;
    public MyCollection(){}

    private static MyCollection myCollection = null;


    synchronized public static MyCollection createEmployee(){

        if (myCollection == null) {
            myCollection = new MyCollection();
        }

        return myCollection;
    }


    synchronized public void addEmployee(String fName, String lName, String DOB, double exp)
    {
        empArray[readCounter] = new Employye();
        empArray[readCounter].setFirstName(fName);
        empArray[readCounter].setLastName(lName);
        empArray[readCounter].setDateOfBirth(DOB);
        empArray[readCounter].setExperience(exp);
        readCounter++;
    }

    synchronized public Employye getEmployee()
    {
        Employye employye = new Employye();
        employye.setFirstName(empArray[writeCounter].getFirstName());
        employye.setLastName(empArray[writeCounter].getLastName());
        employye.setDateOfBirth(empArray[writeCounter].getDateOfBirth());
        employye.setExperience(empArray[writeCounter].getExperience());
        writeCounter++;
        return employye;
    }
}
