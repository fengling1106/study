package thread;

public class DealThread extends Thread {

	private int i;
	
	public void run()
	{
		for (; i<100; i++)
		{
			System.out.println(getName()+" " +i);
		}
	}
	
	public static void StartThread()
	{
		for (int i=0; i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20) //计数等于20时，启动新线程
			{
				new DealThread().run();
				new DealThread().run();
			}
		}
	}
}
