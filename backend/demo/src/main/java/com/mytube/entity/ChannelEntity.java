package com.mytube.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Channel")
@Getter
@Setter
@NoArgsConstructor
public class ChannelEntity {

    @Id
    @Column(length = 50)
    private String channelID;

    @Column(nullable = false, length = 255)
    private String channelTitle;

    @Column(nullable = false)
    private int subscriberCount = 0;

    @Column(nullable = false)
    private long totalViews = 0L;

    @Column(nullable = false)
    private int videoCount = 0;
}
