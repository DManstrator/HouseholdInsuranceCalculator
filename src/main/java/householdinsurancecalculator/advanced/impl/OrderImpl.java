package householdinsurancecalculator.advanced.impl;

import householdinsurancecalculator.advanced.InsuranceProduct;
import householdinsurancecalculator.advanced.Order;

/**
 * Default implementation for an Order in our system.
 * @author DManstrator
 *
 */
public class OrderImpl implements Order {
    
    /**
     * Insurance product used in this order.
     */
    private final InsuranceProduct insuranceProduct;
    
    /**
     * Living space in square meters covered with this order.
     */
    private final int livingSpace;
    
    /**
     * Defines the implementation for an {@link Order} used in our company.
     * @param insuranceProduct Insurance product for this order
     * @param livingSpace      Amount of square meters for this order
     */
    public OrderImpl(final InsuranceProduct insuranceProduct, final int livingSpace)  {
        this.insuranceProduct = insuranceProduct;
        this.livingSpace = livingSpace;
    }

    @Override
    public InsuranceProduct getInsuranceProduct() {
        return insuranceProduct;
    }

    @Override
    public int getLivingSpace() {
        return livingSpace;
    }

}
