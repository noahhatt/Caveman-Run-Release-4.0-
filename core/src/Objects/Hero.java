package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Gdx;

public class Hero extends Sprite{
    float fStartX, fStartY;
    public Hero(float fX, float fY, float fW, float fH){
        super(new Texture(Gdx.files.internal("Hero1.png")));
        setSize(fW, fH);
        setPosition(fX, fY);
        setFlip(false, true);
    }
}