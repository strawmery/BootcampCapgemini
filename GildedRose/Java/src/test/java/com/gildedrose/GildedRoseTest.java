package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateQuality(){
        Item[] items = new Item[] { new Item("foo", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQualityNegative(){
        Item[] items = new Item[] { new Item("foo", 2, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(-1, app.items[0].quality);
    }

    @Test
    void updateQuality50(){
        Item[] items = new Item[] { new Item("foo", 2, 51)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertNotEquals(51, app.items[0].quality);
        assertEquals(50, app.items[0].quality);

    }

    @Test
    void updateQualityPastSellin(){
        Item[] items = new Item[] { new Item("foo", 0, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);

    }

    @Test
    void updateQualityPastSellinNegative(){
        Item[] items = new Item[] { new Item("foo", 0, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(-1, app.items[0].quality);

    }

    @Test
    void updateQuality_ItemNormal_ShouldDecreaseQualityAndSellIn() {
        Item[] items = new Item[] { new Item("Normal Item", 2, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void updateQuality_ItemNormal_ShouldNotHaveNegativeQuality() {
        Item[] items = new Item[] { new Item("Normal Item", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQualityAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQualityAgedBriePastSellin(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void updateQuality_BackstagePasses_ShouldIncreaseQualityBy3_When5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateQuality_Sulfuras_ShouldNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQualitySulfuras(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQualitySulfurasPassSellin(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePasses10(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePasses5(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void updateQualityBackstagePasses0(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
