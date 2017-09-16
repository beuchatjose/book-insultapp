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
    public String getInsult() throws ClientProtocolException, IOException {
        return new HMParser().getSkillsPageContent();
    }
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMemberList() throws ClientProtocolException, IOException {
	    Object players = new HMParser().getSkillsPageContent();
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(players )
	            .build();
	}
}