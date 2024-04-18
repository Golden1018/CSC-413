/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.pkg413builderpatterndemo;

/**
 *
 * @author karunmehta
 * 
 *         (a) The BuilderPatternProduct below is the class of the object we
 *         want to construct a 'Product' entity.
 *         (b) Class ProductBuilder is the builder class that incrementally
 *         builds the 'Product' entity
 *         (c) In the test code, Product objects are created using the
 *         ProductBuilder by chaining calls to its buildWithX() methods and then
 *         calling build() to get the final Product object.
 */

// Product class
class BuilderPatternProduct {
    private String name;
    private String type;
    private double price;

    public BuilderPatternProduct(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name = '" + name + '\'' +
                ", type = '" + type + '\'' +
                ", price = $" + price +
                '}';
    }
}

// Builder class
class ProductBuilder {
    private String name;
    private String type;
    private double price;

    public ProductBuilder() {
    }

    public ProductBuilder buildWithName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder buildWithType(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder buildWithPrice(double price) {
        this.price = price;
        return this;
    }

    public BuilderPatternProduct build() {
        return new BuilderPatternProduct(name, type, price);
    }
}
