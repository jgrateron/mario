/*
 * Copyright (c) 2008 Golden T Studios.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.golden.gamedev.object.sprite;

// JFC
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

/**
 * One time animation sprite, the sprite is animated once, and then disappeared,
 * suitable for explosion type sprite.
 */
public class VolatileSingleImage extends Sprite {
	
	/** ************************************************************************* */
	/** ***************************** CONSTRUCTOR ******************************* */
	/** ************************************************************************* */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3599186946035433218L;
	
	/**
	 * Creates new <code>VolatileSprite</code>.
	 */
        
        int Life = 0 ;
        
	public VolatileSingleImage(BufferedImage image, double x, double y , int Alive) {
		super(image, x, y);
                Life = Alive ;
		
	}
	
	/** ************************************************************************* */
	/** ************************* UPDATE SPRITE ********************************* */
	/** ************************************************************************* */
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		Life--;
		if ( Life < 0) {
			this.setActive(false);
		}
	}
	
}
