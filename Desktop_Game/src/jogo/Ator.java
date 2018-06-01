package jogo;

import java.awt.Point;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite{
	
	double velocidade = 1;
	protected int direcao = 3;
	boolean movendo = false;
	public int energia = 100; 
	
	Controle controle = new Controle();
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
	}
	
	public void caminho(Scene cena) {
		Point min = new Point((int)this.x,(int)this.y);
		Point max = new Point((int)this.x + width,(int)this.y + height);
		
		Vector<?>tiles = cena.getTilesFromPosition(min, max);
		
		for(int i = 0; i < tiles.size();i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i);
			if (controle.colisao(this, tile)== true) 
				if(colisaovertical(this,tile)) {
				if(tile.y + tile.height -2 < this.y) {
					this.y = tile.y + tile.height;
				}
				else if(tile.y > this.y + this.height - 2) {
					this.y = tile.y - this.height;
				}
			}
			if(colisaohorizontal(this,tile)) {
				if(colisaovertical(this,tile)) {
					if(tile.x + tile.width -2 < this.x) {
						this.x = tile.x + tile.width;
					}
					else if(tile.x > this.x + this.width - 2) {
						this.x = tile.x - tile.width;
					}
				}
			}
		}
		
		
	}
		private boolean colisaovertical(GameObject obj, GameObject obj2) {
			if(obj2.x +obj2.width <= obj.x)
				return false;
			if(obj.x +obj.width <= obj.x)
				return false;
			return true;
		}
		private boolean colisaohorizontal(GameObject obj, GameObject obj2) {
			if(obj2.y +obj2.height <= obj.y)
				return false;
			if(obj.y +obj.height <= obj.y)
				return false;
			return true;
		}

}
