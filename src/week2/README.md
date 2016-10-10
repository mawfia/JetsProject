##Jets Project
------------------------------------------------------------

This program was created on 8 October 2016 by Michael Andrew Williams

This program manages a fleet of aircraft and cadre or squadron of pilots.  Both can be viewed, added, or deleted from the inventory or list.  Aircraft can also be filtered by fastest jet and the jet with the greatest flight range.  When a jet is added to the inventory the user has the option of choosing a pilot in the squadron or allowing the system to assign a pilot to the aircraft.  If a pilot is removed from the inventory they are also automatically removed from all assigned aircraft with another pilot assigned as their replacement.  There are two separate menus: one for the jets, and one for the pilots.  The default menu is the hanger menu for the jets.  From the default hanger menu the user can select the pilot menu by making the appropriate selection.  Once in the pilot menu the user can return back to the hanger menu by making the appropriate selection.

This program is comprised of five classes: Area51.java, Hanger.java, Barracks.java, Pilot.java, and Jet.java.


Area51 Class:
------------------------------------------------------------
This class' only function is to instantiate the class, Hanger which intern instantiates an array of jets and pilots from their respective class.
	
	
Hanger Class:
------------------------------------------------------------
Depending on the Hanger method invoked will instantiate an array of jets and pilots or use a pre-existing array of jets and pilots passed as an attribute. The user will be prompted with a menu and terminate when "5" is entered.  The user can access the pilot menu from this menu which will return to the hanger menu upon termination.

	
Barracks Class:
------------------------------------------------------------
This class is invoked automatically by the class Hanger.  When menu selection "6" is pressed from the main (Hanger) menu, the method Barracks will present the user with a menu.  When "4" is entered, the Barracks method returns control back to the Hanger method.

	
Pilot class:
------------------------------------------------------------
This class is comprised of all the data for each pilot.  It is instantiated by the class Barracks.  Requests for information for each pilot are made through the class Barracks which accesses appropriate fields and methods in the Pilot class.  An array of pilots are created by a call from the class Hanger to the class Barracks which intern creates and returns the address of the array back to the class Barracks. 


Jet class:
------------------------------------------------------------
This class is comprised of all the data for each jet.  It is instantiated by the class Hanger.  Requests for information for each jet are made through the class Hanger which accesses appropriate fields and methods in the Pilot class.  An array of jets are created by a call from the class Hanger to the class Jets.