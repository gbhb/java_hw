import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Hamiltonian
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			while(scanner.hasNextLine())
			{
				int count = scanner.nextInt();
				if(count == 0)
					return;
				for( ; count>0 ; count--)
				{
					int size = scanner.nextInt();
					LinkedHashMap<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
					for(int index = size ; index>0 ; index--)
					{
						String s = scanner.next();
//						System.out.println(s);
						s = s.replace("(", "");
						s = s.replace(")", "");
						String[] sA = s.split(",");
						int a1 = Integer.valueOf(sA[0]);
						int a2 = Integer.valueOf(sA[1]);
						if(!map.containsKey(a1))
							map.put(a1, new LinkedList<>());
						if(!map.containsKey(a2))
							map.put(a2, new LinkedList<>());
						if(!map.get(a1).contains(a2))
							map.get(a1).add(a2);
						if(!map.get(a2).contains(a1))
							map.get(a2).add(a1);
					}
					LinkedList<Integer> traversal = new LinkedList<>();
					traversal.add(1);
					System.out.println(search(map, traversal));
					
				}
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	//	System.out.println("done");
		scanner.close();

	}

	private static boolean search(LinkedHashMap<Integer, LinkedList<Integer>> map, LinkedList<Integer> traversal)
	{
		boolean value = false;
		for(int i : map.get(traversal.getLast()))
		{
			if(value == true)
				return true;
			if(!traversal.contains(i))
			{
				traversal.addLast(i);
				value = value ^ search(map, traversal);
				traversal.removeLast();
			}
			else
			{
				if(traversal.size() == map.keySet().size())
				{
					if(i == traversal.getFirst())
						return true;
				}
			}
		}
		return value;
	}
}
