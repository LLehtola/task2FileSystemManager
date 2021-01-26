
import java.util.Scanner;

import fileaccess.FileManager;
import fileaccess.LogHandler;
import io.IOHandler;

public class Main {
    public static void main(String[] args) throws Exception {
       
        String filePath = "resources";
        String txtFilePath = "resources/Dracula.txt";
        String txtContents = "";
        Scanner inputScanner = new Scanner(System.in);
        IOHandler ioHandler = new IOHandler();
        FileManager fileManager = new FileManager();
        String userExtensionChoice;
        String userWordSearchChoice;

        LogHandler.setLogFilename("/LogFile.txt");

        int userChoice = ioHandler.getUserChoice(inputScanner);

        while(userChoice!=999){

            if(userChoice==1){
                ioHandler.printOutput("File names in the directory:");
                LogHandler.write("Obtained a list of file names in directory");
                ioHandler.printArray(fileManager.getFileNames(filePath));
            }else if(userChoice==2){
                ioHandler.printOutput("File extensions in the directory:");
                LogHandler.write("Obtained a list of file extensions in directory");
                ioHandler.printArray(fileManager.getFileExtensions(filePath));
                userExtensionChoice = ioHandler.getUserExtensionChoice(inputScanner);
                LogHandler.write("User chose view files by extension: "+userExtensionChoice);
                ioHandler.printArray(fileManager.getFilesByFileExtension(filePath, 
                userExtensionChoice));
            }else if(userChoice==3){
                ioHandler.printOutput("File name: "+txtFilePath);
                LogHandler.write("User chose to manipulate file: "+txtFilePath);
                fileManager.printFileSize(txtFilePath);
                LogHandler.write("File size of "+txtFilePath+" is "+fileManager.getFileSize(txtFilePath));
                txtContents = fileManager.readFileToString(txtFilePath);
                txtContents = txtContents.toLowerCase();
                userWordSearchChoice = (ioHandler.getUserExtensionChoice(inputScanner)).toLowerCase();
                ioHandler.printOutput("Search word <<"+userWordSearchChoice+">> appears "+
                fileManager.countMatches(txtContents, userWordSearchChoice)+" times.");
                LogHandler.write("Searching word "+userWordSearchChoice+" completed. Word found "+
                fileManager.countMatches(txtContents, userWordSearchChoice)+" times.");
            }else{
                ioHandler.printOutput("Error: Invalid choice. Please type a valid number.");
                LogHandler.write("Error: Invalid user choice.");
            }

            userChoice = ioHandler.getUserChoice(inputScanner);
        }

        System.out.println("You have exited the file manager.");
        LogHandler.write("User exited the file manager.");
        inputScanner.close();
    }
}
