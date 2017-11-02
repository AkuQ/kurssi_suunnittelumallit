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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person jaakko = new Person();
        
        jaakko.shopClothes(ClothesFactory.manufacturers.ADIDAS);
        jaakko.printClothes();
        
        System.out.println("---");
        
        jaakko.shopClothes(ClothesFactory.manufacturers.BOSS);
        jaakko.printClothes();
        
    } 
}
