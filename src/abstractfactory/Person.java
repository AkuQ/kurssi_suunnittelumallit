/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akseli
 */
public class Person {
    Garment[] clothes;
    
    public Person(){
        clothes = new Garment[0];
    }
    
    public void shopClothes(ClothesFactory.manufacturers manufacturer) {
        try {
            clothes = new Garment[4];
            clothes[0] = ClothesFactory.create(Garment.types.HAT, manufacturer);
            clothes[1] = ClothesFactory.create(Garment.types.SHIRT, manufacturer);
            clothes[2] = ClothesFactory.create(Garment.types.PANTS, manufacturer);
            clothes[3] = ClothesFactory.create(Garment.types.SHOES, manufacturer);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void printClothes(){
        for(Garment g : clothes) {
            System.out.println(g);
        }
    }
}
