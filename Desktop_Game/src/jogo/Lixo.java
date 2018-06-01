package jogo;
import jplay.URL;

public class Lixo extends Ator {
	
	//private Window janela;
	public Lixo(int x, int y, String sprite) {
		super(URL.sprite(sprite), 1);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0;
		setSequence(0, 1);
	}
	
	public void limpa(Jogador jogador) {
		if(this.collided(jogador)) {
			this.x = 1000000;
			this.y = 1000000;
			jogador.updateContador();
		}
	}
}
