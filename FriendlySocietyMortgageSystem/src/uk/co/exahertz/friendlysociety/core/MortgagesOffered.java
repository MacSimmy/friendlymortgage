package uk.co.exahertz.friendlysociety.core;

/**
 * Enumeration for all types of mortgages offered
 * 
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public enum MortgagesOffered {
    /** The rate of the mortgage is fixed for the first 2 years */
    FIXED_2YEARS,
    /** The rate of the mortgage is fixed for the first 5 years */
    FIXED_5YEARS,
    /**
     * The rate of the mortgage is variable (Bank Of England base rate + 2.5%)
     */
    VARIABLE_RATE,
    /** The mortgage rate is the same as the Bank Of England base rate */
    TRACKER;
}