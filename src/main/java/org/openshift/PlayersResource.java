package org.openshift;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.HashMap;

@RequestScoped
@Path("/insult")
public class PlayersResource {
    @GET()
    @Produces("application/json")
    public HashMap<String, String> getInsult() throws ClientProtocolException, IOException {
        HashMap<String, String> theInsult = new HashMap<String, String>();
        theInsult.put("players", new HMParser().getSkillsPageContent());
        return theInsult;
    }
}