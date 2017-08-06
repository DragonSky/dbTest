package au.gov.qld.health.sit.dbTest;



import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"queueName" ,"jcapsPort", "jcapsHost"})})
public class JcapsQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUEUE_ID")
    private Long id;
    private String queueName;
    private String jcapsHost;
    private Integer jcapsPort;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getJcapsHost() {
        return jcapsHost;
    }

    public void setJcapsHost(String jcapsHost) {
        this.jcapsHost = jcapsHost;
    }

    public Integer getJcapsPort() {
        return jcapsPort;
    }

    public void setJcapsPort(Integer jcapsPort) {
        this.jcapsPort = jcapsPort;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}