package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
public class introducao{

private Window janela;
private Scene cena;

public introducao (Window window) {
	janela = window;
	cena = new Scene();
	cena.loadFromFile(URL.scenario("introdução.scn"));
	run();
	
}

private void run() {
	
	Keyboard teclado = janela.getKeyboard();
	
	while(true) {
		cena.draw();
		janela.update();
		
		if(teclado.keyDown(Keyboard.ENTER_KEY)) { //Pressione ENTER para ir para vizualizar os controles do jogo.	
				new controle1(janela);
				
				}
			}
		
	}
	
}
