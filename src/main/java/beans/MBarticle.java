package beans;


import java.util.List;

import javax.ejb.EJB;

import business.articleejbLocal;
import model.Article;

public class MBarticle {
	@EJB
	articleejbLocal ejb;
	
	private List<Article> articles;
	private Article article=new Article();
	
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticles() {
		articles=ejb.selectAll();
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public void inserer() {
		if (ejb.insert(article)!=0)
			System.out.println("insertion effectuée");
		else
			System.out.println("insertion non effectuée");
		
	}
	 public void supprimer() {
		 if(ejb.delete(article.getCode())!=0)
			 System.out.println("suppression effectue");
		 else
			 System.out.println("suppression non effectue");
	}
	 
	 public void modifier(){
			if (ejb.update(article)!=0)
				System.out.println("modification effectuée");
			else
				System.out.println("modification non effectuée");
		}
	
}
