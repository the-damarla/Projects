package FileController;

import Collection.MyCollection;
import EmployeeClass.Employye;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TsvFileHandler implements FileHandler {

    MyCollection myCollection = MyCollection.createEmployee() ;


    @Override
    public void readFunction() {
        String Filename = "/Users/vijaysainag/Downloads/SundayPracticeOne/src/Files/FilesToBeRead/employee.tsv";
        try {
            BufferedReader buf = new BufferedReader(new FileReader(Filename));


            ArrayList<String> words = new ArrayList<>();
            String lineJustFetched = null;
            String[] wordsArray;

            while (true) {
                lineJustFetched = buf.readLine();
                if (lineJustFetched == null) {
                    break;
                } else {
                    wordsArray = lineJustFetched.split("\t");
                    myCollection.addEmployee(wordsArray[0], wordsArray[1], String.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse(wordsArray[2])), Double.parseDouble(wordsArray[3]));

                }
            }

            buf.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void WriteFunction() {
        try {
            FileWriter fos = new FileWriter("/Users/vijaysainag/Downloads/SundayPracticeOne/src/Files/FilesThatAreWrittenByProgram/newEmployee.tsv");
            PrintWriter dos = new PrintWriter(fos);
            myCollection = MyCollection.createEmployee();
            String tempDOB=null;
            DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
            for (int i=1;i<=100;i++)
            {
                Employye em=myCollection.getEmployee();
                dos.print(em.getFirstName()+"\t");
                dos.print(em.getLastName()+"\t");
                tempDOB=em.getDateOfBirth();
                String DOB="31/03/2000";
                dos.print(DOB+"\t");
                dos.println();
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error Printing Tab Delimited File");
        }
    }
}
