package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * The Survey class contains information on a survey carried out on a property
 * 
 * @author Guillaume Pasquet
 * @version 0.0.2
 * @since 0.0.1
 */
public class Survey {
    private int surveyID;
    private Surveyor surveyor;
    private GregorianCalendar surveyDate;
    private float propertyValue;
    
    /**
     * Create a new instance of a survey. Once a survey has been created, it's
     * contents cannot be modified
     *
     * @param surveyID The unique ID of the survey
     * @param surveyor The surveyor who conducted the survey
     * @param surveyDate The date the survey was undertaken
     * @param propertyValue The value of the property at the time of the survey
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Survey(final int surveyID, final Surveyor surveyor,
            final GregorianCalendar surveyDate, final float propertyValue)
            throws IllegalArgumentException
    {
        checkSurveyID(surveyID);
        checkSurveyor(surveyor);
        checkSurveyDate(surveyDate);
        checkPropertyValue(propertyValue);
        
        this.surveyID = surveyID;
        this.surveyor = surveyor;
        this.surveyDate = surveyDate;
        this.propertyValue = propertyValue;
    }
    
    /**
     * Get the unique ID of the survey
     *
     * @return The unqiue ID of the survey
     * @since 0.0.1
     */
    public int getSurveyID(){
        return surveyID;
    }
    
    /**
     * Get the instance of the Surveyor class of the surveyor who carried out
     * the survey on the property
     *
     * @return The Surveyor of the property
     * @since 0.0.1
     * @see Surveyor
     */
    public Surveyor getSurveyor(){
        return surveyor;
    }
    
    /**
     * Get the date the survey was carried out
     *
     * @return The date the survey was carried out
     * @since 0.0.1
     */
    public GregorianCalendar getSurveyDate(){
        return surveyDate;
    }
    
    /**
     * Get the value of the property resulting from the survey
     *
     * @return The value of the property resulting from the survey
     * @since 0.0.1
     */
    public float getPropertyValue(){
        return propertyValue;
    }

    /**
     * Check the ID of the survey
     *
     * @param surveyID The survey ID to be checked
     * @since 0.0.1
     */
    private static void checkSurveyID(final int surveyID) {
        if(surveyID < 0) throw new IllegalArgumentException("The survey " +
                "ID must be 0 or greater.");
    }

    /**
     * Check the surveyor who carried out the survey is not null
     *
     * @param surveyor The surveyor reference to be checked
     * @since 0.0.1
     */
    private static void checkSurveyor(final Surveyor surveyor) {
        if(surveyor == null) throw new IllegalArgumentException("The " +
                "surveyor must not be null.");
    }

    /**
     * Check the date the survey was carried out is not null
     *
     * @param surveyDate The survey date to be checked
     * @since 0.0.1
     */
    private static void checkSurveyDate(final GregorianCalendar surveyDate) {
        if(surveyDate == null) throw new IllegalArgumentException("The " +
                "survey date must not be null.");
    }

    /**
     * Check the value of the property is greater than 0
     *
     * @param propertyValue The property value to be checked
     * @since 0.0.1
     */
    private static void checkPropertyValue(final float propertyValue) {
        if(propertyValue <= 0) throw new IllegalArgumentException("The " +
                "property value must be greater than 0.");
    }
}