package com.mytube.scheduler;

import com.mytube.repository.VideoRepository;
import com.mytube.service.ViewCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ViewCountScheduler {

    private final VideoRepository videoRepository;
    private final ViewCountService viewCountService;

    // 1분마다 Redis → DB 동기화
    @Scheduled(fixedRate = 60000)
    public void syncAllViewCounts() {
        videoRepository.findAll().forEach(video ->
                viewCountService.syncViewCountToDB(video.getVideoID())
        );
    }
}
