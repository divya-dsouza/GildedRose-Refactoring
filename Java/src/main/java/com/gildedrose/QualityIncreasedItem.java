package com.gildedrose;

public class QualityIncreasedItem implements QualityUpdater {

    @Override
    public void updateQuality(Item item) {
        QualityUpdater.checkQuantityAndIncrease(item);
        item.sellIn--;
        QualityUpdater.checkSellInAndIncreaseQuantity(item, 0);
    }
}
