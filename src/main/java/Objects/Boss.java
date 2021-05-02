
package Objects;

import Animations.DirectFalling;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;


public class Boss  extends AnimatedSprite implements BasicEnemy{
    
    int Life = 5 ;
    Mario game ;

    int left = 64 ;
    int right = 64 ;
    
    boolean PositiveX  = true ;
    
    int JumpTime = 20 ;
    private int Gravity;
    
    
    int FireThrowTime ;
    private int Delay = 20 ;
    private boolean GoNearMario = false;
    private boolean Hammer = false ;
    private int HammerThrowTime;
    
    int Hammerxspeed ;
    int HammerGravity ; 
    
    int hammerThrown ;
    private int MaxX;
    
    
    public Boss(BufferedImage[] storedImages, int x, int y, Mario g , int maxx) {
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        
        this.setID(119) ;
        game = g ;
        
        left = x - (3*32);
        right = x + (3*32);
        
        JumpTime = com.golden.gamedev.util.Utility.getRandom(3, 6)*20;
        FireThrowTime  = com.golden.gamedev.util.Utility.getRandom(1, 10)*10;
        HammerThrowTime  = com.golden.gamedev.util.Utility.getRandom(1, 10)*10;
        
        MaxX = maxx ;
        
    }

        private void HammerThrow() {
        
        
        HammerThrowTime-- ; 
        
        if(HammerThrowTime < 0 ){
            
            HammerThrowTime  = com.golden.gamedev.util.Utility.getRandom(2, 10)*20;
            
            HammerGravity = com.golden.gamedev.util.Utility.getRandom(-10, -7);
        
            Hammerxspeed =  com.golden.gamedev.util.Utility.getRandom(-4, -2);
        
                
        }
        
    }
        
         private void ContinuousHammerThrow() {
         if(HammerThrowTime < 10 ){
             if(game.player.getX() < this.getX()){ // throw to left hammer
                game.HammerGroup.add(new Hammer(this.getX() , this.getY()  , Hammerxspeed , HammerGravity, game.bsLoader.getStoredImages("BWHammer")));
//            this.setFrame(2);
                System.out.println(hammerThrown++);
            }
         }
    }
    public void update(long l){
        
        if(Hammer){
            HammerThrow();
            
            ContinuousHammerThrow();
        }
        LookAtMario();
        
//        if(this.getY()+this.getHeight() >10*32){
//            this.setY((10*32)-this.getHeight()) ;
//        }
        if(Gravity < 8){
                Gravity = Gravity + 1;
                
            }
        
            moveY(Gravity);
            
        if(GoNearMario){ 
            
            this.moveX(1);
            
        }else{
            
            JumpTime--;
        if(JumpTime < 0){
            Jump();
        }
        
        
        if(this.getX() < left){
            PositiveX  = false ;
        }
        if(this.getX() > right){
            
            PositiveX  = true ;
        
        }
        
        if(PositiveX ){
            
            
            this.moveX(-1);
            
        }else{
            this.moveX(1);
        }
        
        HammerFire();
        }
        
        MarioToRight();
        
        if((this.getX()+this.getWidth()) > MaxX*32){
            this.setX(MaxX*32 - (this.getWidth()));
        }
        super.update(l);
        
        }
    
    public void CollidedWithBrick_GoToLeft() {
    }

    public void CollidedWithBrick_GoToRight() {
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        
        if(game.player.HasStar()){
        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        game.playSound("music/smb_bowserfavlls.wav");
        game.playSound("music/smb_kick.wav");
        this.setActive(false);
        
        for (int i = 0; i < game.EnemyGroup.getSize(); i++) {
            if(game.EnemyGroup.getSprites()[i] != null){
                game.EnemyGroup.getSprites()[i].setActive(false);
            }}
        
        }else{
        game.player.Decerease();
        
        }
    }


    public void KilledByFireBall() {
        Life--;
//        System.out.println(Life);
        
        if(Life < 0){
            game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        game.playSound("music/smb_bowserfalls.wav");
//        game.playSound("music/smb_kick.wav");
            this.setActive(false);
        for (int i = 0; i < game.EnemyGroup.getSize(); i++) {
            if(game.EnemyGroup.getSprites()[i] != null){
                game.EnemyGroup.getSprites()[i].setActive(false);
            }}
        }
    }

    public void bounce() {
    }

    public void setYloc(double d) {
        this.setY(d);
        
    }

    private void LookAtMario() {
        
        
        if(game.player.getX() < this.getX()){ // look at left
            
            
            this.setAnimationFrame(0, 1);
            
        }else{
            
            this.setAnimationFrame(4, 5);
            
        }
    }

    private void Jump() {
        if(game.player.getX() < this.getX()){
        Gravity = -16 ;
        }
        JumpTime = com.golden.gamedev.util.Utility.getRandom(3, 6)*20;
    }



    private void HammerFire() {
        
        
        FireThrowTime-- ; 
        
        if(FireThrowTime < 0 ){
            
            
            
            if(game.player.getX() < this.getX()){
                
                Delay-- ;
                
                this.setAnimationFrame(2, 2);
                
                if(Delay < 0){
                game.HammerGroup.add(new Fire(this.getX() , (this.getY()/32)*32 , game.bsLoader.getStoredImages("Fire")));
//            this.setFrame(2);
                FireThrowTime  = com.golden.gamedev.util.Utility.getRandom(5, 10)*10;
                game.playSound("music/smb_bowserfire.wav");
                Delay = 20 ;
                
                }
            }
        
                
        }
        
    }

    public void CollidedWithShell() {
        
    }

    public void CollidedWithMovingShell() {
        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        game.playSound("music/smb_bowserfalls.wav");
        game.playSound("music/smb_kick.wav");
        this.setActive(false);
    }

    public void OtherEnemyTouchedFromRight() {
    }

    public void OtherEnemyTouchedFromLeft() {
    }

    public void CollidedWithMarioFromTOLeft() {
        if(game.player.HasStar()){
        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        game.playSound("music/smb_bowserfalls.wav");
        game.playSound("music/smb_kick.wav");
        this.setActive(false);
        }else{
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if(game.player.HasStar()){
        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        game.playSound("music/smb_bowserfalls.wav");
        game.playSound("music/smb_kick.wav");
        this.setActive(false);
        }else{
            game.player.Decerease();
        }
    }

    public void EnemyJumperOnMario() {
        MarioJumpedOnEnemy();
    }

    private void MarioToRight() {
        
        if(game.player.getX() > this.getX()){
            
            GoNearMario = true ;
            
        }else{
            GoNearMario = false ;
        }
        
    }

    public int Life() {
        Life-- ;
        return Life ;
    }

    public void BadGameGlitch() {
//        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        this.setActive(false);
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

    public void SetHammer(boolean b) {
        Hammer = true ;
    }

   
}
