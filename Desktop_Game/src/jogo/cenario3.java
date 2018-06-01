package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class cenario3 extends colisao {
	private Window janela;
	private Scene cena;
	public static Jogador jogador;
	private	Keyboard teclado;
	private Lixo lixo[];
	private HUD hud;
	
	public cenario3 (Window window) {
		 janela = window;
		 cena = new Scene();
		 cena.loadFromFile(URL.scenario("cenario3.scn"));
		 jogador = new Jogador (0 , 510, 1000); // Posição X, posição Y, pontos de vida
		 jogador.contador = cenario2.jogador.contador;
		 lixo = new Lixo[4];
		 lixo[0] = new Lixo(130, 510, "lixo.png");
		 lixo[1] = new Lixo(260, 530, "lixo.png");
		 lixo[2] = new Lixo(520, 410, "lixo.png");
		 lixo[3] = new Lixo(700, 580, "lixo.png");
		 teclado = janela.getKeyboard();
		 hud = new HUD();
		 Som.tocar("map.wav");
		 run();
	}
	
	private void run() {
		
		while(true) {
			//cena.draw();
			
			// Movimentação
			jogador.mover(janela,teclado);
			jogador.caminho(cena);
			cena.moveScene(jogador);
			
			// Offsets
			jogador.x += cena.getXOffset();
			jogador.y +=cena.getXOffset();
			
			// Habilidades
			hud.valorEnergia(janela, jogador);
			hud.valorPontos(janela, jogador);
			lixo[0].limpa(jogador);
			lixo[1].limpa(jogador);
			lixo[2].limpa(jogador);
			lixo[3].limpa(jogador);
				
			// Renderização
			jogador.draw();
			lixo[0].draw();
			lixo[1].draw();
			lixo[2].draw();
			lixo[3].draw();
			janela.update();
			mudarcenario();
		
			
		}
		
	}

	private void mudarcenario() {
		if(tileCollision(51, jogador, cena)==true) {
			new cenario4(janela);
	}

	}
}