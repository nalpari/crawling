package net.nalpari.crawling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nalpari.crawling.model.Article;
import net.nalpari.crawling.repository.ArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawlingService {

    private final ArticleRepository repository;

    public Elements joupParser(String targetUrl, String cssQuery) {
//        String url = "http://www.bloter.net/archives/category/contents";
        Document doc = null;

        try {
            doc = Jsoup.connect(targetUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Elements element = doc.select(".category--body--main article");
        Elements element = doc.select(cssQuery);

        return element;
    }

    public Article save(Article article) {
        return repository.save(article);
    }

    public List<Article> getArticleList() {
        return repository.findAll();
    }

    public static String convertEncodig(String reqStr) {
        String result = null;
        try {
            log.debug("### reqStr: {}", reqStr);
            byte[] euckrStringBuffer = reqStr.getBytes(Charset.forName("euc-kr"));
            String decodedFromEucKr = new String(euckrStringBuffer, "euc-kr");
            byte[] utf8StringBuffer = decodedFromEucKr.getBytes("utf-8");
            String decodedFromUtf8 = new String(utf8StringBuffer, "utf-8");
            log.debug("### resStr: {}", decodedFromUtf8);
            result = decodedFromUtf8;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
//        joupParser("http://www.yes24.com/24/Category/Display/001001003022", "clearfix");
    }
}
