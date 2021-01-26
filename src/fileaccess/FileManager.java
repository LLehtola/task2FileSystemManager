package fileaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileManager {

public String[] getFileNames(String filePath){
    File dir = new File(filePath);
    return dir.list();
}

public String[] getFileExtensions(String filePath){
    HashMap<String,String> fileExtensionsMap = new HashMap<String,String>();
    File dir = new File(filePath);
    File[] files = dir.listFiles();
    for (File file : files) {
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        if(index > 0) {
          String extension = fileName.substring(index + 1);
          fileExtensionsMap.put(extension,"");
        }
    }
    return fileExtensionsMap.keySet().toArray(
        new String[fileExtensionsMap.size()]);
}

public String[] getFilesByFileExtension(String filePath, String fileExtension){
    File dir = new File(filePath);
    File[] fileArray = dir.listFiles((file, name) -> name.toLowerCase().endsWith("."+fileExtension));
    String[] fileNames = new String[fileArray.length];
    int i=0;
    for (File file : fileArray){
        fileNames[i]=file.toString();
        i++;
    }
return fileNames;
}

public long getFileSize(String fileName){
    File file = new File(fileName);
    return file.length();
}

public void printFileSize(String fileName){
    File file = new File(fileName);
    long fileSize = file.length();
    System.out.format("File size: %d bytes", fileSize);
    System.out.println();
}

public String readFileToString(String fileName){
    String contents="";
    int linesCount=0;
    try {
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNextLine()) {
          contents += fileScanner.nextLine();
          linesCount++;
        }
        fileScanner.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      System.out.println("Number of lines: "+linesCount);
      return contents;
}

public int countMatches(String text, String str) {
    if (isEmpty(text) || isEmpty(str)) {
        return 0;
    }
    int index = 0, count = 0;
    while (true) {
        index = text.indexOf(str, index);
        if (index != -1) {
            count ++;
            index += str.length();
        } else {
            break;
        }
    }
    return count;
}

public boolean isEmpty(String s) {
    return s == null || s.length() == 0;
}

}
