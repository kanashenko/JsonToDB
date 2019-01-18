package com.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.entity.Data;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {
	private static OkHttpClient client = new OkHttpClient();

	public static String fetchJsonFromServer(String url) {
		Request request = new Request.Builder().url(url).build();
		String jsonString = null;
		try (Response response = client.newCall(request).execute()) {
			jsonString = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	
	public static List<Data> makeEntitiesFromJson(String jsonString){
		List<Data> entityList = new ArrayList<>();		
		JSONObject jsonData = new JSONObject(jsonString);
		JSONArray jsonArray = jsonData.getJSONArray("data");
		Data data = null;
		for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject jsonEntry = jsonArray.getJSONObject(i);         
	        try {
				data = new ObjectMapper().readValue(jsonEntry.toString(), Data.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        entityList.add(data);
	    }
		return entityList;
	}
}
