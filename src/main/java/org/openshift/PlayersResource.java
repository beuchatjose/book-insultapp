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

	String PLAYERS_LIST_URL = "http://hockeymanager.ch/api/RealPlayers/list";
	String PLAYERS_STATS_URL = "http://hockeymanager.ch/api/RealPlayers/stats";
	String GAME_STATUS_URL = "http://hockeymanager.ch/api/Games/status";
	String COUNTRIES_LIST_URL = "http://hockeymanager.ch/api/Countries/list";
	
    @GET()
    @Produces("application/json")
	@Path("/list")
    public String getPlayers()  {
        return new HMParser().getPageContent(PLAYERS_LIST_URL);
    }
	
    
    @GET()
    @Produces("application/json")
	@Path("/stats")
    public String getStats() {
        return new HMParser().getPageContent(PLAYERS_STATS_URL);
    }
    
    @GET()
    @Produces("application/json")
	@Path("/gamestatus")
    public String getGameStatus() {
        return new HMParser().getPageContent(GAME_STATUS_URL);
    }
    
    @GET()
    @Produces("application/json")
	@Path("/countries")
    public String getCountries() {
        return new HMParser().getPageContent(COUNTRIES_LIST_URL);
    }
}