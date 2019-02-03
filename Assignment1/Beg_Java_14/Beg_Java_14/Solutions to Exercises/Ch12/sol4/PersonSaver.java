// Chapter 12 Exercise 4

/*
  Here we add the ability to query the file by entering a name from the eyboard.
  First the index  is searched to find positions in the persons file corresponding
  to all occurrences of the name. The array of positions are sorted in ascendfing
  sequence to enable the records to be retrieved in a single pass through the
  persons file.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PersonSaver {
  private String directory = "C:/Beg Java Stuff";
  private String filename = "IndexedPersons.bin";             // Stores Person objects
  private String indexFilename = "IndexFile.bin";             // Stores index entries to the IndexedPersons.bin file
  
  private IndexEntry[] entries = new IndexEntry[0];           // Current entries in index file


  // Buffered keyboard input stream
  private BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

  // File paths
  private File file = null;                                   // Person file
  private File indexFile = null;                              // Index to person file
  
  private ObjectOutputStream objectsOut = null;

  public PersonSaver(){
    File dir = new File(directory);                            // Directory File object
    if(!dir.isDirectory())                                     // If there's no directory
      dir.mkdir();                                             // create one

    file = new File(dir, filename);                            // Person file
    indexFile = new File(dir, indexFilename);                  // Index file

    try {
      if(indexFile.exists() && indexFile.length()>0){
         ObjectInputStream indexesIn = new ObjectInputStream(new FileInputStream(indexFile));
         entries = (IndexEntry[])(indexesIn.readObject());
      }
    } catch(IOException e) {      // For FileNotFoundException + IOException
      e.printStackTrace();
      System.exit(1);
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
  
  public static void main(String[] args) {
    PersonSaver saver = new PersonSaver();          // Create a saver object
    saver.operate();                                // and execute it
  }

  // Runs the Person saver
  private void operate(){
    // Get operation selection from the keyboard
    while(true) {  
      switch(selectOperation()) {

        case 'N': case 'n':  // Read and add a new person
          addPerson();
          break;

        case 'D': case 'd':  // Display the contents of the file
          displayPersons();
          break;

        case 'Q': case 'q':  // Quit the program, but first close all streams
          try {
            objectsOut.close();
          }catch(IOException e){
            e.printStackTrace();
          }
          System.exit(0);
          break;

        case 'F': case 'f':  // Find entries for a given second name
          findPersons();
          break;

        default:
          System.out.println("Invalid Input. Try again.");
          break;
      }
    }
  }

   // Method to find records for a given second name
   private void findPersons() {
     String name = null;
     try {
       System.out.println("Enter second name to be found:");
       name = kb.readLine().trim();
     } catch(IOException e) {
       System.err.println("Error reading from keyboard\n");
       e.printStackTrace();
       System.exit(1); 
     }   

     int[] positions = new int[entries.length];  // Stores record positions for matching names
     int foundCount = 0;                         // Number of matching index entries
     for(int i = 0 ; i<entries.length ; i++) {
      if(name.equals(entries[i].getName()))
        positions[foundCount++] = entries[i].getPosition();
    }
    if(foundCount == 0) {
      System.out.println(name + " not found.");
      return;
    }

    // Sort positions array into ascending sequence
    int temp = 0;
    for(int i = 0 ; i<foundCount-1; i++) {
      for(int j = i+1 ; j<foundCount ; j++) {
        if(positions[i]>positions[j]) {
          temp = positions[i];
          positions[i] = positions[j];
          positions[j] = temp;
        }
      }
    }

    // Output records from Person file corresponding to positions array elements
    try {
      ObjectInputStream personsIn = new ObjectInputStream(
                                         new FileInputStream(file));
      Person person = null;
      int current = 0;
      loop:
      for(int i = 0 ; i<entries.length; i++){
        person = (Person)(personsIn.readObject());
        if(i == positions[current]) {
          System.out.println("\n"+person.toString());
          if(++current >= foundCount)
            break loop;
        }
      }
    } catch(IOException e) {
       e.printStackTrace();
       System.exit(1); 
    }catch(ClassNotFoundException e) {
       e.printStackTrace();
       System.exit(1); 
    }
    return;
  }
    
  // Method to read a character entered on the keyboard
  private char selectOperation() {
    System.out.println("\nEnter a letter to select an operation:"
                      +"\n Q or q to quit the program."
                      +"\n N or n to enter a new name and address."
                      +"\n D or d to display the contents of the file."
                      +"\n F or f to find records for a given second name.");
                            
    String s = null;
    try {
      s = kb.readLine();
    } catch (IOException e) {
        e.printStackTrace(System.err);
        System.exit(1);
    }
    
    return s.trim().charAt(0);  // Return the first non-blank letter
  }

  // Method to add a new Person object to the file  
  public void addPerson() {
    Person person = null;
    String secondname = null;
    try {
      System.out.println("Enter first name:");
      String firstname = kb.readLine().trim();
      System.out.println("Enter second name:");
      secondname = kb.readLine().trim();
      Name name = new Name(firstname, secondname);

      StringBuffer sb = new StringBuffer();  // To store address
      
      // We will add each address line to sb terminated by '\n'
      System.out.println("Enter address one line at a time. Enter ! to end:");
      String s = null; 
      while((s = kb.readLine().trim()).charAt(0) != '!')
       sb.append(s).append('\n');
      person = new Person(new Name(firstname, secondname), new Address(sb.toString()));
    } catch(IOException e) {
      System.err.println("Error reading from keyboard\n");
      e.printStackTrace();
      System.exit(1); 
    }   

    // Write the new Person object to the file
    try {
      if(objectsOut == null) {
      
        boolean personFileCheck = file.exists() && file.length()>0;
        FileOutputStream ostream = new FileOutputStream(file, true);
        if(personFileCheck) {
          // The file exists so use the class type that inhibits writing the header
          objectsOut = new ReuseObjectOutputStream(ostream);
        } else {
          // Since the file does not exist, creating the output stream 
          // this will create a file to which a header will be written.
          objectsOut = new ObjectOutputStream(ostream);  // To write Person objects
        }
      }
      objectsOut.writeObject(person);
      objectsOut.flush();
      // Create the new index entry and insert in ascending sequence
      IndexEntry newEntry = new IndexEntry(secondname, entries.length);
      IndexEntry[] temp = new IndexEntry[entries.length+1];
      int i = 0;             // Element index for entries array
      int j = 0;             // Element index for temp array

      // Copy elements of entries that are less than newEntry to temp
      while(i<entries.length && newEntry.compareTo(entries[i])>0) {
        temp[j++] = entries[i++];
      }
      temp[j++] = newEntry;              // Add newEntry to temp

      // Copy any remaining entries elements to temp
      while(i<entries.length) {
        temp[j++] = entries[i++];
      } 
      entries = temp;                    // Make temp the entries array
      FileOutputStream indexOutStream = new FileOutputStream(indexFile);
      ObjectOutputStream indexesOut = new ObjectOutputStream(indexOutStream);
      indexesOut.writeObject(entries);    // An array is an object!
      indexesOut.close();
      
    } catch(IOException e){
      e.printStackTrace();
      System.exit(1); 
    }   
  }
  
  // Method to output persons in the file  
  public void displayPersons() {
    if(!file.exists()){
      System.out.println("File does not exist because no records have been entered.");
      return;
    }
    Person person = null;
    try {
      FileInputStream istream = new FileInputStream(file);
      ObjectInputStream objectsIn = new ObjectInputStream(istream);
      while(istream.available()>0) {    // While there are bytes in the underlying stream
        System.out.println((Person)(objectsIn.readObject()));  // Read and display an object
      }
      objectsIn.close();                // Close the stream
    } catch(IOException e){
      e.printStackTrace();
      System.exit(1); 
    } catch(ClassNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    } 
  }
}