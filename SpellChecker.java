import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.charset.*; 
import java.nio.file.Files;

public class SpellChecker {

  static String fileName = "text1.txt";
  static String fileName2 = "Dictionary.txt"; 


  public static void main(String[] args)  {



    String[] arrayStrings  = convertTxtToArray(fileName);
    String[] arrayStrings2  = convertTxtToArray(fileName2);

    System.out.println(arrayStrings[2]);


    try {
       List<String> list = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

       String[] a = list.toArray(new String[list.size()]); 
     


   } catch (IOException e) {
      System.out.println(e);
  }

}
//compare elements in filename1 to elements in filename2 
public static String[] compareTo (String[] filename, String[] filename2){
    String counter[] = new String[];
    
  for(int i = 0; i < filename.length; i++) {
        if(filename[i]==filename2[i]) counter[0]++;
        else {
            for (int n = 0; n < filename.length; n++) {
                if (filename[i] == filename2[n] && filename[n] != filename2[n]) {
                    counter[1]++;
                    break;
                }
            }
        }
    }
    return counter;
}
//function that connverts text1.txt and Dictionary.txt to arrays
public static String[] convertTxtToArray(String filename){
 ArrayList<String> lines = new ArrayList<String>();
 String[] lineArray ;

 try{
     FileReader fin = new FileReader(fileName);
     Scanner src = new Scanner(fin).useDelimiter(",| ");

     while (src.hasNext()) {

        String input = src.nextLine();
        String[] values = input.split(" ");

        for(String val: values)
        {
            lines.add(val);

        }
        
    // replace above line with array
    }
}

catch (IOException e){

}
lineArray = new String[lines.size()];

return  lines.toArray(lineArray);


}

}
