package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
public class controle1{
	

private Window janela;
private Scene cena;


public controle1 (Window window) {
	janela = window;
	cena = new Scene();
	cena.loadFromFile(URL.scenario("controle1.scn"));
	run();
	
}

private void run() {
	
	Keyboard teclado = janela.getKeyboard();
	
	while(true) {
		cena.draw();
		janela.update();
		
		
		if(teclado.keyDown(Keyboard.ENTER_KEY)) {//Pressione ENTER para ir para iniciar o jogo.
			new cenario(janela);
		}
	}
	
}
}