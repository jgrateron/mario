
package Lifts;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;

public class LiftFall extends Sprite implements BasicLift{

    boolean MarioOnLift = false ;

    Mario game ;

    public LiftFall( int x, int y, Mario g) {
        game = g ;
        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6 ));
        this.setLocation(x, y);
    }
    
    public LiftFall( int x, int y, Mario g , int Points) {
        game = g ;
        
        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), Points ));
        this.setLocation(x+24, y);
    }
    

   
    public void update(long elapsedTime) {
                
//        // System.out.println("this.getOldX() ="+this.getOldX() +" , x = "+this.getX());

        if(this.getY()>500){
            this.setActive(false);
        }
        if(MarioOnLift){
            this.moveY(4);
            game.player.moveY(4);
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