package vye.es;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import vye.Mob;


public class ESClient {
	
	
	private static TransportClient client = null;

	public static void post(Mob mob) throws Exception {
		
		if(client == null) {
			client = new PreBuiltTransportClient(Settings.EMPTY)
		    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(mob);
		IndexResponse response = client.prepareIndex("mobs", "mob")
		        .setSource(json)
		        .get();
	}
	
	
}
