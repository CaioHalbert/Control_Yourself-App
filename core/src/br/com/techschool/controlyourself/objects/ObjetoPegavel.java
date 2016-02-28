package br.com.techschool.controlyourself.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import br.com.techschool.controlyourself.Coordenada2D;
import br.com.techschool.controlyourself.util;

public class ObjetoPegavel {
	
	private Texture imagem;
	private int          x;
	private int          y;
	private int     altura;
	private int    largura;
	
	private boolean visivel;
	
	
	public ObjetoPegavel(String nomeArquivo, int x, int y){
		imagem        = new Texture(Gdx.files.internal(nomeArquivo));
		this.x        = x;
		this.y        = y;
		this.altura   = imagem.getHeight();
		this.largura  = imagem.getWidth();
		this.visivel  = true;
	}
	
	public void update(float delta){
		
	}
	// considerando que recebemos a y,y do touch
	public boolean isTouch(int posx, int posy){
		Coordenada2D c = util.converteCoordenadas(posx, posy);
		
		return (c.getX()>=this.x && c.getX()<=this.x+this.largura &&
				c.getY()>=this.y && c.getY()<=this.y+this.altura);
	}
	
	
	public Texture getImagem() {
		return imagem;
	}


	public void setImagem(Texture imagem) {
		this.imagem = imagem;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getLargura() {
		return largura;
	}


	public void setLargura(int largura) {
		this.largura = largura;
	}


	public boolean isVisivel() {
		return visivel;
	}


	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}


	

}
