package br.com.techschool.controlyourself;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

import br.com.techschool.controlyourself.objects.Monstro;
import br.com.techschool.controlyourself.objects.ObjetoPegavel;

public class Fase1Screen extends ControlYourselfScreen {

	private Texture imagemFundo;
	private SpriteBatch spriteBatch;
	private Matrix4 viewMatrix;
	private Matrix4 tranMatrix;
	private BitmapFont bitmapFont; // elemento que irá escrever na tela
	private float time; // tempo restante para o jogo
	// private int sanidade; // vida
	private int desconto;// valor descontado a cada tick
	private float tick = 5.0f; // tick de 5 segundos

	private String strTempo;
	private String strSanidade;

	private Array<Monstro> monstros;
	private Array<ObjetoPegavel> item;
	
	//sound track
	
	private Music somBg;
	private Music grito;

	public Fase1Screen(String id, ControlYourselfGame game) {
		super(id, game);

		spriteBatch = new SpriteBatch();
		imagemFundo = new Texture(Gdx.files.internal("imagens/telafase1.jpeg"));
		viewMatrix = new Matrix4();
		tranMatrix = new Matrix4();
		bitmapFont = new BitmapFont(Gdx.files.internal("fonte/ComeBack2.fnt"));
		
		somBg      = Gdx.audio.newMusic(Gdx.files.internal("musica/somFundoFase1.mp3"));
		somBg.setLooping(true);
		somBg.setVolume(0.5f);
		
		grito      = Gdx.audio.newMusic(Gdx.files.internal("musica/grito.mp3"));
		grito.setLooping(false);
		grito.setVolume(0.5f);
		
		time       = 10.0f;

		bitmapFont.getData().scale(0.5f);
		// bitmapFont.setColor(Color.GREEN);

		time = tick;
		util.SANITY = 100;
		desconto = 5;

		strTempo = "Time  ";
		strSanidade = "Sanity  ";

		// criando alguns monstros
		monstros = new Array<Monstro>();
		monstros.add(new Monstro("character/7.png", 100, 0, 30));
		
		item = new Array<ObjetoPegavel>();
		item.add(new ObjetoPegavel("character/3.png", 0, 0));
		item.add(new ObjetoPegavel("character/1.png", 700, 0));
		
		
		somBg.setPan(0, 0.5f);
		somBg.play();

	}

	public void update(float delta) {
		// devo escrever a logica de atualização

		time -= delta;
		if (time < 1) {

			util.SANITY -= desconto;
			time = tick;
			desconto += 5;
		}
		if (util.SANITY == 85) {
			if (!monstros.get(0).isFinish()) {
				if(!monstros.get(0).isAtivo()){
				grito.play();
				monstros.get(0).setAtivo(true);// ativo o monstro na posição 0
												// do vetor
				}
			}
		}
		if (util.SANITY <= 0) {

			setNextScreen("creditsScreen");
			setDone(true);
			somBg.stop();
		}
		
		for(Monstro m: monstros){
			m.update(delta);
		}
		
		if(Gdx.input.justTouched()){
		for(ObjetoPegavel obj: item){
			if(obj.isTouch(Gdx.input.getX(), Gdx.input.getY())){
				obj.setVisivel(false);
			}
		}
		}
		// preciso agora dar update em todos os monstros, estando ativos ou não

		/*
		 * if (Gdx.input.justTouched()) { // se o usuario clicou na tela
		 * setNextScreen("creditsScreen"); // defino qual a proxima tela
		 * setDone(true); // sinalizo como terminado
		 */
	}

	public void draw(float delta) {
		viewMatrix.setToOrtho2D(0, 0, util.RES_LARGURA, util.RES_ALTURA);

		spriteBatch.setProjectionMatrix(viewMatrix);
		spriteBatch.setTransformMatrix(tranMatrix);
		spriteBatch.begin();
		spriteBatch.draw(imagemFundo, 0, 0, imagemFundo.getWidth(), imagemFundo.getHeight(), 0, 0, util.RES_LARGURA,
				util.RES_ALTURA, false, false);//

		bitmapFont.draw(spriteBatch, strSanidade + util.SANITY + "%", 80, 450);
		bitmapFont.draw(spriteBatch, strTempo + String.format("%6.1f", time), 80, 100);

		for (Monstro m : monstros) {
			if (m.isAtivo()) {
				spriteBatch.draw(m.getImagem(), m.getX(), m.getY(), m.getAltura(), m.getLargura());
			}
		}
		for (ObjetoPegavel obj: item){
			if(obj.isVisivel()){
				spriteBatch.draw(obj.getImagem(), obj.getX(), obj.getY());
			}
		}

		spriteBatch.end();

	}

	public void dispose() {
		spriteBatch.dispose();

	}

}
