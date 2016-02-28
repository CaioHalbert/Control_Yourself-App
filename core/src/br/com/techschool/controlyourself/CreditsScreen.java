package br.com.techschool.controlyourself;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class CreditsScreen extends ControlYourselfScreen {
	
	private Texture imagemFundo;
	private SpriteBatch spriteBatch; 
	private Matrix4 viewMatrix; 
	private Matrix4 tranMatrix;
	
	public CreditsScreen(String id, ControlYourselfGame game){
		super(id, game);
		
		spriteBatch = new SpriteBatch();
		imagemFundo = new Texture(Gdx.files.internal("imagens/telafase1.jpeg"));
		viewMatrix = new Matrix4();
		tranMatrix = new Matrix4();
		
	}
	
	public void update(float delta){
		//devo escrever a logica de atualização

		if(Gdx.input.justTouched()){          //se o usuario clicou na tela
			setNextScreen("startScreen");     //defino qual a proxima tela
			setDone(true);                    //sinalizo como terminado
		}
		
		
	}
	public void draw(float delta){
		viewMatrix.setToOrtho2D(0,0, util.RES_LARGURA, util.RES_ALTURA);
		
		spriteBatch.setProjectionMatrix(viewMatrix);
		spriteBatch.setTransformMatrix(tranMatrix);
		spriteBatch.begin();
		spriteBatch.draw(imagemFundo, 0,0, imagemFundo.getWidth(), 
		                 imagemFundo.getHeight(), 0, 0, util.RES_LARGURA, util.RES_ALTURA, false, false);//
	
	    spriteBatch.end();
	}
	public void dispose(){
		spriteBatch.dispose();
		
	}
	

}
