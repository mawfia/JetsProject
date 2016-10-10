package week2;
import java.util.Scanner;

public class Hanger {
	private int totalNumJets;
	private Barracks barracks = new Barracks();
	private Pilot[] pilots;

	public void Hanger(){
		Hanger(null, true);
	}
		
	public void Hanger (Jet[] jets, boolean start) {                
		if(start && (jets == null || jets[0] == null || jets[0].exists() == false) ) jets = createFleet(0, true);
		
		if (barracks.getUpdatedList() == true) for(int i = 0; i < getFleetCount(); i++) if ( barracks.searchPilotList(jets[i].pilot, pilots) == -1) { 
			System.out.println(jets[i].pilot + ",\nIs no longer available for " + jets[i]); System.out.println( (jets[i].pilot = assignPilot(0)) + ", is now assigned.\n" );
				barracks.setUpdateList();
			}
		System.out.println("Select from the menu (1-6): ");        
		System.out.println("1) List Fleet");        
		System.out.println("2) View fastest jet");        
		System.out.println("3) View jet with longest range"); 
		System.out.println("4) Add a jet to Fleet");
		System.out.println("5) Quit"); 
		System.out.println("6) Pilot Menu");
		
		String selection;
		if( (selection = new Scanner(System.in).next()).charAt(0) == '1' ){
			displayFleet(jets);
			Hanger(jets, false);
		}
		else if (selection.charAt(0) == '2') 	{ jets[searchFleet(null, jets, 2)].display(); Hanger(jets, false); }
		else if (selection.charAt(0) == '3')	{ jets[searchFleet(null, jets, 3)].display(); Hanger(jets, false); }
		else if (selection.charAt(0) == '4')	{ Jet record = new Jet();
			System.out.print("Please provide the following information, model: "); record.setModel(new Scanner(System.in).nextLine());
			System.out.print("top speed: "); record.setSpeed(new Scanner(System.in).nextFloat());
			System.out.print("max range: "); record.setRange(new Scanner(System.in).nextFloat());
			System.out.print("MSRP: "); record.setPrice(new Scanner(System.in).nextFloat());
			System.out.print("total fuel capacity (in pounds): "); record.setCapacity(new Scanner(System.in).nextInt());
			System.out.print("Would you like to select the pilot? (Y/N): ");
			do{
				selection = new Scanner(System.in).next().toUpperCase();
				if( selection.charAt(0) == 'N' ) { record.pilot = assignPilot(0); break; }
				else if( selection.charAt(0) == 'Y' ) {
					System.out.print("Enter pilot's first name: ");
					record.pilot.setFirstname(new Scanner(System.in).next());
					System.out.print("Enter pilot's last name: ");
					record.pilot.setLastname(new Scanner(System.in).next());
					if( (record.pilot = assignPilot(barracks.searchPilotList(record.pilot, pilots))) != null) break;
					else System.out.println("Pilot not found in database.");
				} 
				System.out.print("Would you like to select the pilot? (Y/N): ");
			}while(selection.charAt(0) != 'N');
			
			jets = modifyFleet(record, jets, -1); Hanger(jets, false); }
		else if (selection.charAt(0) == '5') return;
		else if (selection.charAt(0) == '6') {barracks.Barracks(pilots, false); Hanger(jets, false); }					/*{System.out.println(totalNumJets + " " + jets.length); Hanger(jets,false);}*/
		else {
			System.out.println("Illegal Input. Re-enter selection.");
			Hanger(jets, false);
		}
	}
	
	public void Hanger(Jet[] jets, Barracks barracks, boolean start){
		if( barracks != null ) this.barracks = barracks;
		if( jets != null ) Hanger(jets, true);
		else Hanger();
	}
	
	private void setFleetCount(int counter){
		totalNumJets += counter;
	}
	
	int getFleetCount(){
		return totalNumJets;
	}
	
	private Jet[] modifyFleet(Jet record, Jet[] fleet, int addDelete){
		if(getFleetCount() == fleet.length /*&& addDelete == -1*/) // increase fleet capacity by five if full
		{
			Jet[] newFleet = createFleet(fleet.length + 5, false);
			for(int i = 0; i < fleet.length; i++) newFleet[i] = fleet[i];

			return modifyFleet(record, newFleet, addDelete);
		}
		if (addDelete == -1) { // add to fleet
			fleet[getFleetCount()] = record;
			setFleetCount(1);
		}
		else if (addDelete > -1 ) { // delete from fleet *** Not currently used ***          				
			for (int k = addDelete; k < getFleetCount()-1; k++) fleet[k]=fleet[k+1];  
			fleet[getFleetCount()-1] = new Jet();
			setFleetCount(-1);
		}
		return fleet;
	}
	
	private int searchFleet(Jet record, Jet[] fleet, int searchOption){  
		float speed_range = 0.0F; int match = 0;
		switch(searchOption){
			case 0:
					for(int i = 0; i < getFleetCount(); i++) if( record.getModel().equals(fleet[i].getModel()))  return match = i;
					break;
			case 2:	
					for (int i = 0; i < fleet.length ; i++) {    // fleet.length should be replaced with totalNumJets            
						if(	speed_range < fleet[i].getSpeed() ) { speed_range = fleet[i].getSpeed(); match = i; }              
					} return match;
			case 3: 
					for (int i = 0; i < fleet.length ; i++) {    // fleet.length should be replaced with totalNumJets            
						if(	speed_range < fleet[i].getRange() ) { speed_range = fleet[i].getRange(); match = i; }              
					} return match;
			default: break;
		}
		return -1;
	}
	
	
	private Jet[] createFleet(int numJets, boolean initialize) {
			
			if(( barracks == null || barracks.getPilotCount() == 0 ) && initialize) pilots = barracks.Barracks(initialize);
			if(numJets == 0 && initialize )			
			{
					Jet[] initialFleet = new Jet[]	{ 				new Jet("GulStream G450", 670, 3000, 41000000, 4370, null),
																	new Jet("Boeing Bombardier 45XR", 533, 1968, 11000000, 4682, null),
																	new Jet("Cessna Citation CJ4", 518, 2165, 9410000, 5828, null),
																	new Jet("Embraer Phenom 300", 518, 2268, 8995000, 5353, null),
																	new Jet("Beechcraft Premier IA", 530, 1645, 7100000, 3670, null),
																	new Jet("F-35 Lightening II", 1199, 1379, 148000000, 18500, null)};
							setFleetCount(6);
							initialFleet[0].setPilot(assignPilot(0));
							initialFleet[1].setPilot(assignPilot(0)); 
							initialFleet[3].setPilot(assignPilot(0)); 
							initialFleet[2].setPilot(assignPilot(0)); 
							initialFleet[4].setPilot(assignPilot(0));
							initialFleet[5].setPilot(assignPilot(0));
							return initialFleet;
					
			}
			
			Jet[] fleet = new Jet[numJets];
			for (int i = 0; i < fleet.length; i++) fleet[i] = new Jet();
	        
			return fleet;
	}
	
	private Pilot assignPilot(int i) {
		if(i <= 0) 
			if (i == 0 )return pilots[(int)((Math.random()*barracks.getPilotCount()))];
			else return null;
		else return pilots[i];
	}
	
	private void displayFleet(Jet[] jets) {        
		
		for( Jet j: jets) j.display();
		System.out.println();
		
	}  
}
