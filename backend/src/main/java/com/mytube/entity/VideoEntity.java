package com.mytube.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Video")
@Getter
@Setter
@NoArgsConstructor
public class VideoEntity {

    @Id
    @Column(length = 16)
    private String videoID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channelID", nullable = false)
    private ChannelEntity channel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryID", nullable = false)
    private VideoCategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thumbnailURL", nullable = false)
    private ThumbnailEntity thumbnail;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private long viewCount = 0L;

    @Column(nullable = false)
    private long likeCount = 0L;

    @Column(nullable = false)
    private long commentCount = 0L;

    @Column(nullable = false)
    private LocalDateTime publishedAt;

    @Column(nullable = false)
    private LocalTime duration;

    @Lob
    private String tags;

    @Column(length = 255)
    private String thumbnailURLSub;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VideoTagEntity> tagsList = new HashSet<>();
}
