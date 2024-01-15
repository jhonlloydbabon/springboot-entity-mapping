package com.jlbabon.manytomanymapping.repository;

import com.jlbabon.manytomanymapping.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
