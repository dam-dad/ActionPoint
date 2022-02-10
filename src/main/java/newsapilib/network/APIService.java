package newsapilib.network;

import java.util.Map;

import newsapilib.models.response.ArticleResponse;
import newsapilib.models.response.SourcesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIService {

	@GET("/v2/sources")
	Call<SourcesResponse> getSources(@QueryMap Map<String, String> query);

	@GET("/v2/top-headlines")
	Call<ArticleResponse> getTopHeadlines(@QueryMap Map<String, String> query);

	@GET("/v2/everything")
	Call<ArticleResponse> getEverything(@QueryMap Map<String, String> query);

}
