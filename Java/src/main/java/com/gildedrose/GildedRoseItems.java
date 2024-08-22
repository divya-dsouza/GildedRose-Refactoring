package com.gildedrose;

public enum GildedRoseItems {
    AGED_BRIE("Aged Brie"),
    SULFRAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"),
    NORMAL("Normal");

    public final String item;

    GildedRoseItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return this.getItem();
    }

    public static GildedRoseItems getEnum(String value) {
        for(GildedRoseItems v : values())
            if(v.getItem().equalsIgnoreCase(value)) return v;
        return NORMAL;
    }
}
