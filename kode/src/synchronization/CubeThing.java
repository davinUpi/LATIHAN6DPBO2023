/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author User
 */
public class CubeThing extends GameObject{
    
    public CubeThing(){
        super(0,0,"thing");
        super.setHeight(30);
    }
    
    public CubeThing(int x, int y){
        super(x,y,"thing");
        super.setHeight(30);
    }
    
    @Override
    public void render(Graphics object){
        object.setColor(Color.red);
        object.fillRect(x, y, height, height);
    }
    
    @Override
    public void loop(){
        
    }
    
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
}
