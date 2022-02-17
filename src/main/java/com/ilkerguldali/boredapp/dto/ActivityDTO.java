package com.ilkerguldali.boredapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ActivityDTO implements Serializable {
    private Long id;
    private String activity;
    private double accessibility;
    private String type;
    private int participants;
    private double price;
    private String link;
}
