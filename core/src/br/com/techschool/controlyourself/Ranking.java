package br.com.techschool.controlyourself;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

import br.com.techschool.controlyourself.objects.ObjetoPegavel;

public class Ranking extends ControlYourselfScreen{

	private Texture imagemFundo; // elemento para ler o arquivo de imagem
	private SpriteBatch spriteBatch; // elemento para desenhar as imagens camada por camada
	private Matrix4 viewMatrix; // preciso de uma matriz para vizualizar a imagem
	private Matrix4 tranMatrix; // preciso de uma matriz para escalar a imagem quando a tela mudar
	private BitmapFont bitmapFont;
	
	private String strRanking="";
	
	public Ranking(String id, ControlYourselfGame game) {
		super(id, game); // chama o construtor da classe pai

		spriteBatch = new SpriteBatch();
		imagemFundo = new Texture(Gdx.files.internal("imagens/telaabertura.jpeg"));
		viewMatrix = new Matrix4();
		tranMatrix = new Matrix4();
		
		bitmapFont = new BitmapFont(Gdx.files.internal("fonte/ComeBack2.fnt"));
		bitmapFont.getData().scale(0.5f);
		
		getRanking();
		
		
		
	}

	public void update(float delta) {
		// devo escrever a logica de atualização
		
		if(Gdx.input.justTouched()){          //se o usuario clicou na tela
			setNextScreen("startScreen");     //defino qual a proxima tela
			setDone(true);                    //sinalizo como terminado
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
	
		bitmapFont.draw(spriteBatch, strRanking, 200, 200);
		
	    spriteBatch.end();
	}
	public void dispose() {
		// depois de tudo liberado, devo liberar a memoria
		spriteBatch.dispose();
	}
	
	public void getRanking(){
		Net.HttpRequest requisicao = new Net.HttpRequest();
		requisicao.setMethod("GET");
		requisicao.setUrl("http://192.168.0.113:8084/ControlYourselfServer/service/hello/getPlayers");
		
		Gdx.net.sendHttpRequest(requisicao, new Net.HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				// TODO Auto-generated method stub
				strRanking = httpResponse.getResultAsString();
				
			}
			
			@Override
			public void failed(Throwable t) {
				// TODO Auto-generated method stub
				strRanking = "Ranking indisponivel";
				
			}
			
			@Override
			public void cancelled() {
				// TODO Auto-generated method stub
				strRanking = "Ranking indidponivel";
				
			}
		});
	
	}

}



