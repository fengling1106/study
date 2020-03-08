package list;

import java.util.*;


public class DealList {

	public static void UseArrayList()
	{
		List<String> books = new ArrayList<>();
		
		books.add("java");
		books.add("c++");
	
		//books.forEach(ele -> System.out.prilnt(ele.length()));
		
		for (String book : books)
		{
			System.out.println(book);
		}
		
	}
	
	public static void UseCollection()
	{
		Collection c = new ArrayList();
		c.add("张三");
		c.add(78);
		c.add(212);
		
		System.out.println("The total of C is :"+c.size());
		System.out.println("The C is :"+c);
	}
	
	public static void UseIterator()
	{
		Collection books = new HashSet();
		books.add("Java");
		books.add("englinsh");
		books.add("math");	
		
		
		Iterator it = books.iterator();
		while (it.hasNext())
		{
			String book = (String)it.next();
			System.out.println(book);
		}
	}

	public static void UseMap()
	{
		Map map = new HashMap();
		map.put(89,"book1");
		map.put(23,"book2");
		map.put(60,"book3");

	    for (Object key : map.keySet())
	    {
	    	System.out.println(key + "--->" + map.get(key));
	    }		
	}
	
	public static void useTree()
	{
		TreeSet nums = new TreeSet();
		nums.add(5);
		nums.add(2);
		nums.add(8);
		nums.add(-15);
		System.out.println(nums);
	}
}
