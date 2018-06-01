package jogo;

import com.sun.glass.events.KeyEvent;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Jogador extends Ator{
	public int contador = 0;
	public Jogador(int x, int y, int energia) {
		super(URL.sprite("jogador.png"),20);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.energia = energia;
		this.setSequence(8, 12);
	}
	// Invoca lógica de tiro
	ControleTiro tiros = new ControleTiro();
	public void disparar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
		if(teclado.keyDown(KeyEvent.VK_A)) { // Botão A atira quando pressionado
			tiros.adicionaTiro(x + 10, y + 20, direcao, cena); // Ajustar x e y para centralizar mais tarde
		}
		tiros.executa(inimigo);
	}
	public void mover(Window janela, Keyboard teclado) {
		
		if(teclado.keyDown(Keyboard.LEFT_KEY)) {
			if(this.x > 0) {
				this.x -=velocidade;
				}
			if(direcao != 1) {
				setSequence(4, 8);
				direcao=1;
				movendo=true;
			}
		}
		else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth() - 60) {
				this.x +=velocidade;
				}
			if(direcao != 2) {
				setSequence(8, 12);
				direcao=2;
				movendo=true;
			}
		}
			else if(teclado.keyDown(Keyboard.UP_KEY)){
				if(this.y > 0)  {
					this.y -=velocidade;
					}
				if(direcao != 4) {
					setSequence(12, 16);
					direcao=4;
					movendo=true;
			}	
		}
			else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
				if(this.y < janela.getHeight()-60) {
					this.y +=velocidade;
					}
				if(direcao != 5) {
					setSequence(0, 4);
					direcao=5;
					movendo=true;
			}
	}
		update();
		if(movendo) {
			movendo=false;
		}		
	}
	public void updateContador() {
		contador++;
	}
}
