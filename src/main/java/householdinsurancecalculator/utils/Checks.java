package householdinsurancecalculator.utils;

/**
 * Utility class checking for several things.
 * @author DManstrator
 *
 */
public class Checks {
    
    // private constructor to prohibit instantiation
    private Checks() {}
    
    /**
     * Checks whether the given Object is <code>null</code> or not.
     * @param  o
     *         Object to check
     * @param  field
     *         Name of the field which may not be <code>null</code>
     * @throws IllegalArgumentException
     *         if the given Object is <code>null</code>
     */
    public static void notNull(final Object o, final String field)  {
        if (o == null)  {
            throw new IllegalArgumentException(field + " may not be null!");
        }
    }
    
    /**
     * Checks for a given expression. 
     * @param  expression
     *         Expression to check
     * @param  message
     *         Message to output if the expression isn't <code>true</code>
     * @throws IllegalArgumentException
     *         if the given expression isn't <code>true</code>
     */
    public static void check(final boolean expression, final String message) {
        if (!expression)  {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * Checks whether a given String is empty or not.
     * @param  value
     *         The string to check on
     * @param  field
     *         The field which may not be empty
     * @throws IllegalArgumentException
     *         if the given string is empty
     */
    public static void notEmpty(final String value, final String field)  {
        if (value.trim().isEmpty())  {
            throw new IllegalArgumentException(field + " may not be empty!");
        }
    }

}
