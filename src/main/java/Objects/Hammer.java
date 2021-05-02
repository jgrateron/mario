
package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;


public class Hammer extends AnimatedSprite{

        boolean PositiveX  = true ;
    
//    Mario game ;
    
    double Gravity ;
    
    double Xspeed ; 
    private double Xspeedinvert;

    Hammer(double x, double y, boolean b, BufferedImage[] storedImages) {
        
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        
        this.setID(1) ;
//        game = g ;
        
        PositiveX  = b ;
        
        Gravity = com.golden.gamedev.util.Utility.getRandom(-10, -7);
        
        Xspeed =  com.golden.gamedev.util.Utility.getRandom(2, 4);
        
        Xspeedinvert =  com.golden.gamedev.util.Utility.getRandom(-4 , -2);
    }

    Hammer(double x, double y, int Hammerxspeed, int HammerGravity, BufferedImage[] storedImages) {
        
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        
        this.setID(1) ;
//        game = g ;
        
        
        Gravity = HammerGravity;
        
        Gravity = Gravity + com.golden.gamedev.util.Utility.getRandom(-10, 10)/10;
                
        Xspeed =  Hammerxspeed;
        
         Xspeed = Xspeed + com.golden.gamedev.util.Utility.getRandom(-10, 10)/10;
       PositiveX  = false ;
        
    }
    
        public void update(long l){
            
            if(Gravity < 10){
                Gravity = Gravity + 0.3;
                
            }
                this.moveY(Gravity);
        
        if(PositiveX ){
        moveX(Xspeedinvert);
        }else {
        moveX(Xspeed); 
        }
        
        if(this.getY() > 500){
            this.setActive(false);
        }
        super.update(l);
    }

    
}
