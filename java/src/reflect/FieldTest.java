package reflect;

import java.lang.reflect.*;

class Person
{
	private String name;
	private int age;
	
	public String toString()
	{
		return name+"----"+age;
	}
}

public class FieldTest {
	public static void UseField() throws Exception
	{
		Person p = new Person();
		Class<Person> personClazz = Person.class;
		
		Field nameField = personClazz.getDeclaredField("name");
		
		nameField.setAccessible(true);
		nameField.set(p, "fengling");
		
		Field ageField = personClazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.setInt(p, 36);
		
		System.out.println(p.toString());
		
	}
}
