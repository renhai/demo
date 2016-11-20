package me.renhai.spider;

import org.jsoup.Jsoup;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebMagicDemo implements PageProcessor {

    private Site site = Site.me().setDomain("rottentomatoes.com").setRetryTimes(5).setSleepTime(3000).setUserAgent(
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");;

    @Override
    public void process(Page page) {
    	if (page.getUrl().regex(".*/m/.*").match()) {
    		page.putField("link", page.getUrl().toString());
    		page.putField("script", page.getHtml().xpath("//script[@id='jsonLdSchema']/html()").get());
    		page.putField("title", page.getHtml().xpath("//div[@id='heroImageContainer']//h1/text()").get());
    		page.putField("movieSynopsis", page.getHtml().xpath("//div[@id='movieSynopsis']/text()").get());
    	} 
    	else if (page.getUrl().regex(".*/top/.*").match()) {
    		page.addTargetRequests(page.getHtml().links().regex(".*/m/.*").all());
    		page.addTargetRequests(page.getHtml().links().regex(".*/top/.*").all());
    		page.setSkip(true);
    	}
    }

    @Override
    public Site getSite() {
        return site;
    }
    
    public String getTitle(String url) {
        Spider spider = Spider.create(new WebMagicDemo())
        				.setDownloader(new SeleniumDownloader())
        				.thread(2);
        
        ResultItems resultItem = spider.<ResultItems>get(url);
        System.out.println(resultItem.<String>get("title"));
        System.out.println(resultItem.<String>get("movieSynopsis"));
        spider.close();
        return resultItem.<String>get("title");
    }

    public static void main(String[] args) {
//    	ResultItemsCollectorPipeline pipline = new ResultItemsCollectorPipeline();
        Spider.create(new WebMagicDemo())
//        		.setDownloader(new SeleniumDownloader())
        .addPipeline(new JsonFilePipeline("/Users/andy/Downloads"))
//        .addPipeline(new FilePipeline("/Users/andy/Downloads"))
//        .addPipeline(pipline)
        .addUrl("https://www.rottentomatoes.com/top/")
//        .addUrl("https://www.rottentomatoes.com/m/brooklyn/")
        .thread(3)
        .run();
        
//        List<ResultItems> resultItemsList = pipline.getCollected();
//        for (ResultItems items : resultItemsList) {
//            String title = items.get("title");
//            String movieSynopsis = items.get("movieSynopsis");
//            System.out.println(title + "->" + movieSynopsis);
//        }
    }


}
