package com.ir.learning.poc.designpattern.builder;

public class Cake {
	
	private final float milk;
	private final float sugar;
	private final int egg;
	private final float bakingPowder;
	private final float chocolate;
	
	private Cake(CakeBuilder builder) {
		super();
		this.milk = builder.milk;
		this.sugar = builder.sugar;
		this.egg = builder.egg;
		this.bakingPowder = builder.bakingPowder;
		this.chocolate = builder.chocolate;
	}
	
	public float getMilk() {
		return milk;
	}



	public float getSugar() {
		return sugar;
	}



	public int getEgg() {
		return egg;
	}



	public float getBakingPowder() {
		return bakingPowder;
	}



	public float getChocolate() {
		return chocolate;
	}
	
	@Override
	public String toString() {
		return "Milk: " + this.milk + ", Sugar: " + this.sugar + ", Egg: " + this.egg + ", BakingPowder: " + this.bakingPowder
				+ ", Chocolate: " + this.chocolate;
	}



	public static class CakeBuilder {
		private  float milk;
		private  float sugar;
		private  int egg;
		private  float bakingPowder;
		private  float chocolate;
		
		public CakeBuilder() {
			
		}
		
		public CakeBuilder milk(float milk) {
			this.milk = milk;
			return this;
		}
		
		public CakeBuilder sugar(float sugar) {
			this.sugar = sugar;
			return this;
		}
		
		public CakeBuilder egg(int egg) {
			this.egg = egg;
			return this;
		}
		
		public CakeBuilder bakingPowder(float bakingPowder) {
			this.bakingPowder = bakingPowder;
			return this;
		}
		
		public CakeBuilder chocolate(float chocolate) {
			this.chocolate = chocolate;
			return this;
		}
		
		public Cake build() {
			Cake cake = new Cake(this);
			return cake;
		}
		
		
	}
	
	

}
