package com.htc.blogger.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.htc.blogger.entity.Blog;
import com.htc.blogger.repo.BlogRepository;

@RestController
@RequestMapping("/api")
public class BlogController {

	@Autowired
	BlogRepository blogRepository;

	private final Logger logger=LoggerFactory.getLogger(BlogController.class);
	

	@PostMapping("/blog")
	public Blog createBlog(@RequestBody Blog blog) {
		logger.info("Request "+blog.toString());
		if (blog.getCreatedAt() == null)
			blog.setCreatedAt(LocalDateTime.now());
		return blogRepository.save(blog);
	}

	
	
	/*
	 * @GetMapping("/get") public Blog dummyComment() { Blog blog=new Blog();
	 * blog.setId(3L); blog.setTitle("Java"); blog.setContent("Practice Everyday");
	 * blog.setCreatedAt(LocalDateTime.now());
	 * blog.setUpdatedAt(LocalDateTime.now()); blog.setAuthorId(5L);
	 * 
	 * return blog;
	 * 
	 * }
	 */
	 

}
