package ctrl;

import java.util.*;

import obj.Person;

public class Control {
	public static void UseArrays()
	{
		int[] a = new int[]{3,4,5,6};
		int[] b = new int[]{3,4,5,6};
		int[] c = new int[]{1,4,8,6};
		System.out.print("a b is :"+Arrays.equals(a,b));
		Arrays.sort(c);
		System.out.print("c is :"+Arrays.toString(c));
	}
	
	public static void UsrArray()
	{
		//int[] a =new int[5];
		
		//int  b= a[5];
		
		/*for(int i=0; i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		String[] books = new String[4];
		books[0]="JQuery";
		books[1]="Office";
		for(String book : books)
		{
			System.out.println(book);
		}*/
		
		int[] x = {5,7,20};
		int[] y = new int[4];
		
		System.out.println("X is address:"+x);
		System.out.println("Y is address:"+y);
	  
	    System.out.println("-------hashcode--------");
	    System.out.println("X is hashcode:"+x.hashCode());
	  
	  
		y = x;
		for (int i=0; i<y.length; i++)
		{
			System.out.println(y[i]);
		}
	}
	
	public static void UseFor()
	{
		  for(int i=0; i<5; i++)
	   	  {
	   	  	System.out.println(i);
	   	  }
	}
	
	public static void UseIf()
	{
	 	int age=32;
	 	/*if (age>60)
	 	{
	 		System.out.println("old");
	 		}
	 	else if(age>40)
	 	{ 
	 		System.out.println("middle");
	 		}
	
	 		else if(age>20)
	 	{ 
	 	  System.out.println("young");
	 	 	}*/
	 	 	
	 	if (age<20)
	 	{
	 		System.out.println("old");
	 		}
	 	else if(age>20 && age<40)
	 	{ 
	 		System.out.println("middle");
	 		}
	
	 	else if(age>60)
	 	{
	 		System.out.println("old");
	 	 }	 	 	
	 	
	}
	
	
	public static void UseRefArray()
	{
		Person[] students;
		students = new Person[2];
		Person zhang = new Person();
		zhang.age=10;
		zhang.height=120;
		
		Person li = new Person();
		li.age=20;
		li.height = 118;
		
		students[0]=zhang;
		students[1]=li;
		
		li.info();
		students[1].info();				
	}
	
	public static void UseSwitch()
	{
		char score='C';
		switch(score)
		{
			case 'A':
			System.out.println("优秀");
			break;
			case 'B':
			System.out.println("良好");
			break;
			case 'C':
			System.out.println("及格");
			break;
			case 'D':
			break;
			}
	}
	
	public static void UseWhile()
	{
		int count=0;
		while(count<10)
		{
			System.out.println(count);
			count++;
		}
		
		}
}
