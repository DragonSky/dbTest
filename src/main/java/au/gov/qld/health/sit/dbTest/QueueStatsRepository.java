package au.gov.qld.health.sit.dbTest;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QueueStatsRepository extends CrudRepository<QueueStats, Long> {
    List<QueueStats> findByJcapsQueue(JcapsQueue jcapsQueue);
}
