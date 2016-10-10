package week2;
import java.util.Scanner;

public class Barracks {
	
	private boolean updateList = false;
	private int totalNumPilots;
	
	public void Barracks(){
		Barracks(null, true);
	}
	
	public Pilot[] Barracks(boolean start){
		
		return createList(0, start);
	}
	
	public void Barracks (Pilot[] pilots, boolean start) {                
		if(start && (pilots == null || pilots[0] == null || pilots[0].exists() == false) ) pilots = createList(0, true);
		System.out.println("Select from the menu (1-4): ");        
		System.out.println("1) List Pilot(s)");        
		System.out.println("2) Hire Pilot");        
		System.out.println("3) Fire Pilot"); 
		System.out.println("4) Quit and return to the Hanger");  
		
		String selection = new Scanner(System.in).next();	
		if (selection.charAt(0) == '1'){
			System.out.printf("%-25s %-24s %-10s %-15s\n", "Firstname: ", "Lastname:", "Age:", "Years Experience:");
			displayPilots(pilots);
			Barracks(pilots, false);
		}
		else if (selection.charAt(0) == '2') Barracks(pilots = hirePilot(pilots), false);			
		else if (selection.charAt(0) == '3') Barracks(pilots = firePilot(pilots), false);
		else if (selection.charAt(0) == '4') return;
		else {
			System.out.println("Illegal Input. Re-enter selection.");
			Barracks(pilots, false);
		}		
	}
	
	private Pilot[] hirePilot(Pilot[] list) {                
		Pilot record = new Pilot();
		int ID;
		
		System.out.print("Provide first name of the aviator: ");
		record.setFirstname(new Scanner(System.in).next().toLowerCase());
		
		System.out.print("Last name: ");
		record.setLastname(new Scanner(System.in).next().toLowerCase());
		
		if( (ID = searchPilotList(record, list)) > -1 ) {
			System.out.println("Pilot is already in the databasae. ");
			return list;
		}
		
		System.out.print("Age: ");
		record.setAge(new Scanner(System.in).nextInt());
		
		System.out.print("Years of experience: ");
		record.setExperience(new Scanner(System.in).nextInt());
	
		return modifyList(record, list, ID);       
	}
	
	private void setPilotCount(int counter){
		this.totalNumPilots += counter;
	}
	
	void setUpdateList(){
		this.updateList = false;
	}
	
	boolean getUpdatedList(){
		return updateList;
	}
	
	int getPilotCount(){
		return totalNumPilots;
	}
	
	private Pilot[] firePilot(Pilot[] list) {        
		Pilot record = new Pilot();
		int ID;

		System.out.println("Provide first name of dismissed aviator: ");
		record.setFirstname(new Scanner(System.in).next().toLowerCase());
			
		System.out.println("Provide the last name: ");
		record.setLastname(new Scanner(System.in).next().toLowerCase());
		
		if( (ID = searchPilotList(record, list)) == -1 ) {
			System.out.println("Pilot is not in the databasae. ");
			return list;
		}

		return modifyList(record, list, ID);  
	}
	
	private Pilot[] modifyList(Pilot record, Pilot[] list, int addDelete) {        
					
		if(getPilotCount() == list.length && addDelete == -1)
		{
			Pilot[] newList = createList(list.length + 5, false);
			for(int i = 0; i < getPilotCount(); i++) newList[i] = list[i];
			
			return modifyList(record, newList, addDelete);
		}
		if (addDelete == -1) {
			list[getPilotCount()] = record;
			setPilotCount(1);
		}
		else if (addDelete > -1 ) {            				
			for (int k = addDelete; k < getPilotCount()-1; k++) list[k]=list[k+1];  
			list[getPilotCount()-1] = new Pilot();
			setPilotCount(-1); updateList = true;
		}
		return list;
	}
	
	int searchPilotList(Pilot record, Pilot[] list){  // Will eventually use return value in hire() and fire() for employee index in list and adddelete variable
																		// any number 0 and greater will be for delete and index number, -1 for add 
		for (int i = 0; i < getPilotCount(); i++) {                
			if (list[i].getFirstname().toLowerCase().equals(record.getFirstname().toLowerCase()) &&
				list[i].getLastname().toLowerCase().equals(record.getLastname().toLowerCase())) {
				return i;
			}              
		}
		return -1;
	}
	
	private Pilot[] createList(int numEmployees, boolean initialize){
		
		if(numEmployees == 0 && initialize )			
		{
				Pilot[] initialList = new Pilot[]	{ 			new Pilot("George", "Washington", 35, 1),
																new Pilot("John", "Adams", 50, 5),
																new Pilot("Andrew", "Jackson", 27, 20),
																new Pilot("Harry", "Truman", 29, 10),
																new Pilot("Franky", "Roosevelt", 37, 14),
																new Pilot("Hillary", "Clinton", 68, 12)};
				setPilotCount(6);
				return initialList;
		}
		
		Pilot[] list = new Pilot[numEmployees];
		for (int i = 0; i < list.length; i++) list[i] = new Pilot();
        
		return list;
	}

	private void displayPilots(Pilot[] pilots) {        
		
		for( Pilot p: pilots) p.display();
		System.out.println();
		
	}
}
