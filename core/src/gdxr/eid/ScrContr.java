package gdxr.eid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author johnr5818
 */
public class ScrContr implements Screen {

    GdxGame game;
    Button btnPlay;
    Button btnMenu;
    SpriteBatch batch;
    OrthographicCamera oc;
    
//Joel tought me what all the games mean :-)
    public ScrContr(GdxGame game) {
       this.game = game;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        btnPlay = new Button(265,0,150,90,"playword.psd");
        btnMenu = new Button(590,0,50,40,"menu.png");
    }

    private void changeScreen() {
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            game.updateState(1);
          
        }
         if (Gdx.input.isKeyPressed(Input.Keys.M)) {
             game.updateState(0);
             
        }
          if (Gdx.input.justTouched()) {
          if (btnPlay.isMousedOver()) {
           System.out.println("play");
          game.setScreen(new ScrPlay(game));          
        }
         if (btnMenu.isMousedOver()) {
           System.out.println("Menu");
          game.setScreen(new ScrMenu(game));          
        }
    }
    }
//change
    @Override
    public void render(float f) {
        changeScreen();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        btnMenu.draw(batch);
        btnPlay.draw(batch);
        batch.end();
        
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
