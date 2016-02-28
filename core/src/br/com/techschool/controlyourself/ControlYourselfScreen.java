package br.com.techschool.controlyourself;

import com.badlogic.gdx.Screen;

public abstract class ControlYourselfScreen implements Screen {
	
	private String                  id;//toda tela tem um nome
	private ControlYourselfGame   game;//toda tela estara referenciada em um jogo
	private boolean               done;// indica se terminou a logica da tela ou não
	private String          nextScreen;//indica a proxima tela a ser mostrada
	
	public ControlYourselfScreen(String id, ControlYourselfGame game){
		
	this.id   = id;
	this.game = game;
	}
	
	public String getId(){
		return this.id;
	}
	public void setDone(boolean done){
		this.done = done;
	}
	public boolean isDone(){
		return this.done;
	}
	public void setNextScreen(String nextScreen){
		this.nextScreen = nextScreen;
	}
	public String getNextScreen(){
		return this.nextScreen;
	}
	
	//"obrigo todas as classes filhas de Sscreen a terem metodos UPDATE e RENDER
	public abstract void draw(float delta);
	public abstract void update(float delta);
	
	public void render(float delta){
		update(delta);
		draw  (delta);
	}
	
	public void show(){
		//não faz nada (eu poderia só registrar um debug)
	}
	public void resize(int width, int heigth){
		//não faz nada, vamos tentar o resize com as matrizes no metodo RENDER
	}
	public void pause(){
		
	}
	public void resume(){
		
	}
	public void hide(){
		// fazem nada
	}
	

}
