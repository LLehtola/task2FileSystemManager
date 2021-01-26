package io;

import java.util.Scanner;

public class IOHandler {
    
    public int getUserChoice(Scanner inputScanner){
        System.out.println("----------------------------------------\r\n"+
            "Please choose from the following options:\r\n"+
            "1 - List all file names in resources directory \r\n"+
            "2 - Search file by file extension \r\n"+
            "3 - Manipulate Dracula.txt \r\n"+
            "999 - Exit program");
        return Integer.parseInt(inputScanner.nextLine());
    }

    public String getUserExtensionChoice(Scanner inputScanner){
        System.out.println("Please type the extension to search for:");
        return inputScanner.nextLine();
    }

    public String getUserWordSearchChoice(Scanner inputScanner){
        System.out.println("Please type the word to search for:");
        return inputScanner.nextLine();
    }

    public void printOutput(String output){
        System.out.println(output);
    }

    public void printArray(String[] outputArray){
        for (String item : outputArray) {
            System.out.println(item);
        }
    }

}
