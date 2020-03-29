package net.nalpari.crawling.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Article {

    private String picture = "";
    private String summary = "";
    private Title title = new Title();
    private Meta meta = new Meta();

    @Data
    public class Title {
        String text = "";
        String link = "";
    }

    @Data
    public class Meta {
        String author = "";
        String publish = "";
    }
}
