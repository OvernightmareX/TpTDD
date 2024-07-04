package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Shop {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        if(product.getQuality() > 50)
            product.setQuality(50);

        products.add(product);
    }

    public void update(Product productToUpdate) {
        Product productFound = products.stream()
                .filter(productSearched -> productSearched.equals(productToUpdate))
                .findFirst()
                .orElse(null);

        if(productFound == null)
            return;

        int coeffQuality = 1;
        productFound.setSellIn(productFound.getSellIn() - 1);

        if(productFound.getName().equals("Brie vieilli"))
            productFound.setQuality(productFound.getQuality() + coeffQuality);
        else
        {
            if(productFound.getType().equals("Laitier"))
                coeffQuality *= 2;

            if(productFound.getSellIn() <= 0)
                coeffQuality *= 2;

            productFound.setQuality(productFound.getQuality() - coeffQuality);
        }

    }
}
