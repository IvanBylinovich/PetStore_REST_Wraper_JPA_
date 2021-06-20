package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID key;
    @OneToOne
    private User user;


}
