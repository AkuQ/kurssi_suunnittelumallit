
package prototype;

public class Main {
    public static void main(String[] args) {
        int one_and_half_hours = (int)(1.5*60*60);
        
        System.out.println("Incrementing original:");
        
        Clock clock90mins = new Clock();
        for(int i = 0; i < one_and_half_hours; i++)
            clock90mins.tick();
        
        System.out.print("Original clock ");
        clock90mins.print();
        
        System.out.println("\nIncrementing copy:");
        
        Clock clock180mins = clock90mins.clone();
         for(int i = 0; i < one_and_half_hours; i++)
            clock180mins.tick();
         
        System.out.print("Original clock ");
        clock90mins.print();
        System.out.print("Copied clock ");
        clock180mins.print();
        
    }
}
