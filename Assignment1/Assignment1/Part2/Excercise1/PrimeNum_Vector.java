import java.util.Vector;
public class PrimeNum_Vector {
	public static void main(String[] args)
	  {
		//The max number is 20 - print prime nos within 20
		int sizeOfVector=20;
		Vector<Integer> primeNumbers = new Vector<>(sizeOfVector);
		primeNumbers.add(2);
		for(int i=3;i<=sizeOfVector;i+=2)
		{
			int flag=1;

			for(int j=2;j<(i/2);j++)
			{
				if(i%j==0)
				{
				flag=2;
				break;
				}
				
			}
			if(flag==1)
			{
				primeNumbers.add(i);
			}
			
		}
		for(Integer integer :primeNumbers)
		{
			System.out.println(integer);
		}
	  }
}
