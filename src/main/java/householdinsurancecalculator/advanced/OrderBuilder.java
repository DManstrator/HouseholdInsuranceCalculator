package householdinsurancecalculator.advanced;

import householdinsurancecalculator.advanced.impl.OrderImpl;
import householdinsurancecalculator.advanced.utils.Checks;

/**
 * Builder system used to build Orders.
 * @author DManstrator
 *
 */
public class OrderBuilder {
    
    /**
     * The {@link InsuranceProduct} used in this order.
     */
    private InsuranceProduct insuranceProduct;
    
    /**
     * The living space of this order.
     */
    private int livingSpace;
    
    /**
     * Creates a completely empty OrderBuilder.
     */
    public OrderBuilder() {}
    
    /**
     * Creates a OrderBuilder with a predefined InsuranceProduct.
     * @param insuranceProduct Insurance product of this order
     */
    public OrderBuilder(final InsuranceProduct insuranceProduct)  {
        this.insuranceProduct = insuranceProduct;
    }
    
    /**
     * Sets the insurance product of this order.
     * @param insuranceProduct Insurance product of this order
     * @return The OrderBuilder instance with an updated insurance product. Useful for chaining.
     */
    public OrderBuilder setInsuranceProduct(final InsuranceProduct insuranceProduct)  {
        this.insuranceProduct = insuranceProduct;
        return this;
    }
    
    /**
     * Sets the insurance product of this order given by the name of the product.
     * The search will be made case sensitive.
     * @param insuranceProductName Name of the insurance product of this order
     * @return The OrderBuilder instance with an updated insurance product. Useful for chaining.
     */
    public OrderBuilder setInsuranceProduct(final String insuranceProductName)  {
        return setInsuranceProduct(insuranceProductName, false);
    }
    
    /**
     * Sets the insurance product of this order given by the name of the product.
     * @param insuranceProductName Name of the insurance product of this order
     * @param ignoreCase           Whether the search is case insensitive or not 
     * @return The OrderBuilder instance with an updated insurance product. Useful for chaining.
     */
    public OrderBuilder setInsuranceProduct(final String insuranceProductName, final boolean ignoreCase)  {
        String field = "Insurance product name";
        Checks.notNull(insuranceProductName, field);
        Checks.notEmpty(insuranceProductName, field);
        
        this.insuranceProduct = InsuranceProduct.getInsuranceProductByName(insuranceProductName, ignoreCase);
        return this;
    }
    
    /**
     * Sets the living space of this order.
     * @param livingSpace Amount of square meters the order is covering
     * @return The OrderBuilder instance with an updated living space. Useful for chaining.
     */
    public OrderBuilder setLivingSpace(final int livingSpace)  {
        this.livingSpace = livingSpace;
        return this;
    }
    
    /**
     * Creates a {@link Order} object from this OrderBuilder.
     * @throws IllegalArgumentException If no insurance product was set for this order
     * @return the created order
     */
    public Order build()  {
        Checks.notNull(insuranceProduct, "Insurance product");
        Checks.isTrue(livingSpace >= 0, "The living space cannot be smaller than 0!");
        
        return new OrderImpl(insuranceProduct, livingSpace);
    }

}
