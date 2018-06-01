package jogo;
import java.util.LinkedList;
import jplay.Scene;
import jplay.URL;
import jplay.Sound;

public class ControleTiro {
	
	LinkedList<Tiro> tiros = new LinkedList<>();
	public void adicionaTiro(double x, double y, int caminho, Scene cena) {
		Tiro tiro = new Tiro(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		efeitoTiro();
	}
	public void executa(Ator inimigo) {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			if(tiro.collided(inimigo)) {
				// Remove tiro do campo de visão
				tiro.x = 1_000_000;
				tiro.y = 1_000_000;
				inimigo.energia -= 1; // Ajustar para controlar dano do tiro
			}
		}
	}
	private void efeitoTiro() {
		new Sound(URL.audio("tiro.wav")).play();
	}
}
