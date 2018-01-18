package gdxr.eid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrPlay implements Screen {

    GdxGame game;
    Button btnMenu;
    SpriteBatch batch;
    OrthographicCamera oc;
    Hero Hero1;
    float fFallSpeed = 0;

    public ScrPlay(GdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        btnMenu = new Button(590,0,50,40,"menu.png");
        Hero1 = new Hero(Gdx.graphics.getWidth() / 4 - 50f, Gdx.graphics.getHeight() / 2 + 100, 100f, 100f);
    }
        private void changeScreen() {
        
         if (Gdx.input.isKeyPressed(Input.Keys.M)) {
             game.updateState(0);
             
        }
          if (Gdx.input.isKeyPressed(Input.Keys.C)) {
             game.updateState(2);
             
        }
          if (Gdx.input.justTouched()) {               
        
         if (btnMenu.isMousedOver()) {
           game.updateState(0);     
         }
        }
    }
    

    @Override
    public void render(float f) {
             changeScreen();
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        Hero1.draw(batch);
        btnMenu.draw(batch);
        batch.end();
        KeyPressed();
        
        if (Hero1.getY() >= Gdx.graphics.getHeight() / 2 + 100) {            
            fFallSpeed = 0;
        }
        if (Hero1.getY() < Gdx.graphics.getHeight() / 2 + 100) {
            fFallSpeed = fFallSpeed + 0.35f;           
            Hero1.setY(Hero1.getY() + fFallSpeed);
        }       
    }

    public void KeyPressed() {
        if (Hero1.getY() >= Gdx.graphics.getHeight() / 2 + 100) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                fFallSpeed = -10;
                Hero1.setY(Hero1.getY() + fFallSpeed);
            }
        }
    }

    @Override
    public void resize(int i, int i1) {
        return;
    }

    @Override
    public void pause() {
        return;
    }

    @Override
    public void resume() {
        return;
    }

    @Override
    public void hide() {
        return;
    }

    @Override
    public void dispose() {
        return;
    }
}