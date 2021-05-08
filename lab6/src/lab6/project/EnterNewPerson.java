package lab6.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import obj.Color;
import obj.Coordinates;
import obj.Location;



public class EnterNewPerson {
	
	private String name;
	private Coordinates coordinates;
	private String passportID;
	private Color eyeColor;
	private Location location;
	private String birthsday;
	private String birthsday2;
	private long id;
	private Double height=0d;
	private Double xcor=0d;
	private float ycor=0f;
	private Integer color=0;
	private int xloc=0;
	private long yloc=0;
	private long zloc=0;
	private int year=0;
	private int day=0;
	private int month=0;
	
	private InputStreamReader r2 = new InputStreamReader(System.in);
	private BufferedReader br2 = new BufferedReader(r2);
	private String keyWord2 = null;
	
	EnterNewPerson(long id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public Coordinates getCord() {
		return coordinates;
		
	}
	
	public Double getHeight() {
		return height;
	}
	
	public long getID() {
		return id;
	}
	
	public String getPassportID() {
		return passportID;
	}
	
	public Color getEyeColor() {
		return eyeColor;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public String getBirthsday() {
		return birthsday;
	}
	
	public String getBirthsday2() {
		return birthsday2;
	}
	
	public void getPersonInfo() {

		System.out.println("Do you realy want to make changes here? [yes/no]");
		
		try {
			keyWord2 = br2.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (keyWord2.equals("no")) {
			System.out.println("restart to start again");
			System.exit(0);
			
		} else {
			do {
				System.out.println("Enter name!");
				try {
					keyWord2 = br2.readLine();
					name = keyWord2;
				} catch (IOException e) {
					e.printStackTrace();
				}
					
			} while (keyWord2.isEmpty());

		}
		
		do {
			 System.out.println("Enter x coordinate!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					xcor = Double.parseDouble(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (xcor==0);

		do {
			System.out.println("Enter y coordinate!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					ycor = Float.parseFloat(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (ycor==0);

		Coordinates newCoordinates = new Coordinates((xcor), (ycor));
		coordinates = newCoordinates;
		// System.out.println("x: "+coordinates.getX()+"y: "+coordinates.getY());

		do {
			System.out.println("Enter height!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {

				try {
					if (Double.parseDouble(keyWord2) > 0) {
						height = Double.parseDouble(keyWord2);
					} else {
						System.out.print("Hight must be greater then 0! - ");
					}
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}

			}
		} while (height==0);

		do {
			System.out.println("Enter passportID!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				passportID = keyWord2;
				// System.out.println(name);
			}
		} while (passportID==null);

		do {
			System.out.println("Choose eay color 1-5 (" + Arrays.toString(Color.values()) + "): ");

			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					color = Integer.parseInt(keyWord2);
					if (color >= 1 && color <= 5 && color != null) {
						eyeColor = Color.values()[color - 1];
						break;
					}
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (color==0||color<1||color>5);

		do {
			System.out.println("Enter x location!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					xloc = Integer.parseInt(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (xloc==0);

		do {
			System.out.println("Enter y location!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					yloc = Long.parseLong(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (yloc==0);

		do {
			System.out.println("Enter z location!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					zloc = Long.parseLong(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (zloc==0);

		Location newLocation = new Location((xloc), (yloc), (zloc));
		location = newLocation;
		
		enterNewBirthsday();
	}
	
	public void enterNewBirthsday() {

		do {
			System.out.println("Enter birth year!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					year = Integer.parseInt(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (year==0||year<1000||year>2022);

		do {
			System.out.println("Enter birth month!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					month = Integer.parseInt(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (month==0||month<1||month>12);

		do {
			System.out.println("Enter birth date!");
			try {
				keyWord2 = br2.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (keyWord2 != null && !keyWord2.isEmpty()) {
				try {
					day = Integer.parseInt(keyWord2);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (day==0||day<1||day>31);

		String month2 = Integer.toString(month);
		String year2 = Integer.toString(year);
		String day2 = Integer.toString(day);

		if (month < 10) {
			month2 = "0" + month2;
		}
		if (day < 10) {
			day2 = "0" + day2;
		}

		birthsday = month2 + "/" + day2 + "/" + year2;
		birthsday2=year2+"-"+month2+"-"+day2;
		
	}
}
