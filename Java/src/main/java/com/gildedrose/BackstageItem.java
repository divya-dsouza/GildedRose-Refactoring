package com.gildedrose;

public class BackstageItem implements QualityUpdater {

    @Override
    public void updateQuality(Item item) {
        QualityUpdater.checkQuantityAndIncrease(item);
        QualityUpdater.checkSellInAndIncreaseQuantity(item, 11);
        QualityUpdater.checkSellInAndIncreaseQuantity(item, 6);
        item.sellIn--;
        if (item.sellIn < 0)
            item.quality = 0;
    }


}
