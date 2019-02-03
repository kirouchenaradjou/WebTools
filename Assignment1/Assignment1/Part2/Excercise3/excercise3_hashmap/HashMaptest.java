package excercise3_hashmap;
import java.util.HashMap;
public class HashMaptest {
	public static void main(String args[])
	{
		HashMap<String, Integer> aMap = new HashMap<>();
		String myKey = "Goofy";
		int value = 12345;
		Integer oldValue = null;
		for(int i = 0;i<4;++i)
		{  if((oldValue = aMap.put(myKey, value++)) != null) {   
			System.out.println("No Boundced"+oldValue); 
			} 
		}
	}

}
