package me.renhai.spider;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;

public class RTSpider {

	public static void main(String[] args) {

	}
	public void testHtmlUnit() {
	    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45)) {
//	        final HtmlPage page = webClient.getPage("https://www.rottentomatoes.com/search/?search=" + "saving private ryan");
//	        HtmlElement ele = page.getFirstByXPath("//section[@id='SummaryResults']");
//	        System.out.println(ele.asText());
	        
	        final Page page = webClient.getPage("https://www.rottentomatoes.com/api/private/v1.0/search/?catCount=2&q=saving private");
	        WebResponse response = page.getWebResponse();
	        if (response.getContentType().equals("application/json")) {
	            String json = response.getContentAsString();
	            System.out.println(json);
	        }

	        
	    } catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
