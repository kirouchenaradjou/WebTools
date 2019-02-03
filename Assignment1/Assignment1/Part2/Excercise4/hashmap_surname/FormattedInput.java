package hashmap_surname;
import java.io.*;

public class FormattedInput
{
  
  public int intRead() {
    try {
      for(int i = 0; i < 5; i++) {
        if(tokenizer.nextToken() == tokenizer.TT_NUMBER && 
                                           tokenizer.nval == (double)((long) tokenizer.nval))
          return (int)tokenizer.nval;   
        else
        {
          System.out.println("Incorrect input: " + tokenizer.sval +
                             " Re-enter an integer");
          continue;                    
        }
      }  
      System.out.println("Five failures reading an int value" +
                                        " - program terminated");
      System.exit(1);                   
      return 0;
    } catch(IOException e) {                
    {
      System.out.println(e);             
      System.exit(1);                   
      return 0;
    }
    }
  }
  // Method to read a string...
  public String readString() {
    if (readToken() == tokenizer.TT_WORD || ttype == '\"' 
            || ttype == '\'') {
      return tokenizer.sval;
    } else {
      assert false;
      return null;
    }
  }
  private int readToken() {
	    try {
	      ttype = tokenizer.nextToken();
	      return ttype;

	    } catch (IOException e) {  // Error reading in nextToken()
	      e.printStackTrace(System.err);
	      System.exit(1);         // End the program
	    } 
	    return 0;
	  } 


  // plus methods to read various other data types

  // Read a  string
  public String stringRead() {
    try {
      for(int i = 0; i < 5; i++) {
        int tokenType = tokenizer.nextToken();        // Read a token
        if(tokenType==tokenizer.TT_WORD || tokenType == '\"')   // Type is a string
          return tokenizer.sval;                                // so return it 
        else if(tokenType == '!')                     // Non-alpha returned as type
          return "!";                                 // so return end string
        else {
          System.out.println(
                    "Incorrect input. Re-enter a string between double quotes");
          continue;            // Retry the read operation
        }
      }  
      System.out.println("Five failures reading a string" +
                                        " - program terminated");
      System.exit(1);          // End the program
      return null;
    } catch(IOException e) {   // Error reading in nextToken()
      System.out.println(e);   // Output the error
      System.exit(1);          // End the program
      return null;
    }
  }

  
  private int ttype;   // Stores the token type code

  // Object to tokenize input from the standard input stream
  private StreamTokenizer tokenizer = new StreamTokenizer(
                                      new InputStreamReader(System.in));
}
