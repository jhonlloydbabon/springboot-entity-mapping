package com.jlbabon.onemanypractice;

import com.jlbabon.onemanypractice.entity.CommentEntity;
import com.jlbabon.onemanypractice.entity.PostEntity;
import com.jlbabon.onemanypractice.repository.CommentRepository;
import com.jlbabon.onemanypractice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OneManyPracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneManyPracticeApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void run(String... args) throws Exception {
		PostEntity postEntity = new PostEntity();
		postEntity.setTitle("One to Many Relationship");
		postEntity.setDescription("one to many entity mapping");

		CommentEntity comment1 = new CommentEntity("Very useful");
		CommentEntity comment2 = new CommentEntity("Very good");
		CommentEntity comment3 = new CommentEntity("Great Post");

		CommentEntity [] comments = {comment1,comment2,comment3};
		List<CommentEntity> commentList = new ArrayList<>(Arrays.asList(comments));

		postEntity.setComments(commentList);

		this.postRepository.save(postEntity);
	}
}
