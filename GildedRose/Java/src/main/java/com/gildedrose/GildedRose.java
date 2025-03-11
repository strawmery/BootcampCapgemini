package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items){
            if(item.name.equals("Sulfuras, Hand of Ragnaros")){
                continue;
            }
            decreaseSellIn(item);
            switch(item.name){
                case "Aged Brie":
                    qualityAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    qualityBackstagePasses(item);
                    break;
                case "Conjured":
                    qualityConjured(item);
                    break;
                default:
                    qualityNormalItem(item);
                    break;
            }
        }
    }

    private void increaseQuality(Item item){
        if(item.quality < 50){
            item.quality++;
        }else{
            item.quality = 50;
        }
    }

    private void decreaseQuality(Item item){
        if(item.quality > 0){
            item.quality--;
        }else{
            item.quality = 0;
        }
    }

    private void decreaseSellIn(Item item){
        item.sellIn--;
    }

    private void qualityAgedBrie(Item item){
        increaseQuality(item);
        if(item.sellIn < 0){
            increaseQuality(item);
        }
    }

    private void qualityBackstagePasses(Item item){
        increaseQuality(item);
        if(item.sellIn <= 10) {
            increaseQuality(item);
        }
        if(item.sellIn <= 5){ 
            increaseQuality(item);
        }
        if(item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void qualityConjured (Item item){
        decreaseQuality(item);
        decreaseQuality(item);
        if(item.sellIn < 0){
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }

    private void qualityNormalItem(Item item){
        decreaseQuality(item);
        if(item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}
