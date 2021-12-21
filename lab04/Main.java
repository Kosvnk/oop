import java.util.Scanner; // импорт сканнера

public class Main   {
         public static void debug(String part,String ecruos, String part2) {
             System.out.println("Current part:" + part);
             System.out.println("Current reversed word:" +ecruos); 
             System.out.println("Current part2:" + part2);
         }

         private static  void help() {
             System.out.println("@author : Kosinov Vladyslav CIT-120B\nversion : 9.9.3\nPurpose:Enter text. Find reverse words. Print the result as follows:") ;
             System.out.println("word --- reversed word");
             System.out.println("");
         System.out.println("1) Allows you to enter your data ;\n2)Allows you to check data that saves in program;\n3)Doing all operations over your data and saves result;\n4)Showing results of mathematic operations;");
     }


    public static void main(String args[]) {
        String arg = args[0];
        if (arg.equals("-h") || arg.equals("-help")) {
            help();
        }
        Scanner menu_in = new Scanner(System.in);
        Scanner wk_string = new Scanner(System.in); //creating scanner 
        System.out.println("\nEnter string:"); 
        String source = wk_string.nextLine(); //creating string  and scanning input 
        char[] wk_char = source.toCharArray();
        String ecruos = "";
        int menu = -1;
        while (menu!=0) {
            System.out.println("Choose task: \n1. Enter new string\n2. Check data\n3. Calculate\n4. Show result\n0. Exit\n");
            menu = menu_in.nextInt();
            switch (menu) {
                case 1: 
                    System.out.println("\nEnter string:"); 
                    source = wk_string.nextLine(); //creating string  and scanning input 
                    break;
                case 2:
                    System.out.println("\n" + source + "\n");
                    break;
                case 3:
                    for (String part : source.split(" ")) {
                        ecruos = new StringBuilder(part).reverse().toString();
                        for (String part2 : source.split(" ")) {
                            if (part2.compareTo(ecruos) == 0) {
                                if (arg.equals("-d") || arg.equals("-debug")){
                                    debug(part,ecruos,part2);
                                }
                                break;
                            }
                        }   
                    }
                    break;
                case 4:
                    for (String part : source.split(" ")) {
                        ecruos = new StringBuilder(part).reverse().toString();
                        for (String part2 : source.split(" ")) {
                            if (part2.compareTo(ecruos) == 0) {
                                System.out.println(part + " --- " + ecruos);
                                break;
                            }
                        }   
                    }
                    break;
            }
        }
    }
}

