package net.nalpari.crawling.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nalpari.crawling.model.Article;
import net.nalpari.crawling.model.Person;
import net.nalpari.crawling.service.CrawlingService;
import net.nalpari.crawling.service.PersonService;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/crawling")
public class PersonController {

    private final PersonService service;
    private final CrawlingService crawlingService;

    @GetMapping("/test")
    public Person test() {
        Person result = service.findByName("abc");
        log.debug("### result: {}", result);
        return result;
    }

    @PostMapping("/save-test")
    public Person saveOneTest(@RequestBody Person param) {
        return service.save(param);
    }

    @GetMapping("/all-test")
    public List<Person> allTest() {
        return service.findAll();
    }

    @GetMapping("/api-bloter")
    public List<Article> exeCrawling() {
        Elements element = crawlingService.joupParser("http://www.bloter.net/archives/category/contents", ".category--body--main article");

        List<Article> result = new ArrayList<>();
        for(Element el : element) {
            Article param = new Article();
            String link = el.select(".general-article--title a").attr("href");
            String title = el.select(".general-article--title a").text();
            String picture = el.select(".picture img").attr("src");
            String summary = el.select("p.general-article--summary").text();
            String author = el.select(".general-article--meta .author").text();
            String publish = el.select(".general-article--meta .publish").text();

            param.getTitle().setText(title);
            param.getTitle().setLink(link);
            param.setPicture(picture);
            param.setSummary(summary);
            param.getMeta().setAuthor(author);
            param.getMeta().setPublish(publish);

            result.add(param);

            crawlingService.save(param);
        }

//        log.debug(result.toString());
        return result;
    }

    @GetMapping("/get-list")
    public List<Article> getList() {
        return crawlingService.getArticleList();
    }
}
