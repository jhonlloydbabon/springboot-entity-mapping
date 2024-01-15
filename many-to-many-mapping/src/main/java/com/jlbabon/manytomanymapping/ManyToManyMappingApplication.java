package com.jlbabon.manytomanymapping;

import com.jlbabon.manytomanymapping.entity.PostEntity;
import com.jlbabon.manytomanymapping.entity.TagEntity;
import com.jlbabon.manytomanymapping.repository.PostRepository;
import com.jlbabon.manytomanymapping.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ManyToManyMappingApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private TagRepository tagRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PostEntity postEntity = new PostEntity();
		postEntity.setTitle("Many to Many Relationship");
		postEntity.setDescription("A practice for springboot enitity mapping.");
		postEntity.setContent("Blog for aspiring springboot developer");
		postEntity.setPostedAt(LocalDateTime.now());
		postEntity.setLastUpdatedAt(LocalDateTime.now());

		TagEntity tag1 = new TagEntity();
		tag1.setName("Springboot");
		TagEntity tag2 = new TagEntity();
		tag2.setName("Hibernate");

		tag1.getPosts().add(postEntity);
		tag2.getPosts().add(postEntity);

		postEntity.getTags().add(tag1);
		postEntity.getTags().add(tag2);



		this.postRepository.save(postEntity);
	}
}
