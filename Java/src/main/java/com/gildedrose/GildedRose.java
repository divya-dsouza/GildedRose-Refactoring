package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    increaseQuality(item);
                    item.sellIn--;
                    checkSellInToIncrement(item, 0);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    increaseQuality(item);
                    checkSellInToIncrement(item, 11);
                    checkSellInToIncrement(item, 6);
                    item.sellIn--;

                    if (item.sellIn < 0)
                        item.quality = 0;
                    break;

                default:
                    boolean conjured = item.name.equals("Conjured Mana Cake");
                    decreaseQuality(item);
                    if (conjured)
                        decreaseQuality(item);
                    item.sellIn--;

                    if (item.sellIn < 0)
                        decreaseQualityToZero(item);
                    break;
            }
        }
    }

    public void updateQuality_v1() {
        for (Item item : items) {
            boolean incQualityItems = item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean conjured = item.name.equals("Conjured Mana Cake");
            boolean neutralItem = item.name.equals("Sulfuras, Hand of Ragnaros");

            if (incQualityItems) {
                boolean isBrie = item.name.equals("Aged Brie");
                increaseQuality(item);
                if (!isBrie) {
                    checkSellInToIncrement(item, 11);
                    checkSellInToIncrement(item, 6);
                    item.sellIn--;
                    if (item.sellIn < 0)
                        item.quality = 0;
                } else {
                    item.sellIn--;
                    checkSellInToIncrement(item, 0);
                }

            } else if (!neutralItem) {
                decreaseQuality(item);
                if (conjured)
                    decreaseQuality(item);
                item.sellIn--;

                if (item.sellIn < 0)
                    decreaseQualityToZero(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0)
            item.quality--;
    }

    private void decreaseQualityToZero(Item item) {
        if (item.quality > 0)
            item.quality--;
        else
            item.quality = 0;
    }

    private void checkSellInToIncrement(Item item, int sellDay) {
        if (item.sellIn < sellDay)
            increaseQuality(item);
    }
}
