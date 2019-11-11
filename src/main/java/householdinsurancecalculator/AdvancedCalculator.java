package householdinsurancecalculator;

/**
 * A more advanced way of getting the amount assured (an example calculating 10% off showing the extensibility).
 * @author DManstrator
 *
 */
public class AdvancedCalculator extends SimpleCalculator {
    
    /**
     * Instance of the Calculator.
     */
    private static final AdvancedCalculator instance = new AdvancedCalculator();
    
    // protected constructor to prohibit instantiation
    protected AdvancedCalculator() {
        super();
    }
    
    /**
     * Gets the Calculator instance.
     * @return the {@link AdvancedCalculator} instance
     */
    public static AdvancedCalculator getInstance()  {
        return instance;
    }
    
    /**
     * Calculates the amount insured for this order.
     * The price is determined as <code>(price per square meter * amount of square meters) * 90%</code>.
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
    @Override
    public double getInsuranceSum(InsuranceProduct insuranceProduct, int livingSpace) throws IllegalArgumentException {
        return super.getInsuranceSum(insuranceProduct, livingSpace) * 0.9;
    }

}
