package au.gov.qld.health.sit.dbTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private JcapsQueueRepository jcapsQueueRepository;

    @Autowired
    private QueueStatsRepository queueStatsRepository;



    @GetMapping(path="/addQueue")
    public @ResponseBody String addQueue (@RequestParam String queueName, @RequestParam String jcapsHost, @RequestParam Integer jcapsPort){
        JcapsQueue jcapsQueue = new JcapsQueue();
        jcapsQueue.setQueueName(queueName);
        jcapsQueue.setJcapsHost(jcapsHost);
        jcapsQueue.setJcapsPort(jcapsPort);
        jcapsQueue.setDateAdded(new Date());
        jcapsQueueRepository.save(jcapsQueue);
        return "Saved";
    }

    @GetMapping(path="/allQueues")
    public @ResponseBody Iterable<JcapsQueue> getAllJcapsQueues(){
        return jcapsQueueRepository.findAll();
    }

    @GetMapping(path="/queuesOnHostAndPort")
    public @ResponseBody Iterable<JcapsQueue> getQueuesOnHostAndPort(@RequestParam String jcapsHost, @RequestParam Integer jcapsPort){
        return jcapsQueueRepository.findByJcapsHostAndJcapsPort(jcapsHost,jcapsPort);
    }


    @GetMapping(path="/queuesOnHostAndPort")
    public @ResponseBody JcapsQueue getQueueByNameAndHostAndPort(@RequestParam String queueName, @RequestParam String jcapsHost, @RequestParam Integer jcapsPort){
        return jcapsQueueRepository.findByQueueNameAndJcapsHostAndJcapsPort(queueName, jcapsHost, jcapsPort);
    }

    @GetMapping(path="/deleteQueue")
    public @ResponseBody String deleteQueue(@RequestParam Long queueId){
        jcapsQueueRepository.delete(queueId);
        return "Deleted";
    }

    @GetMapping(path="/deleteAllQueues")
    public @ResponseBody String deleteAllQueues(){
        jcapsQueueRepository.deleteAll();
        return "EverythingDeleted";
    }

    @GetMapping(path="/queuesCreatedSince")
    public @ResponseBody Iterable<JcapsQueue> getCreatedSince(@RequestParam Long longTime){
        return jcapsQueueRepository.findByDateAddedGreaterThan(new Timestamp(longTime));
    }

    @GetMapping(path="/getStatsByQueueId")
    public @ResponseBody Iterable<QueueStats> getStatsByQueueId(@RequestParam Long queueId){
        JcapsQueue jcapsQueue = jcapsQueueRepository.findOne(queueId);
        return queueStatsRepository.findByJcapsQueue(jcapsQueue);
    }

    @GetMapping(path="/addStatByQueueId")
    public @ResponseBody String addStatByQueueId(@RequestParam Long queueId, @RequestParam Long queueSize){
        JcapsQueue jcapsQueue = jcapsQueueRepository.findOne(queueId);
        QueueStats queueStats = new QueueStats(jcapsQueue, queueSize);
        queueStatsRepository.save(queueStats);
        return "Updated";
    }



}
