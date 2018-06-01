package jogo;
import jplay.Sound;
import jplay.URL;

public class Som {

	private static Sound musica;
	
	public static void tocar(String audio) {
		if (Som.musica != null) musica.stop(); // Garante que n�o toque duas m�sicas ao mesmo tempo;
		musica = new Sound(URL.audio(audio));
		Som.musica.play();
		Som.musica.setRepeat(true);
	}
}
