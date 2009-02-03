package uk.co.exahertz.friendlysociety.core;

import java.util.Date;

/**
 * The Survey class contains all information relative to a
 * particular survey like the date on which it has been made etc...
 * 
 * 
 * @author gp79
 * @version  0.0.1
 * @since 0.0.1
 */
public class Survey {


    private int surveyNo;
    private Person surveyor;
    private Property property;
    private Date surveyDate;
    private float value;
    
    /**
     * 
     * @param surveyNo The Number of the survey
     * @param surveyor The surveyor
     * @param property The property
     * @param surveyDate The Date of the survey
     * @param value The result value of the survey
     */
    public Survey(int surveyNo, Person surveyor, Property property, Date surveyDate,
            float value){
        
        // survey number must be positive
        if ( surveyNo < 0 ) throw new IllegalArgumentException(" The survey" +
                " number must be positive");
        
        // checking reference to surveyor
        if ( surveyor == null ) throw new IllegalArgumentException( " A " +
                "reference to the surveyor must be provided");
        
        //cheking reference to property
        if ( property == null ) throw new IllegalArgumentException("A " +
                "reference to the property must be provided");
        
        //checking if a date is provided
        if ( surveyDate == null) throw new IllegalArgumentException(" The " +
                "survey date can not be null");
        
        //checking that value is positive
        if ( value < 0) throw new IllegalArgumentException(" The value must " +
                "be greater or equal to zero");
        
        this.surveyNo = surveyNo;
        this.surveyor = surveyor;
        this.property = property;
        this.surveyDate = surveyDate;
        this.value = value;
         
    }
    
    /**
     * 
     * @return The survey Number
     */
    public int getSurveyNo(){
        return surveyNo;
    }
    
    /**
     * 
     * @return The ID of the surveyor
     */
    public Person getSurveyor(){
        return surveyor;
    }
    
    /**
     * 
     * @return The ID of the property
     */
    public Property getProperty(){
        return property;
    }
    
    /**
     * 
     * @return The date of the survey
     */
    public Date getSurveyDate(){
        return surveyDate;
    }
    
    /**
     * 
     * @return The result value of the survey
     */
    public float getValue(){
        return value;
    }
    
    /**
     * 
     * @param surveyNo The survey number
     */
    public void setSurveyNo(int surveyNo){
        if ( surveyNo < 0 ) throw new IllegalArgumentException("The survey " +
                "number must be positive");
        this.surveyNo = surveyNo;
    }
    
    /**
     * 
     * @param surveyor The surveyor
     */
    public void setSurveyor(Person surveyor){
        if ( surveyor == null ) throw new IllegalArgumentException("The" +
                "reference to the surveyor must not be null");
        this.surveyor = surveyor;
    }
    
    /**
      * 
     * @param property The property
     */
    public void setPropertyID(Property property){
        if ( property == null ) throw new IllegalArgumentException("The" +
                "reference to the property must not be null ");
        this.property = property;
    }
    
    
    /**
     * 
     * @param surveyDate The date of the survey
     */
    public void setSurveyDate(Date surveyDate){
        if ( surveyDate == null ) throw new IllegalArgumentException("The " +
                "reference to the the survey date must not be null");
        this.surveyDate = surveyDate;
    }
    
    /**
     * 
     * @param value The result value of the study
     */
    public void setValue(float value){
        if (value < 0) throw new IllegalArgumentException("The " +
                "value can not be negative");
        this.value = value;
    }
}



