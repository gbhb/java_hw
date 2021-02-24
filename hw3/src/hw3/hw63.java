
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class hw53 {
	
	private static class Node
	{
		public Node father;
		public Node left;
		public Node right;
		public String value;
		
		public Node(String value)
		{
			this.value = value;
		}
	}
	
	private static void visit(Node fatherNode, String code)
	{
//		System.out.println("traveling: " + parentNode.value + " " + parentNode.left + parentNode.right);
		if(fatherNode.left == null && fatherNode.right == null)
		{
			codes.put(fatherNode.value, code);
//			System.out.println(parentNode.value + ":" + code);
		}
		if(fatherNode.left != null)
			visit(fatherNode.left, code + "0");
		if(fatherNode.right != null)
			visit(fatherNode.right, code + "1");
	}
	
	private static LinkedHashMap<String, String> codes = new LinkedHashMap<>();
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
			while(scanner.hasNextLine())
			{
				String s = scanner.nextLine();
				String[] chars = s.split("");
				LinkedHashMap<String, Integer> charMap = new LinkedHashMap<>();
				for(String word : chars)
				{
					if(!charMap.containsKey(word))
						charMap.put(word, 1);
					else
						charMap.put(word, (charMap.get(word) + 1));
				}
				
				Node root = new Node("");
				
				LinkedHashMap<String, Node> mapofnode = new LinkedHashMap<>();
				
				while(charMap.size() > 1)
				{

					String leftKey = charMap.entrySet().stream().min((e1, e2) ->
					{
						return Integer.compare(e1.getValue(), e2.getValue());
					}).get().getKey(); 
					Node leftNode = new Node(leftKey);
					if(mapofnode.containsKey(leftKey))
						leftNode = mapofnode.get(leftKey);
					int leftValue = charMap.remove(leftKey);
					
					String rightKey = charMap.entrySet().stream().min((e1, e2) ->
					{
						return Integer.compare(e1.getValue(), e2.getValue());
					}).get().getKey(); 
					Node rightNode = new Node(rightKey);
					if(mapofnode.containsKey(rightKey))
						rightNode = mapofnode.get(rightKey);
					int rightValue = charMap.remove(rightKey);
					
					String parentKey = leftKey + rightKey;
					int parentValue = leftValue + rightValue;
					Node fatherNode = new Node(parentKey);
					charMap.put(parentKey, parentValue);
					
					mapofnode.put(parentKey, fatherNode);
					mapofnode.put(leftKey, leftNode);
					mapofnode.put(rightKey, rightNode);
					
					leftNode.father = fatherNode;
					rightNode.father = fatherNode;
					fatherNode.left = leftNode;
					fatherNode.right = rightNode;
					
					root = fatherNode;
				}
				
				visit(root, "");
				
				codes.entrySet().stream().sorted((e1, e2) ->
				{
					return Integer.compare(Integer.decode(e1.getValue()), Integer.decode(e2.getValue()));
				}).forEachOrdered((e)->System.out.println(e.getKey() + ":" + e.getValue()));
			}
		
		
		scanner.close();
	}
	
	

}
