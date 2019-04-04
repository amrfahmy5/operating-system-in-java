package contig;

import java.util.*;

public class Contig {

    static private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Number of Block which each one of them have 1-KB:");
        int N = input.nextInt();
        //disk D = new disk(N);
        folder f = new folder(N);
        
        while (true) {
            System.out.print("Command: ");
            String command = input.next();
        String[] splited = command.split("-");
        System.out.println(splited.length);
        
        //CreateFolder-root/amr/fahmy
        //creat folder
            if (splited[0].equals("CreateFolder")) {
                System.out.print("Enter the start then the length of file:  ");
                String[] splited2 = splited[1].split("/") ;
                folder FOLDER = new folder(splited2[splited2.length-1],input.nextInt(),input.nextInt(),0) ;

                f.addfolder(splited[1], FOLDER);
            }
            
        // creat file
            else if (splited[0].equals("CreateFile")) {
                System.out.print("Enter the start then the length of file:  ");
                String[] splited2 = splited[1].split("/") ;
                FilesInterface Addfile = new FilesInterface(splited2[splited2.length-1],input.nextInt(),input.nextInt(),0) ;
                
                f.addfile(splited[1], Addfile);
            }
            
            //delete file
            else if(splited[0].equals("DeleteFile")){
                f.DeleteFile(splited[1]);
            }
            
            //delete folder
            else if(splited[0].equals("DeleteFolder"))
            {
                f.DeleteFolder(splited[1]+"/fake") ;
            }
            
            //print
            else if(splited[0].equals("DisplayDiskStructure")) 
            {
                f.print();
            }
            else    
                System.out.println("Wrong Syntax");

        }
    }

}
