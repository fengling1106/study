package dsp;
import java.util.*;

//主题具体类
public class ConcreteWatched implements Watched {

	// 存放观察者
    private List<Watcher> list = new ArrayList<Watcher>();
    
	@Override
	public void addWatcher(Watcher watcher) {
		list.add(watcher);

	}

	@Override
	public void removeWatcher(Watcher watcher) {
		list.remove(watcher);

	}

	@Override  //通知消息
	public void notifyWatchers(String str) {
		 
		// 自动调用实际上是主题进行调用的
        for (Watcher watcher : list)
        {
            watcher.update(str);
        }
	}

}
