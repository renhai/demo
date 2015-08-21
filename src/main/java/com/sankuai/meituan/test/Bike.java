package com.sankuai.meituan.test;

public class Bike{
    private int weight;
    private int price;
    private int size;
    public static class Builder{
        private int weight;
        private int price;
        private int size;
        public Builder weight(int val){
            weight = val;
            return this;
        }
        public Builder price(int val){
            price = val;
            return this;
        }
        public Builder size(int val){
            size = val;
            return this;
        }
        public Bike build(){
            return new Bike(this);
        }
    }
    private Bike(Builder builder){
        weight = builder.weight;
        price = builder.price;
        size = builder.size;
    }
	public int getWeight() {
		return weight;
	}
	public int getPrice() {
		return price;
	}
	public int getSize() {
		return size;
	}
	@Override
	public String toString() {
		return "Bike [weight=" + weight + ", price=" + price + ", size=" + size
				+ "]";
	}
    
    
}
