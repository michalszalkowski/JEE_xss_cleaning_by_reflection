package pl.btbw.module.article;

import java.util.ArrayList;
import java.util.List;

public class ArticleDto {

	private List<String> blogs;

	public List<String> getBlogs() {
		if (blogs == null) {
			blogs = new ArrayList<>();
		}
		return blogs;
	}
}
