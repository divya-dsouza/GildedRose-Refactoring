package com.gildedrose;

public class NormalItem implements QualityUpdater {

    @Override
    public void updateQuality(Item item) {
        QualityUpdater.checkQuantityAndDecrease(item, 1);
        item.sellIn--;
        QualityUpdater.checkSellInAndDecreaseQuantity(item);
    }
}
