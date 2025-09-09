package com.mytube.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Thumbnail")
@Getter
@Setter
@NoArgsConstructor
public class ThumbnailEntity {

    @Id
    @Column(length = 255)
    private String thumbnailURL;

    @Lob
    private String imgKw;

    @Lob
    private String imgText;

    @Lob
    private String colorpalette;
}
