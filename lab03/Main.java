
import java.util.Scanner; // импорт сканнера

public class Main   {
    public static void main(String args[]) {
        Scanner wk_string = new Scanner(System.in); //creating scanner 
        System.out.println("\nEnter string:"); 
        String source = wk_string.nextLine(); //creating string  and scanning input 
        String ecruos = "";
        for (String part : source.split(" ")) {
            ecruos = new StringBuilder(part).reverse().toString();
            for (String part2 : source.split(" ")) {
                if (part2.compareTo(ecruos) == 0) {
                    System.out.println(part + " --- " + ecruos);
                    break;}
            }
        }
    }
}
     