
package Objects;

import Animations.DirectFalling;
import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;
import java.util.Random;


public class FishyGround   extends AnimatedSprite implements BasicEnemy{

    boolean PositiveX = true ;
    
    Mario game ;
    
    double Gravity = -10;
    
    public int XSpeed = 0;

    public FishyGround(int x, int y, BufferedImage[] Enemy_Image, Mario g) {
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);
        game = g ;
        
        this.setID(100);
    }

    public FishyGround(Mario g) {
        game = g ;
        setLocation(game.player.getX(), 480+32);
        
        
        Random r = new Random();
        
        if(r.nextBoolean()){
            PositiveX = true ;
            XSpeed = com.golden.gamedev.util.Utility.getRandom(1, 3);
            setImages(ImageUtil.flipHorizontal(game.bsLoader.getStoredImages("FishRed")));
        }else{
            PositiveX = false ;
            XSpeed = com.golden.gamedev.util.Utility.getRandom(-3, -1);
            setImages(game.bsLoader.getStoredImages("FishRed"));
            
        }
        
        if(XSpeed < 0){
           this.moveX(com.golden.gamedev.util.Utility.getRandom(32*4, 32*8));

        }else{
           this.moveX(com.golden.gamedev.util.Utility.getRandom(-32*8, -32*4));
        }
        
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
//        System.out.println("FishyGround");
    }

        public void update(long l){
            
            if(Gravity < 10){
                Gravity = Gravity + 0.1 ;
            }
            
        moveY(Gravity);
//        this.setX(this.getScreenX() + game.playfield.getBackground().getX()  );
        moveX(XSpeed + (game.player.speed/20) );
        
        if(this.getY() > 576 || this.getScreenX() < -32 || this.getScreenX() > 640){
            this.setActive(false);
//            game.FlyingFishesGroup.removeImmutableSprites();
        }
       
        
        super.update(l);
    }
        
    public void MarioJumpedOnEnemy() {
        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        this.setActive(false);
        
    }



    public void KilledByFireBall() {
        game.playSound("music/smb_kick.wav");
        game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , this.getImage() , MariotoRight() ));
        this.setActive(false);
        System.out.println("Asd");
    }

    public void bounce() {
    }

    public void setYloc(double d) {
    }

    public void CollidedWithShell() {
        // change direction
    }

    public int getType() {
        return this.getID();
    }

    public void CollidedWithMovingShell() {
        KilledByFireBall();
    }

    public void CollidedWithBrick_GoToLeft() {
    }

    public void CollidedWithBrick_GoToRight() {
        
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
        return 0;
    }

    public void CollidedWithJumping_Brick() {
        
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
