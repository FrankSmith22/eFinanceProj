package com.example.efinance.model;

import javax.persistence.*;

@Entity
@Table(name ="messages")
public class Messages {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;
    @Column(name = "messaged_to")
    private String userMessaged;
    @Column(name = "message_content")
    private String messageDetails;
    @Column(name = "is_read")
    private boolean read;

}
