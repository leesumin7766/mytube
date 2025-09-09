package com.mytube.service;

import com.mytube.entity.VideoEntity;
import com.mytube.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    // 영상 등록 (DB 저장)
    public VideoEntity save(VideoEntity video) {
        return videoRepository.save(video);
    }

    // 영상 상세 조회
    public Optional<VideoEntity> getVideoById(String videoID) {
        return videoRepository.findById(videoID);
    }

    // 인기 영상 TOP10 조회
    public List<VideoEntity> getTop10Videos() {
        return videoRepository.findTop10ByOrderByViewCountDesc();
    }

    // 조회수 직접 증가 (DB 방식) → 나중에 Redis 방식으로 대체 예정
    public void increaseViewCount(String videoID) {
        videoRepository.findById(videoID).ifPresent(video -> {
            video.setViewCount(video.getViewCount() + 1);
            videoRepository.save(video);
        });
    }
}
