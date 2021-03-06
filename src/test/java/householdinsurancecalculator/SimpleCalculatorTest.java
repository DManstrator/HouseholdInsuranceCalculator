package householdinsurancecalculator;

import org.junit.Assert;

import householdinsurancecalculator.InsuranceProduct;

/**
 * Tests checking the functionality of the {@link SimpleCalculator}.
 * @author DManstrator
 *
 */
public class SimpleCalculatorTest extends Tests {
    
    /**
     * Instance of the calculator.
     */
    SimpleCalculator calculator = SimpleCalculator.getInstance();
    
    /**
     * {@inheritDoc}
     * Result should be 650 Euros * 20 square meters = 13,000 euros.
     */
    @Override
    public void testCompactWithTwentySquareMeter() {
        double insuranceSum = calculator.getInsuranceSum(InsuranceProduct.COMPACT, 20);
        Assert.assertEquals(13_000, insuranceSum, 0.0);
    }
    
    /**
     * {@inheritDoc}
     * Result should be 700 euros * 15 square meters = 10,500 euros.
     */
    @Override
    public void testIdealWithFifteenSquareMeter() {
        double insuranceSum = calculator.getInsuranceSum(InsuranceProduct.IDEAL, 15);
        Assert.assertEquals(10_500, insuranceSum, 0.0);
    }
    
    /**
     * {@inheritDoc}
     * Result should be 700 Euros * 10 square meters = 7,000 euros.
     */
    @Override
    public void testValidInsuranceProductNameWithTenSquareMeter() {
        double insuranceSum = calculator.getInsuranceSum("Optimal", 10);
        Assert.assertEquals(7_000, insuranceSum, 0.0);
    }
    
    /**
     * {@inheritDoc}
     * Result should be 650 Euros * 30 square meters = 19,500 euros.
     */
    @Override
    public void testValidLowercaseInsuranceProductNameWithThirtySquareMeter() {
        double insuranceSum = calculator.getInsuranceSum("kompakt", true, 30);
        Assert.assertEquals(19_500, insuranceSum, 0.0);
    }
    
    @Override
    public void testNoInsuranceProductWithTwentyFiveSquareMeter() {
        InsuranceProduct prod = null;  // else type is ambiguous
        calculator.getInsuranceSum(prod, 25);
    }
    
    @Override
    public void testUnknownInsuranceProductWithTwentyFiveSquareMeter() {
        calculator.getInsuranceSum(InsuranceProduct.UNKNOWN, 25);
    }
    
    @Override
    public void testInvalidInsuranceProductNameWithThirtyFiveSquareMeter() {
        calculator.getInsuranceSum("Invalid Name", 35);
    }
    
    @Override
    public void testNullProductNameWithZeroSquareMeter() {
        String name = null;  // else type is ambiguous
        calculator.getInsuranceSum(name, 0);
    }
    
    @Override
    public void testEmptyProductNameWithFiveSquareMeter() {
        calculator.getInsuranceSum("   ", 5);
    }
    
    @Override
    public void testCompactProductWithNegativeSquareMeter() {
        calculator.getInsuranceSum(InsuranceProduct.COMPACT, -5);
    }

}
