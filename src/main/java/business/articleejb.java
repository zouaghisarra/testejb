package business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Article;

/**
 * Session Bean implementation class articleejb
 */
@Stateless
@LocalBean
public class articleejb implements articleejbLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	public List<Article> selectAll(){
		Query query=em.createNamedQuery("Article.findAll");
		return   query.getResultList();
		
	}
	
	@Override
	public int insert(Article ar) {
		int res;
		Article article=em.find(Article.class,ar.getCode());
		if(article!=null)
			res=1;
		else {
			em.persist(ar);
			res=0;}
		
		return res;
		
	}

	@Override
	public int delete(int code) {
		int res;
		Article article=em.find(Article.class,code);
		
		if (article==null)
			res=0;
		else {
			em.remove(article);
			res=1;}
		
		 
		return res;
		
	}

	@Override
	public int update(Article ar) {
		int res;
		Article article=em.find(Article.class,ar.getCode());
		
		if(article==null)
			res=0;
		else {
			em.merge(ar);
			res=1;
		}
			
		 
		return res;
	}

    

}
