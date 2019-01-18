package com.example.main;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.AppConfig;
import com.example.entity.Data;
import com.example.service.DataService;
import com.example.util.OkHttpUtil;

@SpringBootApplication
public class JsonTaskApplication {
	private final static String URL1 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/23567e24f52746ef92c470be6059d193/documents";
	private final static String URL2 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents";
	private final static String URL3 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents";	
	
	private AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
	private DataService service = context.getBean(DataService.class);
			
	private void saveToDB(List<Data> entityList){	
		for(Data data: entityList) {
			service.addData(data);
		}	
	}
	
	private void process(){
		List<String> urls = Arrays.asList(URL1, URL2, URL3);
		for(String url: urls) {
			String jsonString = OkHttpUtil.fetchJsonFromServer(url);		
			List<Data> entityList = OkHttpUtil.makeEntitiesFromJson(jsonString);			
			saveToDB(entityList);
		}	
	}
	
	public static void main(String[] args){
		JsonTaskApplication app = new JsonTaskApplication();
		app.process();			
	}
}
