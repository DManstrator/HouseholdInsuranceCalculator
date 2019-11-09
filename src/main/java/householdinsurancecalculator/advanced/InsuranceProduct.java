package householdinsurancecalculator.advanced;

/**
 * Enumeration representing the insurance products we sell.
 * @author DManstrator
 *
 */
public enum InsuranceProduct {
    
    /**
     * Compact Product. Costs 650 Euros per square meter.
     */
    COMPACT("Kompakt", 650),
    
    /**
     * Ideal Product. Costs 700 Euros per square meter.
     */
    IDEAL("Optimal", 700);
    
    /**
     * Readable name of the insurance product.
     */
    private final String productName;
    
    /**
     * Price per square meter.
     */
    private final int pricePerSquareMeter;
    
    /**
     * Defines an InsuranceProduct to be used to distinguish our insurance products.
     * @param productName         Name of the product
     * @param pricePerSquareMeter Price per square meter for that Insurance Product
     */
    InsuranceProduct(final String productName, final int pricePerSquareMeter)  {
        this.productName = productName;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }
    
    /**
     * Returns the name of the insurance product.
     * @return the name of the insurance product
     */
    public String getProductName()  {
        return productName;
    }
    
    /**
     * Returns the price of the insurance product in euros per square meter.
     * @return the price of the insurance product in euros per square meter
     */
    public int getPricePerSquaremeter()  {
        return pricePerSquareMeter;
    }
    
    /**
     * Gets an {@link InsuranceProduct} by its name. If the is not such a product, it will return <code>null</code>.
     * The comparison will be made case sensitive.
     * @param  name Name of the insurance product to find.
     * @return Possibly-null {@link InsuranceProduct} having the given name.
     */
    public static InsuranceProduct getInsuranceProductByName(final String name)  {
        return getInsuranceProductByName(name, false);
    }
    
    /**
     * Gets an {@link InsuranceProduct} by its name. If the is not such a product, it will return <code>null</code>.
     * @param  name       Name of the insurance product to find.
     * @param  ignoreCase Whether the comparison is case insensitive or not
     * @return Possibly-null {@link InsuranceProduct} having the given name.
     */
    public static InsuranceProduct getInsuranceProductByName(final String name, final boolean ignoreCase)  {
        for (InsuranceProduct p : values())  {
            String productName = p.getProductName();
            
            boolean cond;
            if (ignoreCase)  {
                cond = productName.equalsIgnoreCase(name);
            }  else  {
                cond = productName.equals(name);
            }
            
            if (cond) {
                return p;
            }
        }
        
        return null;
    }

}
