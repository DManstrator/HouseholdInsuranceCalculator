package householdinsurancecalculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests checking the functionality of the {@link InsuranceProduct}.
 * @author DManstrator
 *
 */
public class InsuranceProductTest {
    
    /**
     * Tests getting an insurance product which doesn't exist at all.
     * Result should be {@link InsuranceProduct#UNKNOWN}.
     */
    @Test
    public void testIllegalName() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.of("Illegal Name", true);
        Assert.assertEquals(InsuranceProduct.UNKNOWN, insuranceProductByName);
    }
    
    /**
     * Tests getting an insurance product searching case sensitive which exist.
     * Result should be {@link InsuranceProduct#COMPACT}.
     */
    @Test
    public void testCorrectName() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.of("Kompakt");
        Assert.assertEquals(InsuranceProduct.COMPACT, insuranceProductByName);
    }
    
    /**
     * Tests getting an insurance product searching case insensitive which exist only case sensitive.
     * Result should be {@link InsuranceProduct#UNKNOWN}.
     */
    @Test
    public void testCorrectNameInWrongCase() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.of("kompakt");
        Assert.assertEquals(InsuranceProduct.UNKNOWN, insuranceProductByName);
    }
    
    /**
     * Tests getting an insurance product searching case insensitive which exist.
     * Result should be {@link InsuranceProduct#IDEAL}.
     */
    @Test
    public void testCorrectNameLowerCase() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.of("optimal", true);
        Assert.assertEquals(InsuranceProduct.IDEAL, insuranceProductByName);
    }

}
