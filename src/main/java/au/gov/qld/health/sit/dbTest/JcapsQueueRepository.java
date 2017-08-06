package au.gov.qld.health.sit.dbTest;

import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface JcapsQueueRepository extends CrudRepository<JcapsQueue, Long>{
    List<JcapsQueue> findByJcapsHostAndJcapsPort(String jcapsHost, Integer jcapsPort);
    List<JcapsQueue> findByDateAddedGreaterThan(Timestamp timestamp);
    JcapsQueue findByQueueNameAndJcapsHostAndJcapsPort(String queueName, String jcapsHost, Integer jcapsPort);
}
