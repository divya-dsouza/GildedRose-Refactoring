package com.gildedrose;

public interface QualityUpdater {

    void updateQuality(Item item);

    static void checkQuantityAndDecrease(Item item, int decreaseBy) {
        if (item.quality > 0)
            item.quality = item.quality - decreaseBy;
    }

    static void checkQuantityAndIncrease(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    static void checkSellInAndIncreaseQuantity(Item item, int sellDays) {
        if (item.sellIn < sellDays)
            checkQuantityAndIncrease(item);
    }

    static void checkSellInAndDecreaseQuantity(Item item) {
        if (item.sellIn < 0)
            decreaseQualityToZero(item);
    }

    static void decreaseQualityToZero(Item item) {
        if (item.quality > 0)
            item.quality--;
        else
            item.quality = 0;
    }
}
