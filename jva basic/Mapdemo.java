
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Mapdemo {
    public static void main(String[] args) {
        Map<String, Integer> marks= new HashMap<>();
        marks.put("tushar", 100);  
        marks.put("simmy", 200);
       for(Map.Entry<String,Integer> entry:marks.entrySet()){
           System.out.println(entry.getKey()+" "+entry.getValue());
       }
    
    Optional<Integer> mark= Optional.ofNullable(marks.get("tushar"));
    System.out.println(mark.orElse(0));
    }
    
}
