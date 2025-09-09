package com.mytube.controller;

import com.mytube.entity.VideoEntity;
import com.mytube.service.VideoService;
import com.mytube.service.ViewCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    private final ViewCountService viewCountService;

    // 🎬 영상 업로드 (파일 저장은 단순 경로 저장 방식)
    @PostMapping("/upload")
    public ResponseEntity<VideoEntity> uploadVideo(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("channelID") String channelID,
            @RequestParam("categoryID") String categoryID,
            @RequestParam("thumbnailURL") String thumbnailURL
    ) {
        try {
            // 실제 파일 저장 로직은 생략 (ex: 로컬 경로, S3 업로드 등)
            String filePath = "/uploads/" + file.getOriginalFilename();

            VideoEntity video = new VideoEntity();
            video.setVideoID(file.getOriginalFilename()); // 실습용: 파일명으로 ID 대체
            video.setTitle(title);
            video.setPublishedAt(LocalDateTime.now());
            video.setDuration(LocalTime.of(0, 3, 0)); // 기본 3분짜리 영상 (실습용)
            video.setThumbnailURLSub(thumbnailURL);

            // TODO: channel, category, thumbnail 엔티티 주입 필요
            // 여기서는 간단히 null로 두거나 Service에서 설정

            VideoEntity saved = videoService.save(video);
            return ResponseEntity.ok(saved);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 📺 영상 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<VideoEntity> getVideo(@PathVariable String id) {
        Optional<VideoEntity> video = videoService.getVideoById(id);
        return video.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 👀 조회수 증가 (Redis 방식)
    @PostMapping("/{id}/view")
    public ResponseEntity<String> increaseView(@PathVariable String id) {
        viewCountService.increaseViewCount(id);
        return ResponseEntity.ok("조회수 증가 완료 (Redis)");
    }

    // ⭐ 인기 영상 TOP10
    @GetMapping("/popular")
    public ResponseEntity<List<VideoEntity>> getPopularVideos() {
        List<VideoEntity> videos = videoService.getTop10Videos();
        return ResponseEntity.ok(videos);
    }
}
