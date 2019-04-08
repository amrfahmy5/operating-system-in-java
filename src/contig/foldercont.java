package contig;

import java.util.*;
import javax.swing.JOptionPane;

public class foldercont {

    String name;
    int start;
    int size;
    int level ;
    Vector<FilesInterface> fi = new Vector();
    Vector<foldercont> children = new Vector();
    String[] splited;
    diskcont di ;
    public foldercont(String name, int start, int size,int level) {
        this.name = name;
        this.size = size;
        this.start = start;
        this.level=level ;
    }

    public foldercont(int N) {
        foldercont root = new foldercont("root", 0, N,0);
        this.children.add(root);
        di = new diskcont(N);
    }

    public foldercont getaddress(String address) {
        foldercont f = children.elementAt(0);

        splited = address.split("/");
        //System.out.println(splited[1]);
        if (splited[0].equals("root")) {
            for (int i = 1; i < splited.length - 1; i++) {
                foldercont newfolder = getchildren(splited[i], f);
                if (f.equals(newfolder)) {
                    return null;
                }
                f = newfolder;
            }
            f.level=splited.length ;
            return f;
        } else {
            return null;
        }
    }

    public foldercont getchildren(String address, foldercont f) {
        for (int i = 0; i < f.children.size(); i++) {

            if (f.children.get(i).name.equals(address)) {
                return f.children.elementAt(i);
            }
        }
        return f;
    }

    public String DeleteFolder(String address) {
        String[] S = address.split("/");
        
     //   System.out.println(address);
        address = "";
        for (int i = 0; i < S.length - 1; i++) {
            address += S[i];
            address += "/";
        }
        foldercont f = getaddress(address);
       // System.out.println(address+" "+S[S.length - 1]);
        if (f != null) {
            for (int i = 0; i < f.children.size(); i++) {
                if (f.children.elementAt(i).name.equals(S[S.length - 1])) {
                    di.delete(f.children.elementAt(i).start, f.children.elementAt(i).size);
                    // f.fi.remove(f);
                    f.children.remove(i);
                    
                     
                    return("Folder Deleted !");
                }
            }
        } else {
            return("No Folder With This Name");
        }
        return("Folder Deleted !");
    }

    public String DeleteFile(String address) {
        foldercont f = getaddress(address);
        if (f != null) {
            FilesInterface target = null;
            for (int i = 0; i < f.fi.size(); i++) {
                if (f.fi.elementAt(i).name.equals(splited[splited.length - 1])) {
                    target = f.fi.elementAt(i);
                }
            }
            if (target == null) {
                return("Not Files Found With this Name");
            } else {
               di.delete(target.Start, target.size);
                f.fi.remove(target);
                return("File Deleted !");
            }
        } else {
            return("No File With This Name");
        }
    }

    public String addfolder(String address, foldercont fo) {
        boolean flag = false;
        foldercont parent = getaddress(address);
        if (parent != null) {
               if (di.check(fo.start, fo.size)) {
                for (int i = 0; i < parent.children.size(); i++) {
                   
                    if (parent.children.elementAt(i).equals(fo.name)) {
                        flag = true;
                        break ;
                    }
                }
                if (flag == true) {
                    return("Have File With Same Name");
                } else {
                   // di.add(fo.start, fo.size);
                    fo.level=parent.level+1;
                    parent.children.add(fo);
                    di.add(fo.start, fo.size);
                    return("Folder Added !");
                }
            } 
               else {
                return("This Place Are Stored Befor");
            }

        }
        
        else {
            return("No Folder With This Name2");
        }
    }

    
    
     public String addfile(String address, FilesInterface fil) {
         boolean flag = false ;
        foldercont parent = getaddress(address);
        if (parent != null) {

            if (di.check(fil.Start, fil.size)) 
            {
             //   System.out.println(fil.name);
                   for (int i = 0; i < parent.fi.size(); i++) {
                  //   System.out.println(parent.fi.elementAt(i).name);
                    if (parent.fi.elementAt(i).equals(fil.name)) {
                        flag = true;
                        break ;
                    }
                }
                    if(flag == true)
                        return("Have Folder With this Name");
                    else{
                    fil.level=parent.level+1;
                    parent.fi.add(fil);
                    di.add(fil.Start,fil.size);
                    return("File Added !");
                    }
                }
            else
                return("Space are stored befor!");

            }
         else {
            return("No Folder With This Name1");
        }
    }
     public String getspace(FilesInterface f)
     {
         String arr = "";
         for(int i=0 ; i<f.level;i++)
             arr += "\t";
         return arr ;
     }
          public String getspace(foldercont f)
     {
         String arr = "";
         for(int i=0 ; i<f.level;i++)
             arr += "\t";
         return arr ;
     }
    public void print() {
        for (int i = 0; i < fi.size(); i++) {
        //    System.out.println(getspace(fi.elementAt(i))+fi.elementAt(i).name);
        }
        for (int i = 0; i < children.size(); i++) {
       //     System.out.println(getspace(children.elementAt(i))+"<" + children.elementAt(i).name + ">");
            children.elementAt(i).print();
        }
    }
    public void printSt()
    {
        di.print();
    }
}
