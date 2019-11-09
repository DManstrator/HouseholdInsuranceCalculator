package householdinsurancecalculator.advanced;

import org.junit.Assert;

import householdinsurancecalculator.advanced.InsuranceProduct;
import householdinsurancecalculator.advanced.Order;
import householdinsurancecalculator.advanced.OrderBuilder;
import householdinsurancecalculator.Tests;

/**
 * Tests checking the functionality of the OrderBuilder and the Order itself.
 * @author DManstrator
 *
 */
public class OrderTest extends Tests {

    @Override
    public void testCompactWithTwentySquareMeter() {
        Order order = new OrderBuilder(InsuranceProduct.COMPACT).setLivingSpace(20).build();
        Assert.assertEquals(13_000, order.getInsuranceSum());
    }

    @Override
    public void testIdealWithFifteenSquareMeter() {
        Order order = new OrderBuilder().setInsuranceProduct(InsuranceProduct.IDEAL).setLivingSpace(15).build();
        Assert.assertEquals(10_500, order.getInsuranceSum());
    }
    
    @Override
    public void testValidInsuranceProductNameWithTenSquareMeter() {
        Order order = new OrderBuilder().setInsuranceProduct("Optimal").setLivingSpace(10).build();
        Assert.assertEquals(7_000, order.getInsuranceSum());
    }
    
    @Override
    public void testValidLowercaseInsuranceProductNameWithThirtyfiveSquareMeter() {
        Order order = new OrderBuilder().setInsuranceProduct("kompakt", true).setLivingSpace(35).build();
        Assert.assertEquals(22_750, order.getInsuranceSum());
    }

    @Override
    public void testNoInsuranceProductWithTwentyFiveSquareMeter() {
        new OrderBuilder().setLivingSpace(25).build();
    }
    
    @Override
    public void testInvalidInsuranceProductNameWithThirtyFiveSquareMeter() {
        new OrderBuilder().setInsuranceProduct("Invalid Name").setLivingSpace(30).build();
    }
    
    @Override
    public void testNullProductNameWithZeroSquareMeter() {
        String name = null;  // else type is ambiguous
        new OrderBuilder().setInsuranceProduct(name).setLivingSpace(30).build();
    }
    
    @Override
    public void testEmptyProductNameWithFiveSquareMeter() {
        new OrderBuilder().setInsuranceProduct("   ").setLivingSpace(30).build();
    }

    @Override
    public void testCompactProductWithNegativeSquareMeter() {
        new OrderBuilder().setInsuranceProduct(InsuranceProduct.COMPACT).setLivingSpace(-5).build();
    }



}
