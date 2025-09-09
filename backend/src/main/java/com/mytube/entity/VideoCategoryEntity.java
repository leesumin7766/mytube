package com.mytube.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VideoCategory")
@Getter
@Setter
@NoArgsConstructor
public class VideoCategoryEntity {

    @Id
    @Column(length = 10)
    private String categoryID;

    @Column(nullable = false, length = 50)
    private String title;
}
