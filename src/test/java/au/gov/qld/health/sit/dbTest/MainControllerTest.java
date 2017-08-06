package au.gov.qld.health.sit.dbTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MainControllerTest {


    public static final String TEST_HOST = "TestHost";
    public static final String TEST_QUEUE = "TestQueue";
    public static final int JCAPS_PORT = 90000;
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    JcapsQueueRepository jcapsQueueRepository;

    @Test
    public void findQueueByNameHostAndPort(){
        JcapsQueue testQueue = new JcapsQueue();
        testQueue.setDateAdded(new Date());
        testQueue.setQueueName(TEST_QUEUE);
        testQueue.setJcapsHost(TEST_HOST);
        testQueue.setJcapsPort(JCAPS_PORT);
        entityManager.persist(testQueue);
        entityManager.flush();


        JcapsQueue found =
                jcapsQueueRepository.findByQueueNameAndJcapsHostAndJcapsPort(TEST_QUEUE,TEST_HOST,JCAPS_PORT);
        assertThat(found.getQueueName()).isEqualTo(testQueue.getQueueName());
    }




}