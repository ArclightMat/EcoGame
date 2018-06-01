package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class cenario5 extends colisao {
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private	Keyboard teclado;
	private Inimigo1 oponenteFraco;
	private HUD hud;
	public cenario5 (Window window) {
		 janela = window;
		 cena = new Scene();
		 cena.loadFromFile(URL.scenario("cenario5.scn"));
		 jogador = new Jogador (0 , 510, 1000); // Posição X, posição Y, pontos de vida
		 jogador.contador = cenario4.jogador.contador;
		 teclado = janela.getKeyboard();		 
		 oponenteFraco = new Inimigo1(600, 550, 100, 1, "boss.png"); // Posição X, posição Y, pontos de vida, dano do oponente, aparencia
		 Som.tocar("boss.wav");
		 hud = new HUD();
		 run();
	}
	
	private void run() {
		
		while(true) {
			//cena.draw();
			
			// Movimentação
			jogador.mover(janela,teclado);
			jogador.caminho(cena);
			oponenteFraco.caminho(cena);
			oponenteFraco.seguir(jogador.x, jogador.y);
			cena.moveScene(jogador);
			
			// Offsets
			jogador.x += cena.getXOffset();
			jogador.y +=cena.getXOffset();
			oponenteFraco.x += cena.getXOffset();
			oponenteFraco.y +=cena.getXOffset();
			
			// Habilidades
			jogador.disparar(janela, cena, teclado, oponenteFraco); // quarto valor = qual inimigo afetará
			hud.valorEnergia(janela, jogador);
			hud.valorPontos(janela, jogador);
			hud.valorEnergia(janela, oponenteFraco);
			oponenteFraco.morrer(jogador);
			oponenteFraco.soco(jogador);

			// Renderização
			jogador.draw();
			oponenteFraco.draw();
			janela.update();
		}
	}
}
