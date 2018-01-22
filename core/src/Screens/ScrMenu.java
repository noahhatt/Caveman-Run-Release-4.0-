
package Screens;

import Screens.GdxGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Objects.Button;

/**
 *
 * @author johnr5818
 */
// screen 0 is menu and 1 is play
public class ScrMenu implements Screen {
    Texture txtBack;
    GdxGame game;
    Button btnPlay;
    Button btnContr;
    SpriteBatch batch;
    OrthographicCamera oc;

    public ScrMenu(GdxGame game) {
        this.game = game;
        
    }

    @Override
    public void show() {

        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        btnPlay = new Button(265,0,150,90,"playword.psd");
        btnContr = new Button(400, 140, 100, 80, "Contr.jpg");

    }

    private void changeScreen() {
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
             game.updateState(1);
        } else if (Gdx.input.isKeyPressed(Input.Keys.C)) {
             game.updateState(2);
        }
        if (Gdx.input.justTouched()) {
            if (btnPlay.isMousedOver()) {
                   game.updateState(1);
            }
            if (btnContr.isMousedOver()) {
               game.updateState(2);
            }
        }
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        changeScreen();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        btnContr.draw(batch);
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
