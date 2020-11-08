package com.fab.models.gr;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Bailiff object stored at the db
 * and access them via JPA
 */
@Data
@Entity
@Table(name="bailiffs")
public class BailiffEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotEmpty(message="* Please Enter Full Name")
    private String name;

    @Column(name="address")
    @NotEmpty(message="* Please Enter Address")
    private String address;

    @Column(name="postalcode")
    @NotEmpty(message="* Please Postal Code")
    private String postalCode;

    @Column(name="municipality")
    @NotEmpty(message="* Please Enter Municipality")
    private String municipality;

    @Column(name="tel")
    @NotEmpty(message="* Please Enter Telephone")
    private String tel;
}