package dsp;

public class ObserverTest {

	/**
	 * @param args
	 */
	public static void UseObserver() {
		
		 //主题
		 Watched girl = new ConcreteWatched();
	        
		//观察者对象
	     Watcher watcher1 = new ConcreteWatcher();
	     Watcher watcher2 = new ConcreteWatcher();
	     Watcher watcher3 = new ConcreteWatcher();
	     
	    //主题中添加观察者
	     girl.addWatcher(watcher1);
	     girl.addWatcher(watcher2);
	     girl.addWatcher(watcher3);
	     
	    //主题内容变更，通知观察者
	     girl.notifyWatchers("开始更新了.....");


	}

}
