package householdinsurancecalculator.simple;

import householdinsurancecalculator.advanced.InsuranceProduct;

/**
 * A very simple way of getting the amount assured without the builder pattern / own classes.
 * @author DManstrator
 *
 */
public class SimpleCalculator {
    
    // Singleton Pattern
    /**
     * Instance of the Calculator.
     */
    private final static SimpleCalculator instance = new SimpleCalculator();
    
    // private constructor to prohibit instantiation
    private SimpleCalculator() {}
    
    /**
     * Gets the Calculator instance.
     * @return the {@link SimpleCalculator} instance
     */
    public static SimpleCalculator getInstance()  {
        return instance;
    }
    // Singleton Pattern end
    
    /**
     * Calculates the amount insured for this order. The search will be case sensitive.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @param insuranceProductName      Name of the insurance product this calculation is based on
     * @param livingSpace               The amount of square meters this calculation is based on
     * @throws IllegalArgumentException if the insurance product name doesn't belong to an {@link InsuranceProduct}
     *                                  or the living space is smaller than 0
     * @return The amount insured for this order
     */
    public int getInsuranceSum(final String insuranceProductName, final int livingSpace) throws IllegalArgumentException  {
        return getInsuranceSum(insuranceProductName, false, livingSpace);
    }
    
    /**
     * Calculates the amount insured for this order.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @param insuranceProductName      Name of the insurance product this calculation is based on
     * @param ignoreCase                Whether the search is case insensitive or not 
     * @param livingSpace               The amount of square meters this calculation is based on
     * @throws IllegalArgumentException if the insurance product name doesn't belong to an {@link InsuranceProduct}
     *                                  or the living space is smaller than 0
     * @return The amount insured for this order
     */
    public int getInsuranceSum(final String insuranceProductName, final boolean ignoreCase, final int livingSpace)
            throws IllegalArgumentException  {
        if (insuranceProductName == null)  {
            throw new IllegalArgumentException("The insurance product name may not be null!");
        }
        return getInsuranceSum(InsuranceProduct.getInsuranceProductByName(insuranceProductName, ignoreCase), livingSpace);
    }
    
    /**
     * Calculates the amount insured for this order.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @param insuranceProduct The insurance product this calculation is based on
     * @param livingSpace The amount of square meters this calculation is based on
     * @throws IllegalArgumentException if the insurance product is null
     *                                  or the living space is smaller than 0
     * @return The amount insured for this order
     */
    public int getInsuranceSum(final InsuranceProduct insuranceProduct, final int livingSpace) throws IllegalArgumentException  {
        if (insuranceProduct == null)  {
            throw new IllegalArgumentException("The insurance product may not be null!");
        }
        if (livingSpace < 0)  {
            throw new IllegalArgumentException("The living space cannot be smaller than 0!");
        }
        return insuranceProduct.getPricePerSquaremeter() * livingSpace;
    }

}