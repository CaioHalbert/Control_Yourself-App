package br.com.techschool.controlyourself.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Monstro {
	
	private Texture imagem;
	private int x;
	private int y;
	private int altura;
	private int largura;
	
	private int tempo;
	private boolean ativo;
	private boolean finish;
	
	
	public Monstro(String nomeArquivo,int x, int Y, int tempo){
		imagem = new Texture(Gdx.files.internal(nomeArquivo));
		this.x = x;
		this.y = y;
		this.altura = imagem.getHeight();
		this.largura= imagem.getWidth();
		this.ativo = false;
		this.finish = false;
		this.tempo = tempo;
	}
	
	public void update(float delta){
		if(ativo){                     //ele esta ativo para ser mostradp
			tempo -= 1;                //diminuo o tempo de exibição
			if (tempo==0){             //quando o tempo chega em 0
				ativo = false;          //desativo o monstro(não será mais exibido)
				finish = true;
			}
		}
		
	}
	
	
// gets e sets gerados automaticamente
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

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public void setFinish(boolean finish){
		this.finish = finish;
	}
	public boolean isFinish(){
		return this.finish;
	}

}
