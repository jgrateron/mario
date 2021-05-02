
package Objects;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;


public class Fire extends AnimatedSprite{

    int actualY ; // 6 , 7 , 8 , 9 * 32

    public Fire(double x, double y , BufferedImage[] storedImages) {
        
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        
        this.setID(120) ;
//        game = g ;
        
        actualY = com.golden.gamedev.util.Utility.getRandom(6, 9)* 32 ; 
        
    }
    
        public void update(long l){

            if(this.getY() > actualY){
                this.moveY(-4);
            }if(this.getY() < actualY){
                this.moveY(4);
            }
        moveX(-4);
        
        if(this.getScreenX() < 0){
            this.setActive(false);
        }
        super.update(l);
    }

    
}
