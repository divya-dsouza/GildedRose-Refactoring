package com.gildedrose;

public class ConjuredItem implements QualityUpdater {

    @Override
    public void updateQuality(Item item) {
        QualityUpdater.checkQuantityAndDecrease(item, 2);
        item.sellIn--;
        QualityUpdater.checkSellInAndDecreaseQuantity(item);
    }




}
