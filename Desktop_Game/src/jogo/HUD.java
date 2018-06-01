package jogo;

import java.awt.Color;
import java.awt.Font;

import jplay.Window;

public class HUD {
		Font f = new Font("arial", Font.BOLD, 20);
		public void valorEnergia(Window janela, Jogador jogador) {
			janela.drawText("HP: " + jogador.energia, 30, 30, Color.BLACK, f);
		}
		public void valorEnergia(Window janela, Inimigo1 inimigo) {
			janela.drawText("Oponente: " + inimigo.energia, 640, 30, Color.RED, f);
		}
		public void valorPontos(Window janela, Jogador jogador) {
			janela.drawText("Pontos: " + jogador.contador, 30, 50, Color.BLACK, f);
		}
}
