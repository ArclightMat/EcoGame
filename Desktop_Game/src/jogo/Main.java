package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Main {

	public Main(Window main) {
		
	}

	public static void main(String[] args) {
		Window janela = new Window(800, 600);
		GameImage plano = new GameImage(URL.sprite("menu.png"));
		Keyboard teclado = janela.getKeyboard();
		
		while(true) {
			plano.draw();
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {//Pressione Enter para ir para a introdução do jogo.
			
			new introducao(janela);
		
			}
			else if(teclado.keyDown(Keyboard.SPACE_KEY)) {//Pressione Enter para ir para a introdução do jogo.
				
				System.exit(0);
			
				}
			
		}
	}
}
