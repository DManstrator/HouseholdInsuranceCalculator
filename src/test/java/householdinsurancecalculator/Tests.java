package householdinsurancecalculator;

import org.junit.Test;

/**
 * Abstract class defining all Tests verifying the functionality of the program.
 * @author DManstrator
 *
 */
public abstract class Tests {
    
    /**
     * Tests a compact insurance product with 20 square meters.
     * Result should be 650 Euros * 20 square meters = 13,000 euros.
     */
    @Test
    abstract public void testCompactWithTwentySquareMeter();
    
    /**
     * Tests an ideal insurance product with 15 square meters.
     * Result should be 700 euros * 15 square meters = 10,500 euros.
     */
    @Test
    abstract public void testIdealWithFifteenSquareMeter();
    
    /**
     * Tests an ideal insurance product name with 10 square meters by its name.
     * Result should be 700 Euros * 10 square meters = 7,000 euros.
     */
    @Test
    abstract public void testValidInsuranceProductNameWithTenSquareMeter();
    
    /**
     * Tests a compact insurance product name in lowercase with 30 square meters by its name.
     * Result should be 650 Euros * 30 square meters = 19,500 euros.
     */
    @Test
    abstract public void testValidLowercaseInsuranceProductNameWithThirtySquareMeter();
    
    /**
     * Tests if an {@link IllegalArgumentException} is thrown if no insurance product was passed.
     */
    @Test(expected=IllegalArgumentException.class)
    abstract public void testNoInsuranceProductWithTwentyFiveSquareMeter();
    
    /**
     * Tests if an {@link IllegalArgumentException} is thrown if an invalid insurance product name was passed.
     */
    @Test(expected=IllegalArgumentException.class)
    abstract public void testInvalidInsuranceProductNameWithThirtyFiveSquareMeter();
    
    /**
     * Tests if an {@link IllegalArgumentException} is thrown if <code>null</code> was passed as the product name.
     */
    @Test(expected=IllegalArgumentException.class)
    abstract public void testNullProductNameWithZeroSquareMeter();
    
    /**
     * Tests if an {@link IllegalArgumentException} is thrown if the passed product name was empty.
     */
    @Test(expected=IllegalArgumentException.class)
    abstract public void testEmptyProductNameWithFiveSquareMeter();
    
    /**
     * Tests if an {@link IllegalArgumentException} is thrown if a negative living space was passed.
     */
    @Test(expected=IllegalArgumentException.class)
    abstract public void testCompactProductWithNegativeSquareMeter();

}