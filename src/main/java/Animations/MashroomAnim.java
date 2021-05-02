
package Animations;

import Objects.Mashroom;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MashroomAnim extends Sprite {

    int reachPosY ;
    Mario game ;
    
    int GiveSomeTimeToRender = 16 ;
    
    boolean start = false ;
    
    public MashroomAnim(int x, int y, BufferedImage storedImages, Mario M) {
        setLocation(x, y);
        setImage(storedImages);
        reachPosY = y -32 ;
        
        game = M ;
        game.playSound("music/smb_powerup_appears.wav");
        
    }
    
    
    public void update(long l){
        if(GiveSomeTimeToRender > 0){
            GiveSomeTimeToRender--;
            
        }else{
            start = true ;
        }
        
        if(start){
            
        if(this.getY() >= reachPosY ){
            this.moveY(-1);
        }
        else{
            
            game.EnemyGroup.add(new Mashroom((int)this.getX(),reachPosY , game.bsLoader.getStoredImages("Mashrooms") , game));
        
            this.setActive(false);
            
        }
        
        }
    }
    
    
    public void render(Graphics2D g){
        if(start){
            super.render(g);
        }
        
    }
}
