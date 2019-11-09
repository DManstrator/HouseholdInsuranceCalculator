package householdinsurancecalculator;

import org.junit.Assert;
import org.junit.Test;

import householdinsurancecalculator.advanced.InsuranceProduct;

/**
 * Tests checking the functionality of the InsuranceProduct.
 * @author DManstrator
 *
 */
public class InsuranceProductTest {
    
    /**
     * Tests getting an insurance product which doesn't exist at all.
     * Result should be <code>null</code>.
     */
    @Test
    public void testIllegalName() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.getInsuranceProductByName("Illegal Name", true);
        Assert.assertEquals(null, insuranceProductByName);
    }
    
    /**
     * Tests getting an insurance product searching case sensitive which exist.
     * Result should be {@link InsuranceProduct#COMPACT}.
     */
    @Test
    public void testCorrectName() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.getInsuranceProductByName("Kompakt");
        Assert.assertEquals(InsuranceProduct.COMPACT, insuranceProductByName);
    }
    
    /**
     * Tests getting an insurance product searching case insensitive which exist only case sensitive.
     * Result should be <code>null</code>.
     */
    @Test
    public void testCorrectNameInWrongCase() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.getInsuranceProductByName("kompakt");
        Assert.assertEquals(null, insuranceProductByName);
    }
    
    /**
     * Tests getting an insurance product searching case insensitive which exist.
     * Result should be {@link InsuranceProduct#IDEAL}.
     */
    @Test
    public void testCorrectNameLowerCase() {
        InsuranceProduct insuranceProductByName = InsuranceProduct.getInsuranceProductByName("optimal", true);
        Assert.assertEquals(InsuranceProduct.IDEAL, insuranceProductByName);
    }

}
