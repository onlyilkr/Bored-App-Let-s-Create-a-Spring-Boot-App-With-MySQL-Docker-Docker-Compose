package com.ilkerguldali.boredapp.model;

import com.ilkerguldali.boredapp.dto.ActivityDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter @Getter
@NoArgsConstructor
@ToString
public class Activity {
    @Id
    @GeneratedValue
    public Long id;
    private String title;
    private double accessibility;
    private String type;
    private int participants;
    private double price;
    private String link;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
