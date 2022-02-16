package newsapilib;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.Source;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;

public class Main {

	public static String titulo="";
	
	public static void main(String[] args) {

		
		
		
		NewsApiClient newsApiClient = new NewsApiClient("900c5aa5b579479b98c951399bf6adb1");

		NewsApiClient.ArticlesResponseCallback callback = new NewsApiClient.ArticlesResponseCallback() {
			@Override
			public void  onSuccess(ArticleResponse response) {
				System.out.println("Ya tengo un resultado!!!! " + response.getArticles().size());
				for (Article article : response.getArticles()) {
//					System.out.println("----------" + article.getTitle() + "-------------");
//					System.out.println(article.getDescription());
//					System.out.println(article.getAuthor());
//					System.out.println(article.getPublishedAt());
//					System.out.println(article.getUrl());
//					System.out.println(article.getUrlToImage());
					
					titulo=article.getTitle();
					
					
				}
				
			}

			@Override
			public void onFailure(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		};

		// /v2/everything
		newsApiClient.getEverything(new EverythingRequest.Builder().q("reforma laboral").language("es").pageSize(5).page(2).sortBy("publishedAt").build(), callback);

		// /v2/top-headlines
//		newsApiClient.getTopHeadlines(new TopHeadlinesRequest.Builder().q("reforma loboral").language("es").build(), callback);

// /v2/top-headlines/sources
//		newsApiClient.getSources(new SourcesRequest.Builder().build(),
//				new NewsApiClient.SourcesCallback() {
//					@Override
//					public void onSuccess(SourcesResponse response) {
//						System.out.println("Ya tengo un resultado!!!!");
//						for (Source source : response.getSources()) {
//							System.out.println("----------" + source.getName() + "-------------");
//							System.out.println(source.getDescription());
//							System.out.println(source.getUrl());
//						}					
//					}
//
//					@Override
//					public void onFailure(Throwable throwable) {
//						System.out.println(throwable.getMessage());
//					}
//				});

	}

	public static String getTitulo() {
		return titulo;
	}

	public static void setTitulo(String titulo) {
		Main.titulo = titulo;
	}

}
