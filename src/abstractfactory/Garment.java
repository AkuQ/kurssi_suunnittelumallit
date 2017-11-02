
package abstractfactory;

public abstract class Garment {
    String type;
    double price;
    
    public Garment(types type, double price){
        this.type = type.toString();
        this.price = price;
    }
    
    public double getPrice() { return price; }
    public String getType() { return type; }
    public abstract String getManufacturer();
    
    public String toString(){
        String price = String.format("%.2f", getPrice());
        return getManufacturer() + " " + getType() + ", $" + price;
    }
    
    public enum types {
        HAT("Hat"), SHIRT("Shirt"), PANTS("Pants"), SHOES("Shoes");
        
        private final String name;
        types(String name) { this.name = name; }
        
        @Override
        public String toString() { return name; }
    };
}
