import java.util.Arrays;

public class HashMapTest {

    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 642, 4, 129};

//        HashMap<String> myHashMap = new HashMap<String>();
        HashMap<String> myHashMap = new HashMap<String>();
        myHashMap.put(keys[0], "Caius");  
        myHashMap.put(keys[1], "Lew");
        myHashMap.put(keys[2], "Roza");
        myHashMap.put(keys[3], "Mohammed");
        myHashMap.put(keys[4], "Petronela");
        myHashMap.put(keys[5], "Jacky");

        for(int i = 0; i < keys.length; i++) {
            System.out.println(myHashMap.get(keys[i]));
        }
//        for(int i = 0; i < keys.length; i++) {
//            System.out.println(Arrays.toString(myHashMap.getIt(keys[i])) );
//        }
    }
    
}