package newsapilib;

import newsapilib.models.request.EverythingRequest;
import newsapilib.models.request.SourcesRequest;
import newsapilib.models.request.TopHeadlinesRequest;
import newsapilib.models.response.ArticleResponse;
import newsapilib.models.response.SourcesResponse;

public class Main {

	public static void main(String[] args) {
		NewsApiClient newsApiClient = new NewsApiClient("900c5aa5b579479b98c951399bf6adb1");

		// /v2/everything
		newsApiClient.getEverything(
		  new EverythingRequest.Builder()
		          .q("trump")
		          .language("es")
		          .build(),
		  new NewsApiClient.ArticlesResponseCallback() {
		      @Override
		      public void onSuccess(ArticleResponse response) {
		          System.out.println(response.getArticles().get(0).getTitle());
		          System.out.println(response.getArticles().get(0).getDescription());
		          System.out.println(response.getArticles().get(0).getAuthor());  
		          System.out.println(response.getArticles().get(0).getPublishedAt());
		          System.out.println(response.getArticles().get(0).getUrl());
		      }

		      @Override
		      public void onFailure(Throwable throwable) {
		          System.out.println(throwable.getMessage());
		      }
		  }
		);
		        
//		// /v2/top-headlines
//		newsApiClient.getTopHeadlines(
//		  new TopHeadlinesRequest.Builder()
//		    .q("bitcoin")
//		    .build(),
//		  new NewsApiClient.ArticlesResponseCallback() {
//		    @Override
//		    public void onSuccess(ArticleResponse response) {
//		      System.out.println(response.getArticles().get(0).getTitle());
//		    }
//
//		    @Override
//		    public void onFailure(Throwable throwable) {
//		      System.out.println(throwable.getMessage());
//		    }
//		  }
//		);
//		        
//		// /v2/top-headlines/sources
//		newsApiClient.getSources(
//		  new SourcesRequest.Builder()
//		    .language("en")
//		    .country("us")
//		    .build(),
//		  new NewsApiClient.SourcesCallback() {
//		    @Override
//		    public void onSuccess(SourcesResponse response) {
//		        System.out.println(response.getSources().get(0).getName());
//		    }
//
//		    @Override
//		    public void onFailure(Throwable throwable) {
//		      System.out.println(throwable.getMessage());
//		    }
//		  }
//		);
	}
	
}

