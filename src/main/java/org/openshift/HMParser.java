package org.openshift;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HMParser {

	String PLAYERS_LIST_URL = "http://hockeymanager.ch/api/RealPlayers/list";
	String PLAYERS_STATS_URL = "http://hockeymanager.ch/api/RealPlayers/stats";
	String STATUS_URL = "http://hockeymanager.ch/api/Games/status";
	String COUNTRIES_LIST_URL = "http://hockeymanager.ch/api/Countries/list";
	
	public String getSkillsPageContent() throws ClientProtocolException, IOException{

		HttpGet request = new HttpGet(PLAYERS_LIST_URL);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

}
