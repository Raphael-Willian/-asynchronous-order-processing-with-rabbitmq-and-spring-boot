package com.raphael.asyncorderprocessing.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idClient;

    private String nameclient;
    private String cpfClient;


}
