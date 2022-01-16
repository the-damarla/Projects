import Collection.MyCollection;
import FileController.CsvFileHandler;
import FileController.FileHandler;
import FileController.TsvFileHandler;
import FileController.XmlFileHandler;
import ThreadClass.ReadThread;
import ThreadClass.WriteThread;

public class MainClass {
    public static void main(String[] args) throws InterruptedException, NullPointerException {

        MyCollection myCollection = MyCollection.createEmployee();

        FileHandler xmlFileHandler = new XmlFileHandler();
        ReadThread xmlThread = new ReadThread(xmlFileHandler);
        xmlThread.start();

        FileHandler csvFileHandler = new CsvFileHandler();
        ReadThread csvThread = new ReadThread(csvFileHandler);
        csvThread.start();

        FileHandler tsvFileHandler = new TsvFileHandler();
        ReadThread tsvThread = new ReadThread(tsvFileHandler);
        tsvThread.start();


        xmlThread.join();
        csvThread.join();
        tsvThread.join();

        WriteThread xmlWriteThread = new WriteThread(xmlFileHandler);
        xmlWriteThread.start();

        WriteThread TsvWriteThread = new WriteThread(tsvFileHandler);
        TsvWriteThread.start();

        WriteThread csvWriteThread =  new WriteThread(csvFileHandler);
        csvWriteThread.start();

        TsvWriteThread.join();
        xmlWriteThread.join();
        csvWriteThread.join();

        System.out.println("Write Counter ---> " + myCollection.writeCounter);


    }
}
