
package album;

import java.util.ArrayList;


public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> stringList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            stringList.set(3, "String posição 2");
            System.out.println("stringList.get(3) = " + stringList.get(3));
        }
        
    }
}