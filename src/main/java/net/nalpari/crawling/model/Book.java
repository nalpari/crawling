package net.nalpari.crawling.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String goodsImg;
    private String goodsName;
    private String goodsAuth;
    private String goodsDate;
    private String goodsPub;
    private String goodsPrice;
}