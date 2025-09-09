package com.mytube.repository;

import com.mytube.entity.ThumbnailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThumbnailRepository extends JpaRepository<ThumbnailEntity, String> {
}
