// A PhysicalProduct IS-A Product because it is a type of product that can be sold.
// A ShoppingCart is not a Product because it HAS-A collection of products.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable{

    private double weightKg;
    private String dimensions;
    private double discountedPrice;



    public PhysicalProduct() {
    }

    public PhysicalProduct(long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary(){
        return getName() + " is a physical product.";
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
