package dsp;


//观察者具体类
public class ConcreteWatcher implements Watcher {

	@Override
	public void update(String str) {
	
		System.out.println(this.toString()+str);

	}

}
