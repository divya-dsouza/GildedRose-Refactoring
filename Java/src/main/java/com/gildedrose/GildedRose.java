package com.gildedrose;

class GildedRose {
    Item[] items;
    ;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item.name).updateQuality(item);
        }
    }

    private QualityUpdater updateItem(String item) {
        GildedRoseItems gildedRoseItems = GildedRoseItems.getEnum(item);
        switch (gildedRoseItems) {
            case AGED_BRIE:
                return new QualityIncreasedItem();
            case SULFRAS:
                return new LegendaryItem();
            case BACKSTAGE:
                return new BackstageItem();
            case CONJURED:
                return new ConjuredItem();
            default:
                return new NormalItem();
        }
    }
}
