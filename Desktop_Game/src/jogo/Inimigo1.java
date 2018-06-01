package jogo;

import jplay.URL;

import javax.swing.JOptionPane;

public class Inimigo1 extends Ator {
	private int ataque = 0;
	public Inimigo1(int x, int y, int energia, int ataque, String sprite) {
		super(URL.sprite(sprite), 20);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0.3;
		this.energia = energia;
		this.ataque = ataque;
	}
	
	public void seguir(double x, double y) {
		if(this.x > x && this.y <= y + 50 && this.y >= y - 50) {
			moveTo(x, y, velocidade);
			if(direcao != 1) {
				setSequence(4, 8);
				direcao = 1;
			}
			movendo = true;
		}
		else if(this.x < x && this.y <= y + 50 && this.y > y - 50) {
			moveTo(x, y, velocidade);
			if (direcao != 2) {
				setSequence(8,12);
				direcao = 2;
			}
			movendo = true;
		}
		else if (this.y > y) {
			moveTo(x, y, velocidade);
			if(direcao != 4) {
				setSequence(12, 16);
				direcao = 4;
			}
			movendo = true;
		}
		else if (this.y < y) {
			moveTo(x, y, velocidade);
			if(direcao != 5 ) {
				setSequence(0,4);
				direcao = 5;
			}
			movendo = true;
		}
		if(movendo) {
			update();
			movendo = false;
		}
	}
	public void morrer(Jogador jogador) {
		if(this.energia <= 0) {
			this.velocidade = 0;
			this.ataque = 0;
			this.direcao = 0;
			this.movendo = false;
			this.x = 1_000_000;
			this.y = 1_000_000;
			if(jogador.contador == 16) JOptionPane.showMessageDialog(null, "Marcos conseguiu impedir os planos do Senhor Poluição!\nVocê ganhou! O mundo está limpo!");
			else JOptionPane.showMessageDialog(null, "Marcos conseguiu impedir os planos do Senhor Poluição!\nVocê ganhou! Mas não limpou o mundo, faltam " + (16 - jogador.contador) + " pedaços de papel para serem coletados.");
			System.exit(0);
		}
}	
	public void soco(Jogador jogador) {
		if(this.collided(jogador)) {
			jogador.energia -= this.ataque;
		}
		if(jogador.energia <= 0) {
			JOptionPane.showMessageDialog(null, "Marcos falhou em sua missão!\nTente novamente para impedir a dominação do Senhor Poluição.");
			System.exit(0);
		}
	}	
}