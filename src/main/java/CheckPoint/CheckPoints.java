
package CheckPoint;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Sprite;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class CheckPoints extends Sprite implements BasicCheckPoints{

    public int NextLevel ;
    
    public Point NextLocation ; 
    
    
    
    public CheckPoints( double x, double y , int NextLevel, Point NextLocation  ) {
        super(x, y);
        this.NextLevel = NextLevel;
        this.NextLocation = NextLocation;
//        this.MarioStatus = MarioStatus;
        // System.out.println(x +" "+ y);
        this.setID(23);
        
    }


    public void update(long elapsedTime) {
        super.update(elapsedTime);
    }

    public int GetNextLevel() {
        return NextLevel ;
    }

    public Point GetNextLocation() {
        return NextLocation;
    }


    
}
