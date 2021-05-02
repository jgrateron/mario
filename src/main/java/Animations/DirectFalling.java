
package Animations;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class DirectFalling extends Sprite {

    double Gravity = 5 ;

    boolean ToRight = true ;
    boolean StraightDown = true ;
    public DirectFalling(BufferedImage image, double x, double y , boolean direction) {
        this.setLocation( x , y );
        this.setImage(ImageUtil.flipVertical(image));
        ToRight = direction ;
        StraightDown = false ;
    }
    
    public DirectFalling(BufferedImage image, double x, double y) {
        this.setLocation( x , y );
        this.setImage(ImageUtil.flipVertical(image));
    }

    public DirectFalling(BufferedImage image, double x, double y , int Gravity) {
        this.setLocation( x , y );
        this.setImage(ImageUtil.flipVertical(image));
        this.Gravity = Gravity ;
    }
    
    public DirectFalling(double x, double y, BufferedImage image) {
        this(image , x , y );
    }
    
        public void update(long l){
            
            if(!StraightDown){
                if(ToRight){
        moveX(4);
        }else {
        moveX(-4); 
        }
            }
            
            if(Gravity < 5){
                Gravity = Gravity + 0.5 ;
            }
        this.moveY(Gravity);
        
        if(this.getY() > 500){
            this.setActive(false);
        }
        super.update(l);
        
        }
        
}
