package system;

public class DealSystem {

	public static void printCurrentSystem()
	{
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println(System.getenv("PATH"));
	}
}
