
package abstractfactory;

public class Main {

    public static void main(String[] args) {
        Person jaakko = new Person();
        
        jaakko.shopClothes(ClothesFactory.manufacturers.ADIDAS);
        jaakko.printClothes();
        
        System.out.println("---");
        
        jaakko.shopClothes(ClothesFactory.manufacturers.BOSS);
        jaakko.printClothes();
        
    } 
}
