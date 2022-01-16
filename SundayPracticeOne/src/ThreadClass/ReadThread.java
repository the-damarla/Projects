package ThreadClass;

import FileController.FileHandler;

public class ReadThread extends Thread {
    FileHandler fileHandler;
    public ReadThread(FileHandler fileHandler)
    {
        this.fileHandler = fileHandler;
    }

    @Override
    public void run() {
        fileHandler.readFunction();
    }
}
