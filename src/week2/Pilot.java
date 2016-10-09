package week2;

public class Pilot {
	
	private String firstname;
	private String lastname;
	private int age;
	private int experience;
	
	Pilot(){
		this("", "", 0, 0);
	}
	
	Pilot(String firstname, String lastname, int age, int experience)
	{
		setFirstname(firstname);
		setLastname(lastname);
		setAge(age);
		setExperience(experience);
		
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		if( firstname != null && firstname != "" && firstname.length() > 0) this.firstname = firstname;
		//else System.out.println("Invalid input for first name.");
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		if( lastname != null && lastname != "" && lastname.length() > 0) this.lastname = lastname;
		//else System.err.println("Invalid input for last name.");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0 || age > 120) System.err.println("Invalid age entered." );
		else this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public boolean exists(){
		
		if(this.getFirstname() == null || this.getFirstname() == "" || this.getFirstname().length() == 0) return false;
		
		return true;
	}
	
	public void display() {
		
		if( exists() == true )
		{
			String fname = getFirstname().toUpperCase().substring(0,1) + getFirstname().substring(1);
			String lname = getLastname().toUpperCase().substring(0,1) + getLastname().substring(1);
			System.out.printf("%-25s %-24s %-10d %-15.1f\n", fname, lname, getAge(), (float)getExperience());
		}
	}

	@Override
	public String toString() {
		return "Pilot [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", experience=" + experience
				+ "]";
	}
	
	

}
