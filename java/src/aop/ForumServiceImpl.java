package aop;

//论坛服务实现类
public class ForumServiceImpl implements ForumService {

	//删除标题
	public void removeTopic(int topicId) {
		//PerformanceMonitor.begin("ForumServiceImpl.removeTopic");
		System.out.println("模拟删除Topic记录:"+topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		//PerformanceMonitor.end();
	}

	//删除讨论
	public void removeForum(int forumId) {
		//PerformanceMonitor.begin("ForumServiceImpl.removeForum");
		System.out.println("模拟删除Forum记录:"+forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	//PerformanceMonitor.end();
	}
}
