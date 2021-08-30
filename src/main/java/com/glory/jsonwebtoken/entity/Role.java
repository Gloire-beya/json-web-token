package com.glory.jsonwebtoken.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    private Long roleId;
    @Column(length = 50, nullable = false)
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
