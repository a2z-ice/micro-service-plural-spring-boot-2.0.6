package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class PluralsightSpringcludM3TasksinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcludM3TasksinkApplication.class, args);
	}
}
