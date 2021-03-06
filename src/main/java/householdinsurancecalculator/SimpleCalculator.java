package householdinsurancecalculator;

import householdinsurancecalculator.InsuranceProduct;
import householdinsurancecalculator.utils.Checks;

/**
 * A very simple way of getting the amount assured.
 * @author DManstrator
 *
 */
public class SimpleCalculator {
    
    /**
     * Instance of the Calculator.
     */
    private static final SimpleCalculator instance = new SimpleCalculator();
    
    // protected constructor to prohibit instantiation
    protected SimpleCalculator() {}
    
    /**
     * Gets the Calculator instance.
     * @return the {@link SimpleCalculator} instance
     */
    public static SimpleCalculator getInstance()  {
        return instance;
    }
    
    /**
     * Calculates the amount insured for this order. The search after the name will be case sensitive.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @param  insuranceProductName
     *         Name of the insurance product this calculation is based on
     * @param  livingSpace
     *         The amount of square meters this calculation is based on
     * @throws IllegalArgumentException
     *         <ul>
     *           <li>if the insurance product name is <code>null</code></li>
     *           <li>if the insurance product name is empty</li>
     *           <li>if the insurance product name doesn't belong to an {@link InsuranceProduct}</li>
     *           <li>if the living space is smaller than 0</li>
     *         </ul>
     * @return The amount insured for this order
     */
    public double getInsuranceSum(final String insuranceProductName, final int livingSpace) throws IllegalArgumentException  {
        return getInsuranceSum(insuranceProductName, false, livingSpace);
    }
    
    /**
     * Calculates the amount insured for this order.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @param  insuranceProductName
     *         Name of the insurance product this calculation is based on
     * @param  ignoreCase
     *         Whether the search is case insensitive or not
     * @param  livingSpace
     *         The amount of square meters this calculation is based on
     * @throws IllegalArgumentException
     *         <ul>
     *           <li>if the insurance product name is <code>null</code></li>
     *           <li>if the insurance product name is empty</li>
     *           <li>if the insurance product name doesn't belong to an {@link InsuranceProduct}</li>
     *           <li>if the living space is smaller than 0</li>
     *         </ul>
     * @return The amount insured for this order
     */
    public double getInsuranceSum(final String insuranceProductName, final boolean ignoreCase, final int livingSpace)
            throws IllegalArgumentException  {
        String field = "The insurance product name";
        
        Checks.notNull(insuranceProductName, field);
        Checks.notEmpty(insuranceProductName, field);
        return getInsuranceSum(InsuranceProduct.of(insuranceProductName, ignoreCase), livingSpace);
    }
    
    /**
     * Calculates the amount insured for this order.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @param  insuranceProduct
     *         The insurance product this calculation is based on
     * @param  livingSpace
     *         The amount of square meters this calculation is based on
     * @throws IllegalArgumentException
     *         <ul>
     *           <li>if the insurance product is <code>null</code></li>
     *           <li>if the insurance product is {@link InsuranceProduct#UNKNOWN}</li>
     *           <li>if the living space is smaller than 0</li>
     *         </ul>
     * @return The amount insured for this order
     */
    public double getInsuranceSum(final InsuranceProduct insuranceProduct, final int livingSpace) throws IllegalArgumentException  {
        Checks.notNull(insuranceProduct, "The insurance product");
        Checks.check(insuranceProduct != InsuranceProduct.UNKNOWN, "The given insurance product was unknown!");
        Checks.check(livingSpace >= 0, "The living space cannot be smaller than 0!");
        return insuranceProduct.getPricePerSquaremeter() * livingSpace;
    }

}