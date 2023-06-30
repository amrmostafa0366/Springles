package org.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChatKey {
    private Long id1;
    private Long id2;

    public ChatKey() {
    }

    public ChatKey(Long id1, Long id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }
}
