package com.project.springbootpodnginx.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    private String id;

    private String name;

    private String pod;

    private String updatePod;

    public UserEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Version
    private Long version;
}
