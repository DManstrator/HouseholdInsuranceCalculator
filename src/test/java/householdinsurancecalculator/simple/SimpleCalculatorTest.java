package householdinsurancecalculator.simple;

import org.junit.Assert;

import householdinsurancecalculator.advanced.InsuranceProduct;
import householdinsurancecalculator.Tests;
import householdinsurancecalculator.simple.SimpleCalculator;

/**
 * Tests checking the functionality of the SimpleCalulator.
 * @author DManstrator
 *
 */
public class SimpleCalculatorTest extends Tests {
    
    /**
     * Calculator instance.
     */
    private final SimpleCalculator calculator = SimpleCalculator.getInstance();

    @Override
    public void testCompactWithTwentySquareMeter() {
        int insuranceSum = calculator.getInsuranceSum(InsuranceProduct.COMPACT, 20);
        Assert.assertEquals(13_000, insuranceSum);
    }

    @Override
    public void testIdealWithFifteenSquareMeter() {
        int insuranceSum = calculator.getInsuranceSum(InsuranceProduct.IDEAL, 15);
        Assert.assertEquals(10_500, insuranceSum);
    }
    
    @Override
    public void testValidInsuranceProductNameWithTenSquareMeter() {
        int insuranceSum = calculator.getInsuranceSum("Optimal", 10);
        Assert.assertEquals(7_000, insuranceSum);
    }
    
    @Override
    public void testValidLowercaseInsuranceProductNameWithThirtySquareMeter() {
        int insuranceSum = calculator.getInsuranceSum("kompakt", true, 30);
        Assert.assertEquals(19_500, insuranceSum);
    }

    @Override
    public void testNoInsuranceProductWithTwentyFiveSquareMeter() {
        InsuranceProduct prod = null;  // else type is ambiguous
        calculator.getInsuranceSum(prod, 25);
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
