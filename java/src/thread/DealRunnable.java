package thread;

public class DealRunnable implements Runnable {

	private int i;
	
	public void  run()
	{
		for (; i<100; i++)
		{
			System.out.println(Thread.currentThread().getName()+" " +i);
		}
	}
	
	public static void StartRunnable()
	{
		for (int i=0; i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" " +i);
		
			if (i == 20)
			{
				DealRunnable st = new DealRunnable();
				new Thread(st, "新线程1").start();
				new Thread(st, "新线程2").start();
			}
		}
	}
}
