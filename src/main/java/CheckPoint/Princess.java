
package CheckPoint;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.Timer;
import java.awt.Point;

public class Princess extends CheckPoints{

    
    public Princess( double x, double y , int NextLevel, Point NextLocation  ) {
        super(x, y+16 , NextLevel , NextLocation);
        this.NextLevel = NextLevel;
        this.NextLocation = NextLocation;
//        this.MarioStatus = MarioStatus;
        // System.out.println(x +" "+ y);
        this.setID(26);
        
        
    }



    public int GetNextLevel() {
        return NextLevel ;
    }

    public Point GetNextLocation() {
        return NextLocation;
    }

    
}
