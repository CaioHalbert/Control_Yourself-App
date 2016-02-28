package br.com.techschool.controlyourself;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;


public class ControlYourselfGame extends Game {

	private ControlYourselfScreen telaAtual;
	
	
	
	@Override
	public void create() {
		//inicializa os elementos
		
	telaAtual = new StartScreen("startScreen", this);
	setScreen(telaAtual);
		
	}
	
	public void render(){
		// acontece  a cada loop
		telaAtual = getScreen();                        //pega qual é a tela a tual( independente de qual seja)
		telaAtual.render(Gdx.graphics.getDeltaTime());  //desenho a tela de acordo com o DeltaTime
		// logica para transição de telas
		
		String nextScreen;
		
		if(telaAtual.isDone()){                      //tela atual terminou sua logica?
			nextScreen = telaAtual.getNextScreen();  //pego o identificador da proxima tela
			
			if(nextScreen.equals("startScreen")){
				setScreen(new StartScreen("startScreen",this));
			}
			else if (nextScreen.equals("creditsScreen")){
				setScreen(new CreditsScreen("creditsScreen",this));
			}//continua para outra telas
			else if(nextScreen.equals("Fase1Screen")){
				setScreen(new Fase1Screen("Fase1Screen", this));
			}
			else if(nextScreen.equals("Ranking")){
				setScreen(new Ranking("Ranking", this));
			}
		}
		
	}
	//reescrevi o codigo pra retornar uma tela do meu jogo
	public ControlYourselfScreen getScreen(){
		return (ControlYourselfScreen)super.getScreen();
	}
	
	
	
}
