package ThreadClass;

import FileController.FileHandler;

public class WriteThread extends Thread {
    FileHandler fileHandler;

    public WriteThread(FileHandler fileHandler)
    {
        this.fileHandler = fileHandler;
    }

    @Override
    public void run() {
        fileHandler.WriteFunction();
    }
}
