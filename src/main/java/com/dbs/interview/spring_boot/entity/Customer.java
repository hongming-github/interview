package com.dbs.interview.spring_boot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(name = "UUID", example = "UUID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private UUID id;

    @Schema(name = "Customer name", example = "Allen", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(name = "Customer gender", example = "male", requiredMode = Schema.RequiredMode.REQUIRED)
    private String gender;

    private Customer() {
    }

    public Customer(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Customer customer))
            return false;
        return Objects.equals(this.id, customer.id) && Objects.equals(this.name, customer.name)
                && Objects.equals(this.gender, customer.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.gender);
    }

    @Override
    public String toString() {
        return "Customer {" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.gender + '\'' + '}';
    }
}
