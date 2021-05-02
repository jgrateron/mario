
package Lifts;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;


public class LiftUP  extends Sprite implements BasicLift{

    boolean MarioOnLift = false ;

    Mario game ;
    
    public LiftUP( int x, int y, Mario g) {
        game = g ;
        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6 ));
        this.setLocation(x, y);
    }
    
    public LiftUP( int x, int y, Mario g , int Points) {
        game = g ;
        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), Points ));
        this.setLocation(x+24, y);
    }

   
    public void update(long elapsedTime) {
                
//        // System.out.println("this.getOldX() ="+this.getOldX() +" , x = "+this.getX());
        
        if(this.getY() < -100){
            this.setY(580);
        }
        
        this.moveY(-2);
        
        if(MarioOnLift){
            game.player.moveY(-2);
//            game.player.moveX(this.getOldX() - this.getX() );
            MarioOnLift = false ;
        }
//        this.moveX(1);
//        
//        if(this.getX() > 400){
//            this.setX(100);
//        }
//        
//        if(MarioOnLift){
//            game.player.moveX(1);
//            MarioOnLift = false ;
//        }
        super.update(elapsedTime);
    }
    public boolean OnLift() {
        return MarioOnLift ;
    }
    
    public void MarioIsOnLift() {
        MarioOnLift  = true;
    }
    
}
