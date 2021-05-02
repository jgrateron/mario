
package Lifts;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;


class BalenceLiftChild extends Sprite implements BasicLift{

    boolean MarioOnLift = false ;

    Mario game ;

    BalenceLiftParent Parent ;
    
    
    int MaxY = 3*32 ;
    int MinY = 11*32 ;
    private int SpeedY = 0;
    private boolean Break;
    
    Sprite SpriteBlackBoxes ;
     
    
    public BalenceLiftChild(int x, int y , Mario g , BalenceLiftParent parent) {
        
        game = g ;
        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6 ));
        this.setLocation(x, y+(2*32));
        
//        System.out.println( " x = " + x*32 + " y = " +y+(2*32) );
        // now make another Lift
        
        Parent = parent ;
        
         AddChain();
        AddBlackBoxes();
    }


    public void update(long elapsedTime) {
        
        if(this.getY() < MaxY){
            this.Break();
            this.Parent.Break();
        }
        if(this.getY() > MinY){
            this.Break();
            this.Parent.Break();
        }
        
        
        if(MarioOnLift){
            SpeedY++ ;
            
            if(SpeedY >60){
                SpeedY=60 ;
            }
            game.player.moveY(SpeedY/12);
            this.moveY(SpeedY/12);
            
            this.Parent.moveY(-SpeedY/12);
//            game.player.moveX(this.getOldX() - this.getX() );
            MarioOnLift = false ;
        }else
        
        if(!MarioOnLift){
            
            if(SpeedY > 0){
                SpeedY--;
            }
            this.Parent.moveY(-SpeedY/12);
            this.moveY(SpeedY/12);
        }
        
        SpriteBlackBoxes.setY(this.getY());
        super.update(elapsedTime);
    }
        public boolean OnLift() {
        return MarioOnLift ;
    }
    
    public void MarioIsOnLift() {
        MarioOnLift  = true;
    }

    void Break() {
        Break = true ;
    }
        private void AddChain() {
        
        BufferedImage Chain = ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, 15*32);
        
        game.BackGroundSpriteGroup.add(new Sprite(Chain, this.getX()+32 , 3*32));
        
        
    }

    private void AddBlackBoxes() {
        BufferedImage BlackBoxes ;
        
        if("Blue".equals(game.CurrentLevel.BackGroundColor)){
         BlackBoxes = ImageUtil.createImage( 32, 15*32 , game.BackGroundColor);
        }else {
         BlackBoxes = ImageUtil.createImage( 32, 15*32 );
        }
        SpriteBlackBoxes = new Sprite(BlackBoxes, this.getX()+32 , this.getY()) ;
        
        
        game.BackGroundSpriteGroup.add(SpriteBlackBoxes);
        
        
        
    }
}
