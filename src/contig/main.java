package contig;

import java.util.*;
import javax.swing.JOptionPane;

public class main {
//    public static int check , N ;
//    public static int start_con , end_con;
//    public static int size_linked , arr_linked[] ;
//    public static int size_indexed , arr_indexed[] ;
//    public static String command ;
    static private Scanner input = new Scanner(System.in);
//    public void go(int sel , String str,int n)
//    {
//        check = sel ;
//        command = str ;
//        N=n ;   
//    }
//    public void Cont(int s , int e)
//    {
//        start_con = s ;
//        end_con = e ;
//    }
//     public void linked(int s , int e[])
//    {
//        size_linked = s ;
//        arr_linked= new int [size_linked] ;
//        arr_linked=e ;
//    }
//          public void indexed(int s , int e[])
//    {
//        size_linked = s ;
//        arr_indexed= new int [size_indexed] ;
//        arr_indexed=e ;
//    }
    public static void main(String[] args) {
//        form obj = new form();
//        obj.setVisible(true);

      System.out.print("Enter Number of Block which each one of them have 1-KB:");
      int N = input.nextInt();
        foldercont f = new foldercont(N);
        FolderLinked fl = new FolderLinked(N);
        FolderIndex f2 = new FolderIndex(N);
        int check = 0;
         String command = "" ;
        while (true) {
            System.out.println("1-con 2-linked 3-index");
            check = input.nextInt();
            while(!command.equals("Exit")){
              
            System.out.print("Command: ");
            command=input.next();
//            System.out.flush();

        String[] splited = command.split("-");

        //create folder
            if (splited[0].equals("CreateFolder")&&check==1) {
                String[] splited2 = splited[1].split("/") ;
                System.out.println("Enter the start then end");
                int start_con = input.nextInt();
                int end_con = input.nextInt();
                foldercont FOLDER = new foldercont(splited2[splited2.length-1],start_con,end_con,0) ;
               System.out.println( f.addfolder(splited[1], FOLDER));
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
                System.out.println(fl.addfolder(splited[1], FOLDER));
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
                System.out.println(f2.addfolder(splited[1], FOLDER));
            }
             
             
             
        // creat file
            else if (splited[0].equals("CreateFile")&&check==1) {
                System.out.print("Enter the start then the size of file:  ");
                int start = input.nextInt();
                int end = input.nextInt();
                String[] splited2 = splited[1].split("/") ;
                FilesInterface Addfile = new FilesInterface(splited2[splited2.length-1],start,end,0) ;
                
               System.out.println(f.addfile(splited[1], Addfile));
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
                
                System.out.println(fl.addfile(splited[1], Addfile));
            }
            else if (splited[0].equals("CreateFile")&&check==3) {
                System.out.print("Enter Number of Block: ");
                int v = input.nextInt();
                int []arr = new int[v] ;
                
                for(int i=0;i<v;i++)
                {
                    arr[i]=input.nextInt();
                }
//                
                String[] splited2 = splited[1].split("/") ;
                FilesInterfaceLinker Addfile = new FilesInterfaceLinker(splited2[splited2.length-1],arr,0) ;
                
                System.out.println(f2.addfile(splited[1], Addfile));
            }  
              
              
              
              
            //delete file
            else if(splited[0].equals("DeleteFile")&&check==1){
               System.out.println(f.DeleteFile(splited[1]));
            }
            else if(splited[0].equals("DeleteFile")&&check==2){
               System.out.println(fl.DeleteFile(splited[1]));
            }
            else if(splited[0].equals("DeleteFile")&&check==3){
               System.out.println(f2.DeleteFile(splited[1]));
            }
            
            
            //delete folder
            else if(splited[0].equals("DeleteFolder")&&check==1)
            {
                System.out.println(f.DeleteFolder(splited[1])) ;
            }
              else if(splited[0].equals("DeleteFolder")&&check==2)
            {
                System.out.println(fl.DeleteFolder(splited[1])) ;
            }
               else if(splited[0].equals("DeleteFolder")&&check==3)
            {
                System.out.println(f2.DeleteFolder(splited[1])) ;
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
                f2.print();
            }
             
             
             //print Status
              else if(splited[0].equals("DisplayDiskStatus")&&check==1) 
            {
                f.printSt();
            }
            else if(splited[0].equals("DisplayDiskStatus")&&check==2) 
            {
                fl.printSt();
            }
             else if(splited[0].equals("DisplayDiskStatus")&&check==3) 
            {
                f2.printSt();
            }
//            else
//                System.out.println("Wrong Syntax");
        }      
        }
    }
}
