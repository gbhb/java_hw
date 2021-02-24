package hw3;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class hw33
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			while(scanner.hasNextLine())
			{
				int cc = scanner.nextInt();
				if(cc == 0)
					return;
				for( ; cc>0 ; cc--)
				{
					int size = scanner.nextInt();
					LinkedHashMap<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
					for(int index = size ; index>0 ; index--)
					{
						String str = scanner.next();
//						System.out.println(str);
						str = str.replace("(", "");
						str = str.replace(")", "");
						String[] str2num = str.split(",");
						int a1 = Integer.valueOf(str2num[0]);
						int a2 = Integer.valueOf(str2num[1]);
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
		boolean visit = false;
		for(int i : map.get(traversal.getLast()))
		{
			if(visit == true)
				return true;
			if(!traversal.contains(i))
			{
				traversal.addLast(i);
				visit = visit ^ search(map, traversal);
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
		return visit;
	}

	
}
