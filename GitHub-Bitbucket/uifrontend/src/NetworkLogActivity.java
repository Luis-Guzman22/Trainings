import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.devtools.v91.network.model.Response;

import org.openqa.selenium.devtools.v91.network.model.Request;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		ChromeDriver driver1 = new ChromeDriver();
		ChromeDriver driver2 = new ChromeDriver();
		//log file ->
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	
		
		devTools.addListener(Network.requestWillBeSent(), request ->
		
				{
					Request req = request.getRequest();
					System.out.println(req.getUrl());
					//req.getHeaders()
					
				});
	
		//Event will get fired-
		devTools.addListener(Network.responseReceived(), response ->
		
		{
			Response res = response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+"is failing with status code"+res.getStatus());
			}
			
			
			
		});
	//do we need this?
//		driver.get("https://rahulshettyacademy.com/angularAppdemo");
//
//
//		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		
		
				
				
					
		
	}

}
