
package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;


public class MovingTurtelShell extends Sprite implements BasicEnemy{

    boolean PositiveX = true ;
    
    Mario game ;
    
    public int Gravity = 6;

    boolean Standing = true ;
    
    public boolean Green = true ;
    
    String Color  ;
    
    public MovingTurtelShell(double x, double y, Mario g, boolean b , boolean legsDown , boolean isGreen , String color ) {
        super( x , y  );
        Color = color ;
        this.setID(104);
        Standing = legsDown ;
        PositiveX = b ;
        
        game = g ;
        Green = isGreen ;
        
        if(Standing){
            if(Green){
                if(Color.equals("normal")){
                this.setImage(game.bsLoader.getStoredImage("TurtelShell"));
                }else{
                this.setImage(game.bsLoader.getStoredImage("TurtelShelldark"));
                }
            }else{
                this.setImage(game.bsLoader.getStoredImage("TurtelShellRed"));
            }
            
        }else{
            if(Green){
                if(Color.equals("normal")){
                this.setImage(game.bsLoader.getStoredImage("TurtelShellFilp"));
                }else{
                this.setImage(game.bsLoader.getStoredImage("TurtelShellFilpdark"));
                }
            }else{
            this.setImage(game.bsLoader.getStoredImage("TurtelShellFilpRed"));
            }
        }
        
    }


     public void update(long l){
        moveY(Gravity);
        if(PositiveX){
        moveX(-9);
        }else {
        moveX(9); 
        }
        super.update(l);
    }
            
    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true ;
        if(this.getScreenX() > -500 & this.getScreenX() < 1200){
        game.playSound("music/smb_bump.wav");
        }
        
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX = false ;
        if(this.getScreenX() > -500 & this.getScreenX() < 1200){
        game.playSound("music/smb_bump.wav");
        }
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        
        game.player.Jump(-8);
        
        if(Standing){
            game.EnemyGroup.add(new TurtelShell(this.getX() , this.getY()   , game , this.MariotoRight() , this.Standing , this.Green , Color));
        }else{
            game.EnemyGroup.add(new TurtelShell(this.getX() , this.getY()  , game , this.MariotoRight() , this.Standing, this.Green , Color ));
        }
        

        this.setActive(false);
    }



    public void KilledByFireBall() {
        
        game.playSound("music/smb_kick.wav");
        
        if(this.Green){
            if(Color.equals("normal")){
                game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , game.bsLoader.getStoredImage("TurtelShell") , MariotoRight()));
                }else{
                game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , game.bsLoader.getStoredImage("TurtelShelldark") , MariotoRight()));
                }
            
        
            
        }else{
        game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , game.bsLoader.getStoredImage("TurtelShellRed") , MariotoRight()));
        }
        this.setActive(false);
        
    }

    public void bounce() {
        Gravity = 6;
    }

    public void setYloc(double d) {
        this.setY(d);
    }

    public void CollidedWithShell() {
        
    }

    public void CollidedWithMovingShell() {
        KilledByFireBall();
        
    }

    public void OtherEnemyTouchedFromRight() {
        
    }

    public void OtherEnemyTouchedFromLeft() {
       
    }

    public void CollidedWithMarioFromTOLeft() {
        if(game.player.HasStar()){
        KilledByFireBall();
        }else{
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if(game.player.HasStar()){
        KilledByFireBall();
        }else{
            game.player.Decerease();
        }
    }

    public void EnemyJumperOnMario() {
        if(game.player.HasStar()){
        KilledByFireBall();
        }else{
        game.player.Decerease();
        }
    }

    public int Life() {
        return 0 ;
    }

    public void CollidedWithJumping_Brick() {
        if(PositiveX ){     // invert direction
            PositiveX = false ;
        }else{
            PositiveX = true ;
        }
        
        bounce();
    }
    
        public boolean MariotoRight() {
        boolean positive ;
        if(game.player.getX() < this.getX()){
            positive = false ;
        }else{
            positive = true ;
        }
        
        return positive;
    }
    
}

