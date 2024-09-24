import java.util.*;

//Strategy Interface for search
//Using generics, the searchservice work for different types of search requests and results
public interface SearchService<K,T>{
    public List<T> search(K searchcriteria, Class<T> modelClass);
}

// Abstract class where base search method can be implemented
public abstract class AbstractTextSearchServiceImpl<K extends TextSearchRequest,T> 
                        implements SearchService<K,T>{
                            
    public List<T> search(K searchcriteria, Class<T> modelClass){
        
    }
}

// Abstract class where base search method can be implemented
public abstract class AbstractImageSearchServiceImpl<K extends ImageSearchRequest,T> 
                        implements SearchService<K,T>{
    public List<T> search(K searchcriteria, Class<T> modelClass){
        
    }
}

public class ArticleSearchServiceImpl extends AbstractTextSearchServiceImpl<TextSearchRequest,ArticlePage> {
    public List<ArticlePage> search(K searchcriteria, ArticlePage){
        searchCriteria.add(articleSearchCondition);
        super.search();
    }
}

public class FAQSearchServiceImpl extends AbstractTextSearchServiceImpl<TextSearchRequest,FAQPage> {
    public List<FAQPage> search(K searchcriteria, FAQPage){
        searchCriteria.add(faqSearchCondition);
        super.search();
    }
}

public class GlossarySearchServiceImpl extends AbstractTextSearchServiceImpl<TextSearchRequest,GlossaryPage> {
    public List<GlossaryPage> search(K searchcriteria, GlossaryPage){
        searchCriteria.add(glossarySearchCondition);
        super.search();
    }
}

public class FeauturedArticleSearchServiceImpl extends ArticleSearchServiceImpl<TextSearchRequest,ArticlePage> {
    public List<ArticlePage> search(K searchcriteria, ArticlePage){
        searchCriteria.add(featuredArticleSearchCondition);
        super.search();
    }
}
