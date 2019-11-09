package householdinsurancecalculator.advanced;

/**
 * Represents an Order of our company.
 * @author DManstrator
 *
 */
public interface Order {
    
    /**
     * The {@link InsuranceProduct} of this order.
     * @return Never-Null insurance product of this order
     */
    InsuranceProduct getInsuranceProduct();
    
    /**
     * The living space of this order.
     * @return the living space of this order
     */
    int getLivingSpace();
    
    /**
     * Calculates the amount insured for this order.
     * The price is determined as <code>price per square meter * amount of square meters</code>.
     * @return The amount insured for this order.
     */
    default int getInsuranceSum()  {
        return getInsuranceProduct().getPricePerSquaremeter() * getLivingSpace();
    }

}
