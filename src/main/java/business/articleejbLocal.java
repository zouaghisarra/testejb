package business;

import java.util.List;

import javax.ejb.Local;

import model.Article;

@Local
public interface articleejbLocal {

	public List<Article> selectAll();
	public int insert(Article ar);
	public int delete(int code);
	public int update(Article ar);
}
