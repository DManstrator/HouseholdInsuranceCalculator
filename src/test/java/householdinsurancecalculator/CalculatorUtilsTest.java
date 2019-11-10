package householdinsurancecalculator;

import org.junit.Assert;

import householdinsurancecalculator.InsuranceProduct;
import householdinsurancecalculator.utils.CalculatorUtils;

/**
 * Tests checking the functionality of the CalulatorUtils.
 * @author DManstrator
 *
 */
public class CalculatorUtilsTest extends Tests {
    
    @Override
    public void testCompactWithTwentySquareMeter() {
        int insuranceSum = CalculatorUtils.getInsuranceSum(InsuranceProduct.COMPACT, 20);
        Assert.assertEquals(13_000, insuranceSum);
    }

    @Override
    public void testIdealWithFifteenSquareMeter() {
        int insuranceSum = CalculatorUtils.getInsuranceSum(InsuranceProduct.IDEAL, 15);
        Assert.assertEquals(10_500, insuranceSum);
    }
    
    @Override
    public void testValidInsuranceProductNameWithTenSquareMeter() {
        int insuranceSum = CalculatorUtils.getInsuranceSum("Optimal", 10);
        Assert.assertEquals(7_000, insuranceSum);
    }
    
    @Override
    public void testValidLowercaseInsuranceProductNameWithThirtySquareMeter() {
        int insuranceSum = CalculatorUtils.getInsuranceSum("kompakt", true, 30);
        Assert.assertEquals(19_500, insuranceSum);
    }

    @Override
    public void testNoInsuranceProductWithTwentyFiveSquareMeter() {
        InsuranceProduct prod = null;  // else type is ambiguous
        CalculatorUtils.getInsuranceSum(prod, 25);
    }

    @Override
    public void testUnknownInsuranceProductWithTwentyFiveSquareMeter() {
        CalculatorUtils.getInsuranceSum(InsuranceProduct.UNKNOWN, 25);
    }
    
    @Override
    public void testInvalidInsuranceProductNameWithThirtyFiveSquareMeter() {
        CalculatorUtils.getInsuranceSum("Invalid Name", 35);
    }

    @Override
    public void testNullProductNameWithZeroSquareMeter() {
        String name = null;  // else type is ambiguous
        CalculatorUtils.getInsuranceSum(name, 0);
    }
    
    @Override
    public void testEmptyProductNameWithFiveSquareMeter() {
        CalculatorUtils.getInsuranceSum("   ", 5);
    }
    
    @Override
    public void testCompactProductWithNegativeSquareMeter() {
        CalculatorUtils.getInsuranceSum(InsuranceProduct.COMPACT, -5);
    }

}
