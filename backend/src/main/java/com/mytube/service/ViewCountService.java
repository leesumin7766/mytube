package com.mytube.service;

import com.mytube.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewCountService {

    private final StringRedisTemplate redisTemplate;
    private final VideoRepository videoRepository;

    private static final String VIDEO_VIEW_KEY = "video:views:";

    // Redis에 조회수 증가
    public void increaseViewCount(String videoID) {
        redisTemplate.opsForValue().increment(VIDEO_VIEW_KEY + videoID);
    }

    // Redis에서 현재 조회수 가져오기
    public long getViewCount(String videoID) {
        String value = redisTemplate.opsForValue().get(VIDEO_VIEW_KEY + videoID);
        return (value != null) ? Long.parseLong(value) : 0L;
    }

    // Redis → DB 동기화 (스케줄러에서 주기적으로 호출)
    public void syncViewCountToDB(String videoID) {
        long count = getViewCount(videoID);
        videoRepository.findById(videoID).ifPresent(video -> {
            video.setViewCount(video.getViewCount() + count);
            videoRepository.save(video);
            redisTemplate.delete(VIDEO_VIEW_KEY + videoID); // 반영 후 Redis 초기화
        });
    }
}
