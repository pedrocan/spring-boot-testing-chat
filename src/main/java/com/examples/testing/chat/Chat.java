package com.examples.testing.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@JsonIgnoreProperties(allowGetters = true)
public final class Chat {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    public Chat(UUID id, String name) {

        if(id == null || id.toString().isBlank() || id.toString().isEmpty()){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(name == null || name.toString().isBlank() || name.toString().isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
