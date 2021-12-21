package kosinov;

import java.util.ArrayList;


public class ZavadskiyHelper {

    private static int mean = 0;
    public static void start(StringBuilder ln) {
        if(ln == null) {
            throw new NullPointerException("line is null");
        }
        clottingSpace(ln);
        ArrayList<StringBuilder> line = findArray(ln);
        task(line);
    }

    static private ArrayList<StringBuilder> findArray(StringBuilder ln){
        ArrayList<StringBuilder> line = new ArrayList<StringBuilder>();
        ArrayList<Integer> IndexSpace = new ArrayList<Integer>();
        int length = ln.length();
        for (int i = 0; i<length;i++) {
            if(ln.charAt(i)==' ')
                IndexSpace.add(i);
        }
        if(IndexSpace.size() == 0) {
            line.add(new StringBuilder(ln));
        }
        else
        {
            line.add(new StringBuilder(ln.substring(0, IndexSpace.get(0))));
            IndexSpace.add(length);
            for(int i=1;i<IndexSpace.size();i++) {

                if(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))!="")
                    line.add(new StringBuilder(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))));
            }
        }
        return line;
    }



    static private StringBuilder clottingSpace(StringBuilder line) {

        for(int i = 0; i< line.length()-1;i++)
        {
            if(line.charAt(i)==' '&&line.charAt(i+1)==' ') {
                line.deleteCharAt(i+1);
                i--;
            }
        }
        if(line.charAt(line.length()-1)==' ')
            line.deleteCharAt(line.length()-1);
        if(line.charAt(0)==' ')
            line.deleteCharAt(0);
        System.out.println(line);
        return line;
    }

    static private void task(ArrayList<StringBuilder> line)
    {
        int size =0;
        int count;
        for (StringBuilder strB: line) {
            size += strB.length();
        }
        count = size;
        int[] array_numbers = new int [count];
        int i=0;
        for (StringBuilder strB : line) {
            size = strB.length();
            char[] arr = new char[size];
            strB.getChars(0, size,arr,0);
            for (char el : arr) {
                if((int)el >=97 && (int)el<= 122)
                {
                    array_numbers[i] = (int)el;
                    array_numbers[i] -=96;
                }
                else if((int)el >=65 && (int)el<= 90)
                {
                    array_numbers[i] = (int)el;
                    array_numbers[i] -=64;
                }
                i++;
            }

        }
        i=0;
        char[] arrALL = new char[count];
        for (StringBuilder strB : line) {
            size = strB.length();
            strB.getChars(0, size, arrALL, i);
            i+=size ;
        }
        for (char c : arrALL) {
            System.out.print(c+"  ");
        }
        System.out.println("\n");
        for (int c : array_numbers) {
            System.out.print(c+"  ");
        }

    }
}
