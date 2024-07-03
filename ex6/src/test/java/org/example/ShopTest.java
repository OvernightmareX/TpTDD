package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {

    private Shop shop = new Shop();

    @Test
    public void ShopTest_WhenUpdate_SellIn_50_ThenResult_49(){
        Product product = Product.builder()
                .sellIn(50)
                .quality(50)
                .name("Chips")
                .type("normal")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(49, shop.getProducts().get(0).getSellIn());
    }

    @Test
    public void ShopTest_WhenUpdate_Quality_50_ThenResult_49(){
        Product product = Product.builder()
                .sellIn(50)
                .quality(50)
                .name("Chips")
                .type("normal")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(49, shop.getProducts().get(0).getQuality());
    }

    @Test
    public void ShopTest_WhenUpdate_SellIn_1_AndQuality_20_ThenQuality_18(){
        Product product = Product.builder()
                .sellIn(1)
                .quality(20)
                .name("Chips")
                .type("normal")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(18, shop.getProducts().get(0).getQuality());
    }

    @Test
    public void ShopTest_WhenUpdate_Quality_0_ThenQuality_0(){
        Product product = Product.builder()
                .sellIn(0)
                .quality(1)
                .name("Chips")
                .type("normal")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(0, shop.getProducts().get(0).getQuality());
    }

    @Test
    public void ShopTest_WhenAdd_QualityOver_50_ThenQuality_50(){
        Product product = Product.builder()
                .sellIn(10)
                .quality(70)
                .name("Chips")
                .type("normal")
                .build();

        shop.addProduct(product);

        Assertions.assertEquals(50, shop.getProducts().get(0).getQuality());
    }

    @Test
    public void ShopTest_WhenName_BrieVieilli_AndQuality_40_ThenQuality_41(){
        Product product = Product.builder()
                .sellIn(10)
                .quality(40)
                .name("Brie vieilli")
                .type("Laitier")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(41, shop.getProducts().get(0).getQuality());
    }

    @Test
    public void ShopTest_WhenType_Laitier_AndSellIn_10_AndQuality_40_ThenQuality_38(){
        Product product = Product.builder()
                .sellIn(10)
                .quality(40)
                .name("Lait")
                .type("Laitier")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(38, shop.getProducts().get(0).getQuality());
    }

    @Test
    public void ShopTest_WhenType_Laitier_AndSellIn_0_AndQuality_40_ThenQuality_36(){
        Product product = Product.builder()
                .sellIn(0)
                .quality(40)
                .name("Lait")
                .type("Laitier")
                .build();

        shop.addProduct(product);
        shop.update(product);

        Assertions.assertEquals(36, shop.getProducts().get(0).getQuality());
    }
}
