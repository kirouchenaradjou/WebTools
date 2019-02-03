import java.io.File;
import java.io.FilenameFilter;
//import java.util.Date;   // For the Date class

public class TryFile3 {
  public static void main(String[] args) {

    // Create an object that is a directory
    File myDir = new File("C:/j2sdk1.4.0/src/java/io");
    System.out.println(myDir.getAbsolutePath() 
                       + (myDir.isDirectory() ? " is " : " is not ")
                       + "a directory");
    System.out.println("The parent of " + myDir.getName() + " is "
                       + myDir.getParent());

    // Define a filter for java source files beginning with F
    FilenameFilter select = new FileListFilter("F", "java");

    // Get the contents of the directory
    File[] contents = myDir.listFiles(select);

    // List the contents
    if (contents != null) {
      System.out.println("\nThe " + contents.length
                         + " matching items in the directory, "
                         + myDir.getName() + ", are:");
      for (int i = 0; i < contents.length; i++) {
        System.out
          .println(contents[i] + " is a "
                   + (contents[i].isDirectory() ? "directory" : "file")
                   + " last modified " 
                   + new Date(contents[i].lastModified()));
      } 
    } else {
      System.out.println(myDir.getName() + " is not a directory");
    } 

    return;
  }
}
