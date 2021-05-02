
package Animations;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;

public class FallingDeadMario extends Sprite {

    int Gravity = -15 ;

    int delay  = 50 ;
    
    Mario game ;
    
    public FallingDeadMario(double x, double y, Mario g ) {
        
        game = g ;
        
        this.setLocation(x, y);
        
        this.setImage(game.bsLoader.getStoredImage("SmallDeadMario"));

    }
  
    public void update(long l){

        
        if(delay < 0 ){
            if(Gravity < 20){
                Gravity = Gravity + 1;
                
            }
            
            this.moveY(Gravity);
            
        }else{
            delay-- ;
        }
//            this.moveX(XSpeed);
            
            if(this.getY() > 700 ){
                this.setActive(false);
                game.Restart();
            }
            
            super.update(l);
    }
    
}
