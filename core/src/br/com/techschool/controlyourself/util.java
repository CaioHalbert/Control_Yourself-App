package br.com.techschool.controlyourself;

import com.badlogic.gdx.Gdx;

public class util {
	
	public static final int RES_ALTURA  = 509;
	public static final int RES_LARGURA = 960;
	
	public static int SANITY;
	
	public static Coordenada2D converteCoordenadas(float x, float y){
		float dv = (float)Gdx.graphics.getHeight()/RES_ALTURA;
		float dh = (float)Gdx.graphics.getWidth()/ RES_LARGURA;
		
		Coordenada2D c = new Coordenada2D();
		c.setX(x/dh);
		c.setY(RES_ALTURA - y/dv);
		
		return c;
	}

}
