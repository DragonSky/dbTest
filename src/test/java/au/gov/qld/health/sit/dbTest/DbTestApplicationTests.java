package au.gov.qld.health.sit.dbTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbTestApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void getQueueByNameAndHostAndPort() throws Exception {
		MainController mainController = new MainController();
		mainController.addQueue("TestQueue", "TestHost", 2093);
//        JcapsQueue result = mainController.getQueueByNameAndHostAndPort("TestQueue", "TestHost", 2093);
//        System.out.println(result);
	}


}
