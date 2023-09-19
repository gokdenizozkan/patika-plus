package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.arran.Signal;
import patikaplus.week4.nighter.arran.Signal.Type;

public abstract class Scene {
	protected final Signal cut;
	
	protected Scene() {
		cut = new Signal(this, Type.CUT);
	}
	
	public abstract void play();
	
	protected void cut() {
		cut.emit();
	}
}
