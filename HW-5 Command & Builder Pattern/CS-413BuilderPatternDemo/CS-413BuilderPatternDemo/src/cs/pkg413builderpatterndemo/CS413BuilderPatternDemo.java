/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs.pkg413builderpatterndemo;

/**
 *
 * @author karunmehta
 */
public class CS413BuilderPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Test using the builder to construct the object
        BuilderPatternProduct product1 = new ProductBuilder()
                .buildWithName("Product 1")
                .buildWithType("Type 1")
                .buildWithPrice(10)
                .build();

        BuilderPatternProduct product2 = new ProductBuilder()
                .buildWithName("Product 2")
                .buildWithType("Type 2")
                .buildWithPrice(20)
                .build();

        // Printing the products
        System.out.println(product1);
        System.out.println(product2);
    }
}
