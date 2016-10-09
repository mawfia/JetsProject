package week2;

public class Jet {

	String model;
	float speed;
	float range;
	float price;
	int capacity;
	Pilot pilot;
	
	Jet(){
		this("", 0.0F, 0.0F, 0.0F, 0, null);
	}
	
	Jet(String model, float speed, float range,float price,int capacity, Pilot pilot){
		setModel(model);
		setSpeed(speed);
		setRange(range);
		setPrice(price);
		setCapacity(capacity);
		setPilot(pilot);
	}
	
	public float convertToMach(float speedInMPH){
		return speedInMPH*.00130332F;
	}
	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		if(pilot != null) this.pilot = pilot;
		else {this.pilot = new Pilot(); this.pilot.setFirstname("N/A"); this.pilot.setLastname("N/A");}
	}
	
	public boolean exists(){
	
		if(this.getModel() == null || this.getModel() == "" || this.getModel().length() == 0 ) return false;
	
		return true;
	}

	
	void display() {

		if(exists() == true)
		{
			String model = getModel().toUpperCase().substring(0,1) + getModel().substring(1);

			System.out.printf("%-25s (M)%-2.2f/(MPH)%-11d %-10.2f $%-15.2f %-10d\n", model, convertToMach(getSpeed()), (int)getSpeed(), getRange(), (float)getPrice(), getCapacity());
			pilot.display();

		}
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + ", capacity="
				+ capacity + ", pilot=" + pilot + "]";
	}
	
	
	
}
