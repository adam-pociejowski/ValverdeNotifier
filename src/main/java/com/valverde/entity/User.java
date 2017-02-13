package com.valverde.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_user")
    @SequenceGenerator(name = "seq_gen_user", sequenceName = "seq_user")
    private Long id;

    private String username;

    private String passwordHash;
}