
package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;


public class Bouncer  extends Sprite implements BasicBrick{

    Mario game ;
    
    public  Bouncer(int x, int y , BufferedImage b , Mario g) {
    
        this.setLocation(x, y);
        this.setImage(b);
        
        this.setID(13);
        
        game = g ;
    }



    public void RemoveIt() {
        this.setActive(false);
    }

    public void HitFromDown() {
    }

    public String getInsideItem() {
        return "empty";
    }

    public boolean isJump() {
        return false ;
    }

    
}
    
    