package obj;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * This class contains all necessary variable to create a linked hash map element
 * @author bruno
 *
 */

public class Person implements  Serializable{
    private long id; //The field value must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private String name; //Field cannot be null, String cannot be empty
    private Coordinates coordinates; //The field cannot be null
    private ZonedDateTime creationDate; //The field cannot be null, the value of this field must be generated automatically
    private Double height; //Field can be null, Field value must be greater than 0
    private ZonedDateTime birthday; //The field cannot be null
    private String passportID; //ПThe field cannot be null
    private Color eyeColor; //The field cannot be null
    private Location location; //The field cannot be null
	private String dateTimeString;
	private String dateTimeBirthString;
	
	private LocalDate Fbirthday;
	private String FdateTimeBirthString;
	
	
	Person () { 
	} 
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param coordinates
	 * @param height
	 * @param passportID
	 * @param eyeColor
	 * @param location
	 */

	public Person(long id, String name, Coordinates coordinates, 
			 Double height,
			 String passportID, Color eyeColor, Location location){
		this.id=id;
		this.name=name;
		this.coordinates=coordinates;
		this.creationDate = ZonedDateTime.now();
        this.dateTimeString = creationDate.toString();
		this.height=height;
		this.birthday=ZonedDateTime.now();
		this.dateTimeBirthString=birthday.toString();
		this.passportID=passportID;
		this.eyeColor=eyeColor;
		this.location=location;
		
		this.Fbirthday=LocalDate.now();
		this.FdateTimeBirthString=Fbirthday.toString();
	}
	
	/**
	 * This method prints out time and data
	 */
		public void printTime() {
			ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));
			ZonedDateTime creationDate = ZonedDateTime.now();
			System.out.println(creationDate);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");
			String formattedString = zonedDateTimeNow.format(formatter);
			System.out.println(formattedString);
		}
		
		/**
		 * This method return element name
		 * @return element name
		 */
	
	 	public String getName() {
	        return name;
	    }
	 	
        /**
         * This method return element id
         * @return element id
         */

	    public long getID() {
	        return id;
	    }
	    
	    /**
	     * This method return element creation data
	     * @return creation data
	     */
	    
	    public ZonedDateTime getCreationDate() {
	        return creationDate;
	    }
	    
	    /**
	     * This method sets element creation data
	     * @param creationDate
	     */
	    
	    public void setCreationDate(ZonedDateTime creationDate) {
	        this.creationDate = creationDate;
	        this.dateTimeString = creationDate.toString();
	    }
	    
	    /**
	     * This method return element height
	     * @return height
	     */
	    
	    public Double getHeight() {
	        return height;
	    }
	    
	    /**
	     * This method return element birthday data
	     * @return
	     */
	    
	    public ZonedDateTime getBirthday() {
	        return birthday;
	    }
	    
	    /**
	     * This method sets element birthday data
	     * @param birthday
	     */
	    
	    public void setDateTimeBirthString(ZonedDateTime birthday) {
	    	this.birthday = birthday;
	    	this.dateTimeBirthString = birthday.toString();
	    }
	    
	    /**
	     * This method return element passport  id
	     * @return passport  id
	     */
	    
	    public String getPassportID() {
	    	return passportID;
	    }
	    
	    /**
	     * This method return element eye color
	     * @return eye color
	     */
	    
	    public Color getEyeColor() {
	        return eyeColor;
	    }
	    
	    /**
	     * This method return element x coordinate
	     * @return x coordinate
	     */
	    
	    public Double getXcoordinate() {
	    	return coordinates.getX();
	    }
	    
	    /**
	     * This method return element y coordinate
	     * @return y coordinate
	     */
	    
	    public float getYcoordinate() {
	    	return coordinates.getY();
	    }
	    
	    /**
	     * This method return element x location
	     * @return x location
	     */
	    
	    public int getXlocation() {
	    	return location.getXloc();
	    }
	    
	    /**
	     * This method return element y location
	     * @return y location
	     */
	    
	    public long getYlocation() {
	    	return location.getYloc();
	    }
	    
	    /**
	     * This method return element z location
	     * @return z location
	     */
	    
	    public long getZlocation() {
	    	return location.getZloc();
	    }    
	    
	    /**
	     * This method return element birthday data (LocalDate)
	     * @return birthday data
	     */
	    
	    public LocalDate FgetBirthday() { 
	        return Fbirthday;
	    }
	    
	    /**
	     * This method sets element birthday data (LocalDate)
	     * @param Fbirthday
	     */
	    
	    public void FsetDateTimeBirthString(LocalDate Fbirthday) {
	    	this.Fbirthday = Fbirthday;
	    	this.FdateTimeBirthString = Fbirthday.toString();
	    	//LocalDate Fbirthday = LocalDate.parse(FdateTimeBirthString, birthday);
	    }
	    
	    
	   
	    //Location loca = new Location();
	    
	    /**
	     * This method return all object information
	     * @return information
	     */
	    
	    public String getShow() {
	    	return "ID: " +getID()+ " Name: " +getName()+ coordinates.getShow()+ " Creation data: " +getCreationDate()+ " Height: "
	                +getHeight()+ " Birthsdays: " +FgetBirthday()+ " PasspordtID: "
	                +getPassportID()+ " Eay color: " +getEyeColor()+ location.getShow();
	    			
	    }
	    
	    

}