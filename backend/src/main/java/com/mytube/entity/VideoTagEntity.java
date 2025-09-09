package com.mytube.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VideoTag")
@Getter
@Setter
@NoArgsConstructor
public class VideoTagEntity {

    @EmbeddedId
    private VideoTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("videoID")
    @JoinColumn(name = "videoID")
    private VideoEntity video;
}
