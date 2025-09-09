package com.mytube.repository;

import com.mytube.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoCategoryRepository extends JpaRepository<VideoEntity, String> {

    // 조회수 기준 상위 N개 영상 가져오기
    List<VideoEntity> findTop10ByOrderByViewCountDesc();

    // 특정 채널의 영상 목록
    List<VideoEntity> findByChannel_ChannelID(String channelID);

    // 특정 카테고리 영상 목록
    List<VideoEntity> findByCategory_CategoryID(String categoryID);
}
