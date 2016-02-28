package br.com.techschool.controlyourself;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

import br.com.techschool.controlyourself.objects.ObjetoPegavel;

public class StartScreen extends ControlYourselfScreen {

	private Texture imagemFundo; // elemento para ler o arquivo de imagem
	private SpriteBatch spriteBatch; // elemento para desenhar as imagens camada por camada
	private Matrix4 viewMatrix; // preciso de uma matriz para vizualizar a imagem
	private Matrix4 tranMatrix; // preciso de uma matriz para escalar a imagem quando a tela mudar
	
	private ObjetoPegavel btnPlay;
	private ObjetoPegavel btnRkn;
	
	
	public StartScreen(String id, ControlYourselfGame game) {
		super(id, game); // chama o construtor da classe pai

		spriteBatch = new SpriteBatch();
		imagemFundo = new Texture(Gdx.files.internal("imagens/telaabertura.jpeg"));
		viewMatrix = new Matrix4();
		tranMatrix = new Matrix4();
		
		btnPlay = new ObjetoPegavel("imagens/btnPlay.png", 50, 150);
		btnRkn = new ObjetoPegavel("imagens/btnRanking.png", 600, 150);
	}

	public void update(float delta) {
		// devo escrever a logica de atualização
		
		/*if(Gdx.input.justTouched()){//se o usuario clicou na tela
			setNextScreen("Fase1Screen");//defino qual a proxima tela
			setDone(true); //sinalizo como terminado
		}*/
		
		if (Gdx.input.justTouched()){
			if(btnRkn.isTouch(Gdx.input.getX(), Gdx.input.getY())){
				setDone(true);
				setNextScreen("Ranking");
			}
			else if(btnPlay.isTouch(Gdx.input.getX(), Gdx.input.getY())){
				setDone(true);
				setNextScreen("Fase1Screen");
			}
		}
			
	}

	public void draw(float delta) {
		// vou escrever como será o desenho
		
		viewMatrix.setToOrtho2D(0,0, util.RES_LARGURA, util.RES_ALTURA);//defino a resolução, levando em contra qu o ponto inicial é o canto inferior esquerdo da tela
		
		spriteBatch.setProjectionMatrix(viewMatrix);//defino que a area de resolução será usada
		spriteBatch.setTransformMatrix(tranMatrix);//defino uma matriz para armazenar os distorções quando a tela for de diferente resolução
		spriteBatch.begin();
		spriteBatch.draw(imagemFundo, 0,0, imagemFundo.getWidth(), 
		                 imagemFundo.getHeight(), 0, 0, util.RES_LARGURA, util.RES_ALTURA, false, false);//
	
		spriteBatch.draw(btnPlay.getImagem(),btnPlay.getX(), btnPlay.getY());
		spriteBatch.draw(btnRkn.getImagem(),btnRkn.getX(), btnRkn.getY());
		
		spriteBatch.end();
	}
	public void dispose() {
		// depois de tudo liberado, devo liberar a memoria
		spriteBatch.dispose();
	}

}
