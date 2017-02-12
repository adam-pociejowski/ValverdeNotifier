package com.valverde.entity;

import com.valverde.enums.State;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "sms")
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_sms")
    @SequenceGenerator(name = "seq_gen_sms", sequenceName = "seq_bus")
    private Long id;

    private String recipients;

    @Lob
    @Type(type = "text")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    private Integer sendAttempts;

    @Enumerated(EnumType.STRING)
    private State state;
}
