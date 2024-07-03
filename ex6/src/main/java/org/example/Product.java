package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String type;
    private String name;
    private int sellIn;
    private int quality;

    public void setQuality(int quality) {
        if(quality > 50)
            quality = 50;

        if(quality < 0)
            quality = 0;

        this.quality = quality;
    }
}
