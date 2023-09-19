package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.blup.Scene;
import patikaplus.week4.nighter.scen.CharacterCreation;
import patikaplus.week4.nighter.scen.Intro;

public class SceneManager {
	protected static void newGame() {
		Scene intro = new Intro();
		Scene characterCreation = new CharacterCreation();
		intro.play();
		characterCreation.play();
	}
}
