import java.util.ArrayList; 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.Map.Entry; 
import java.util.Set; 
public class MapToListExamples {

    public static void main(String[] args) {

        // Creating a HashMap object 
        HashMap<String, String> performanceMap = new HashMap<String, String>(); 
         
        // Adding elements to HashMap 
        performanceMap.put("John Kevin", "Average");  
        performanceMap.put("Ladarious Fernandez", "Very Good"); 
        performanceMap.put("Ivan Jose", "Very Bad"); 
        performanceMap.put("Smith Jacob", "Very Good"); 
        performanceMap.put("Athena Stiltner", "Bad"); 
         
        // Getting Set of keys 
        Set<String> keySet = performanceMap.keySet(); 
         
        // Creating an ArrayList of keys 
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet); 
         
        System.out.println("ArrayList Of Keys :"); 
         
        for (String key : listOfKeys) {
            System.out.println(key); 
        }
                  
        // Getting Collection of values 
        Collection<String> values = performanceMap.values(); 
         
        // Creating an ArrayList of values 
        ArrayList<String> listOfValues = new ArrayList<String>(values); 
         
        System.out.println("ArrayList Of Values :"); 
         
        for (String value : listOfValues) { 
            System.out.println(value); 
        } 
                  
        // Getting the Set of entries 
        Set<Entry<String, String>> entrySet = performanceMap.entrySet(); 
         
        // Creating an ArrayList Of Entry objects 
        ArrayList<Entry<String, String>> listOfEntry = new ArrayList<Entry<String,String>>(entrySet); 
         
        System.out.println("ArrayList of Key-Values :"); 
         
        for (Entry<String, String> entry : listOfEntry) { 
            System.out.println(entry.getKey()+" : "+entry.getValue()); 
        } 
    } 
}