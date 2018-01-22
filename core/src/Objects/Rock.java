
package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author johnr5818
 */
public class Rock extends Sprite{
  float fX, fY, fW, fH;
    float fStartX, fStartY;
    public Rock(float fX, float fY, float fW, float fH){
        super(new Texture(Gdx.files.internal("rock.png")));
        setSize(fW, fH);
        setPosition(fX, fY);
        setFlip(false, true);
    }
}

