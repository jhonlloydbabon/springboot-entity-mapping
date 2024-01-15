package com.jlbabon.manytomanymapping.repository;

import com.jlbabon.manytomanymapping.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
