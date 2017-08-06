package au.gov.qld.health.sit.dbTest;

import javax.persistence.*;
import java.util.Date;

@Entity
public class QueueStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

        @ManyToOne(cascade = CascadeType.ALL)
    private JcapsQueue jcapsQueue;
    private Long queueSize;
    private Date updateDateTime;

    public QueueStats(JcapsQueue jcapsQueue, Long queueSize) {

        this.jcapsQueue = jcapsQueue;
        this.queueSize = queueSize;
        this.updateDateTime = new Date();
    }

    public QueueStats() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JcapsQueue getJcapsQueue() {
        return jcapsQueue;
    }

    public void setJcapsQueue(JcapsQueue jcapsQueue) {
        this.jcapsQueue = jcapsQueue;
    }

    public Long getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(Long queueSize) {
        this.queueSize = queueSize;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
