package cn.ccf.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TaskManager implements ApplicationListener<ContextRefreshedEvent> {
	private  ScheduledExecutorService ses = null;
	@Autowired
	private GenerateBinaryFileTask generateBinaryFileTask;

	public  synchronized void start() {
		if (ses == null) {
			ses = Executors.newScheduledThreadPool(1);
			// 在程序启动10s以后执行第一次，然后每隔3s执行一次
			ses.scheduleWithFixedDelay(generateBinaryFileTask, 1, 3, TimeUnit.SECONDS);
		}
	}

	public  synchronized void stop() {
		if (ses != null) {
			ses.shutdown();
			ses = null;
		}
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		start();
	}

}
