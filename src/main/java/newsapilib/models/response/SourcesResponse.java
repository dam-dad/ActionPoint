package newsapilib.models.response;

import java.util.List;

import newsapilib.models.Source;

public class SourcesResponse {

	  private String status;
	    private List<Source> sources;

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public List<Source> getSources() {
	        return sources;
	    }

	    public void setSources(List<Source> sources) {
	        this.sources = sources;
	    }
	
}
