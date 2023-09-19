package patikaplus.week4.nighter.scen;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.blup.Scene;
import patikaplus.week4.nighter.blup.Vessel;
import patikaplus.week4.nighter.manag.GameManager;

import patikaplus.util.Array;
import patikaplus.week4.nighter.arran.Signal;
import patikaplus.week4.nighter.arran.Signal.Type;
import patikaplus.week4.nighter.util.Input;
import patikaplus.week4.nighter.util.Print;

public class CharacterCreation extends Scene {
	private final Signal characterCreated;
	
	public CharacterCreation() {
		characterCreated = new Signal(this, Type.CHARACTERCREATED);
	}
	
	@Override
	public void play() {
		Print.title("Character Creation");
		Vessel[] vesselsPlayer = Vessel.Builtin.getVesselsPlayer();
		String name;
		Vessel vessel;
		
		for (int i = 0; i < vesselsPlayer.length; i++) {
			System.out.println(vesselsPlayer[i].getDetails());
		}
		
		vessel = (Vessel) Input.ask("Please choose your vessel, Nighter:", (Object[]) vesselsPlayer);
		Input.reset();
		name = Input.getLine("Interesting... Oh, and, what was your name?");
		
		characterCreated.emit(true, name, vessel);
		
		Print.textln("Very well " + name + ". May nights be on your side.");
		cut();
		//System.out.print(vessel.getClass() + vessel.getDetails() + vessel.getBaseHealth());
	}
	
	public static void main(String[] args) {
		Scene a = new CharacterCreation();
		new Vessel.Builtin();
		a.play();
	}
}
