/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization;

/**
 *
 * @author User
 */



public class CollisionBox {
    
    private Min min;
    private Max max;
    
    public class Min{
        public int x;
        public int y;
        
        public Min(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    
    public class Max{
        public int x;
        public int y;
        
        public Max(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public enum CollisionType{
        NONE,
        TRIGGER,
        BLOCK,
        CONTAIN;
    }
    
    public CollisionBox(){
        
    }
    
    public CollisionBox(int min_x, int min_y, int max_x, int max_y){
        min = new Min(min_x, min_y);
        max = new Max(max_x, max_y);
    }
    
    public Min getMin(){
        return min;
    }
    
    public Max getMax(){
        return max;
    }
    
    public static boolean isCollision(CollisionBox box_a, CollisionBox box_b){
        return !(box_a.max.x < box_b.min.x || box_a.min.x > box_b.max.x ||
                box_a.max.y < box_b.min.y || box_a.min.y > box_b.max.y
                );
    }
    
}
