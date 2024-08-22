package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void quality_degrades_everyday() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void brie_increase_in_quality_older_it_gets() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void brie_quality_is_never_more_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", -24, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-25, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void sulfuras_never_sold_or_decreases_in_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void backstage_quality_increases() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
        System.out.println(app.items[0]);
    }

    @Test
    void backstage_quality_never_increases_beyond_50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        System.out.println(app.items[0]);
    }

    @Test
    void backstage_quality_increases_by_2_for_10_days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(27, app.items[0].quality);
        System.out.println(app.items[0]);
    }

    @Test
    void backstage_quality_increases_by_3_for_5_days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(38, app.items[0].quality);
        System.out.println(app.items[0]);
    }

    @Test
    void backstage_quality_drops_to_0_after_concert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void conjured_items_degrade_twice_as_fast_as_normal_items() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void quality_is_never_negative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        System.out.println(app.items[0]);
    }

    @Test
    void quality_degrades_twice_as_fast_post_sell_date() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);

        System.out.println(app.items[0]);
    }
}
