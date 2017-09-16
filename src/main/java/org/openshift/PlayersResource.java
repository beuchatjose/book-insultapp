package org.openshift;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.HashMap;

@RequestScoped
@Path("/players")
public class PlayersResource {
	
    @GET()
    @Produces("application/json")
	@Path("/list")
    public String getInsult() throws ClientProtocolException, IOException {
        return new HMParser().getSkillsPageContent();
    }
	
}