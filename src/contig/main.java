package contig;

import java.util.*;

public class main {

    static private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
    Vector<Integer> vector = new Vector<>();
        System.out.print("Enter Number of Block which each one of them have 1-KB:");
        int N = input.nextInt();
        //disk D = new disk(N);
        foldercont f = new foldercont(N);
        FolderLinked fl = new FolderLinked(N);
        FolderIndex f2 = new FolderIndex(N);
        int check = 0;
         String command = "" ;
        while (true) {
            System.out.println("1-for Cont 2-liked 3-indexed 4-Close Prog");
            check = input.nextInt();
             if(check==4)
                break;
            command="";
            while(!command.equals("Exit")){
            System.out.print("Command: ");
            System.out.flush();

             command = input.next();
        String[] splited = command.split("\\\\s+");
        //System.out.println(splited.length);
        
        //CreateFolder-root/amr
        //CreateFolder-root/fahmy
        //DisplayDiskStructure
        //DeleteFolder
        //creat folder
            if (splited[0].equals("CreateFolder")&&check==1) {
                System.out.print("Enter the start then the length of file:  ");
                String[] splited2 = splited[1].split("/") ;
                foldercont FOLDER = new foldercont(splited2[splited2.length-1],input.nextInt(),input.nextInt(),0) ;
                f.addfolder(splited[1], FOLDER);
            }
            else if (splited[0].equals("CreateFolder")&&check==2) {
                System.out.println("Enter Number of Block: ");
                int v = input.nextInt();
                int []arr = new int[v] ;
                System.out.println("Enter The Values: ");    
                for(int i=0;i<v;i++)
                {
                    arr[i]=input.nextInt();
                }
                
                String[] splited2 = splited[1].split("/") ;
                FolderLinked FOLDER = new FolderLinked(splited2[splited2.length-1],arr,0) ;
                fl.addfolder(splited[1], FOLDER);
            }
             
            else if (splited[0].equals("CreateFolder")&&check==3) {
                System.out.println("Enter Number of Block: ");
                int v = input.nextInt();
                int []arr = new int[v] ;
                System.out.println("Enter The Values: ");    
                for(int i=0;i<v;i++)
                {
                    arr[i]=input.nextInt();
                }
                
                String[] splited2 = splited[1].split("/") ;
                FolderIndex FOLDER = new FolderIndex(splited2[splited2.length-1],arr,0) ;
                f2.addfolder(splited[1], FOLDER);
            }
             
             
             
        // creat file
            else if (splited[0].equals("CreateFile")&&check==1) {
                System.out.print("Enter the start then the size of file:  ");
                String[] splited2 = splited[1].split("/") ;
                FilesInterface Addfile = new FilesInterface(splited2[splited2.length-1],input.nextInt(),input.nextInt(),0) ;
                
                f.addfile(splited[1], Addfile);
            }
              else if (splited[0].equals("CreateFile")&&check==2) {
                System.out.print("Enter Number of Block: ");
                int v = input.nextInt();
                int []arr = new int[v] ;
                
                for(int i=0;i<v;i++)
                {
                    arr[i]=input.nextInt();
                }
                
                String[] splited2 = splited[1].split("/") ;
                FilesInterfaceLinker Addfile = new FilesInterfaceLinker(splited2[splited2.length-1],arr,0) ;
                
                fl.addfile(splited[1], Addfile);
            }
            else if (splited[0].equals("CreateFile")&&check==3) {
                System.out.print("Enter Number of Block: ");
                int v = input.nextInt();
                int []arr = new int[v] ;
                
                for(int i=0;i<v;i++)
                {
                    arr[i]=input.nextInt();
                }
                
                String[] splited2 = splited[1].split("/") ;
                FilesInterfaceLinker Addfile = new FilesInterfaceLinker(splited2[splited2.length-1],arr,0) ;
                
                f2.addfile(splited[1], Addfile);
            }  
              
              
              
              
            //delete file
            else if(splited[0].equals("DeleteFile")&&check==1){
                f.DeleteFile(splited[1]);
            }
            else if(splited[0].equals("DeleteFile")&&check==2){
                fl.DeleteFile(splited[1]);
            }
            else if(splited[0].equals("DeleteFile")&&check==3){
                f2.DeleteFile(splited[1]);
            }
            //delete folder
            else if(splited[0].equals("DeleteFolder")&&check==1)
            {
                f.DeleteFolder(splited[1]) ;
            }
              else if(splited[0].equals("DeleteFolder")&&check==2)
            {
                fl.DeleteFolder(splited[1]+"/fake") ;
            }
               else if(splited[0].equals("DeleteFolder")&&check==3)
            {
                fl.DeleteFolder(splited[1]+"/fake") ;
            }
              
              
              
              
              
              
            //print
            else if(splited[0].equals("DisplayDiskStructure")&&check==1) 
            {
                f.print();
            }
            else if(splited[0].equals("DisplayDiskStructure")&&check==2) 
            {
                fl.print();
            }
             else if(splited[0].equals("DisplayDiskStructure")&&check==3) 
            {
                fl.print();
            }
            else    
                System.out.println("Wrong Syntax");

        }
           
        }
    }

}
