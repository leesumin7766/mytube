package com.mytube.repository;

import com.mytube.entity.VideoTagEntity;
import com.mytube.entity.VideoTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoTagRepository extends JpaRepository<VideoTagEntity, VideoTagId> {

    // 특정 영상의 태그 전체 조회
    List<VideoTagEntity> findByVideo_VideoID(String videoID);

    // 특정 태그를 가진 영상 검색
    List<VideoTagEntity> findById_Tag(String tag);
}
