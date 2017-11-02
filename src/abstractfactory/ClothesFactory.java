package abstractfactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Adidas implements ClothesFactory {

    private class AdidasGarment extends Garment {
        public AdidasGarment(types type, double price) {
            super(type, price);
        }
        @Override
        public String getManufacturer() {
            return "Adidas";
        }
    }
    
    @Override
    public Garment createHat() {
        return new AdidasGarment(Garment.types.HAT, 10.0);
    }

    @Override
    public Garment createShirt() {
        return new AdidasGarment(Garment.types.SHIRT, 15.0);
    }

    @Override
    public Garment createPants() {
        return new AdidasGarment(Garment.types.PANTS, 25.0);
    }

    @Override
    public Garment createShoes() {
        return new AdidasGarment(Garment.types.SHOES, 50.0);
    }
}

class Boss implements ClothesFactory {
    
    private class BossGarment extends Garment{
        public BossGarment(types type, double price) {
            super(type, price);
        }
        @Override
        public String getManufacturer() {
            return "Boss";
        }
    
    }

    @Override
    public Garment createHat() {
        return new BossGarment(Garment.types.HAT, 30.0);
    }

    @Override
    public Garment createShirt() {
        return new BossGarment(Garment.types.SHIRT, 35.0);
    }

    @Override
    public Garment createPants() {
        return new BossGarment(Garment.types.PANTS, 55.0);
    }

    @Override
    public Garment createShoes() {
        return new BossGarment(Garment.types.SHOES, 100.0);
    }
}

public interface ClothesFactory {
    
     public enum manufacturers {
        ADIDAS("Adidas"), BOSS("Boss");
        
        private final String name;
        manufacturers(String name) { this.name = name; }
        
        @Override
        public String toString() { return name; }
    };
    
    public static Garment create(Garment.types garment, manufacturers manufacturer) 
            throws 
            ClassNotFoundException, 
            InstantiationException,
            NoSuchMethodException, 
            IllegalAccessException, 
            IllegalArgumentException, 
            InvocationTargetException
    {
        Class factory_cls = Class.forName("suma_abstractfactory." + manufacturer.toString());
        ClothesFactory factory = (ClothesFactory)factory_cls.newInstance();
        Method factory_method = factory_cls.getMethod("create" + garment.toString());
        return (Garment)factory_method.invoke(factory);

    }

    abstract public Garment createHat();
    abstract public Garment createShirt();
    abstract public Garment createPants();
    abstract public Garment createShoes();
}
