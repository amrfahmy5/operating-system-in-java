package contig;

import java.util.*;
//CreateFolder-root/amr

public class folder {

    String name;
    int start;
    int size;
    int level ;
    Vector<FilesInterface> fi = new Vector();
    Vector<folder> children = new Vector();
    String[] splited;
    disk di ;
    public folder(String name, int start, int size,int level) {
        this.name = name;
        this.size = size;
        this.start = start;
        this.level=level ;
    }

    public folder(int N) {
        folder root = new folder("root", 0, N,0);
        this.children.add(root);
        di = new disk(N);
    }

    public folder getaddress(String address) {
        folder f = children.elementAt(0);

        splited = address.split("/");
        //System.out.println(splited[1]);
        if (splited[0].equals("root")) {
            for (int i = 1; i < splited.length - 1; i++) {
                folder newfolder = getchildren(splited[i], f);
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

    public folder getchildren(String address, folder f) {
        for (int i = 0; i < f.children.size(); i++) {

            if (f.children.get(i).name.equals(address)) {
                return f.children.elementAt(i);
            }
        }
        return f;
    }

   


    public void DeleteFolder(String address) {
        folder f = getaddress(address);
        if (f != null) {
            di.delete(f.start, f.size);
            f.fi.remove(f);
            System.out.print("Folder Deleted !");
        } else {
            System.out.println("No Folder With This Name");
        }
    }

    public void DeleteFile(String address) {
        folder f = getaddress(address);
        if (f != null) {
            FilesInterface target = null;
            for (int i = 0; i < f.fi.size(); i++) {
                if (f.fi.elementAt(i).name.equals(splited[splited.length - 1])) {
                    target = f.fi.elementAt(i);
                }
            }
            if (target == null) {
                System.out.println("Not Files Found With this Name");
            } else {
               di.delete(target.Start, target.size);
                f.fi.remove(target);
                System.out.print("File Deleted !");
            }
        } else {
            System.out.println("No File With This Name");
        }
    }

    void addfolder(String address, folder fo) {
        boolean flag = false;
        folder parent = getaddress(address);
        if (parent != null) {
           // System.out.println(parent.start+" "+fo.start+" "+parent.size+" "+fo.size +" "+parent.name);
          // if( (parent.start < fo.start) && ((parent.start + parent.size) > (fo.size + fo.start)))
           if(di.chechboundry(parent.start,fo.start,parent.size,fo.size))
           {
               if (di.check(fo.start, fo.size)) {

                for (int i = 0; i < parent.children.size(); i++) {
                    if (parent.children.elementAt(i).equals(fo.name)) {
                        flag = true;
                    }
                }
                if (flag == true) {
                    System.out.println("Have File With Same Name");
                } else {
                   // di.add(fo.start, fo.size);
                    fo.level=parent.level+1;
                    parent.children.add(fo);
                    System.out.print("Folder Added !");
                }
            } 
               else {
                System.out.println("This Place Are Stored Befor");
            }
        }
           else
               System.out.println("Out of Range");
        }
        
        else {
            System.out.println("No Folder With This Name2");
        }
    }

    
    
     void addfile(String address, FilesInterface fil) {
        folder parent = getaddress(address);
        if (parent != null) {
            if (di.check(fil.Start, fil.size) && (parent.start < fil.Start) && ((parent.start + parent.size) > (fil.size + fil.Start))) {
                {
                    fil.level=parent.level+1;
                    parent.fi.add(fil);
                    di.add(fil.Start,fil.size);
                    System.out.print("File Added !");
                }
            } else {
                System.out.println("Not Have Enoght Space or out of range");
            }
        } else {
            System.out.println("No Folder With This Name1");
        }

    }
     public String getspace(FilesInterface f)
     {
         String arr = "";
         for(int i=0 ; i<f.level;i++)
             arr += "\t";
         return arr ;
     }
          public String getspace(folder f)
     {
         String arr = "";
         for(int i=0 ; i<f.level;i++)
             arr += "\t";
         return arr ;
     }
    public void print() {
        for (int i = 0; i < fi.size(); i++) {
            System.out.println(getspace(fi.elementAt(i))+fi.elementAt(i).name);
        }
        for (int i = 0; i < children.size(); i++) {
            System.out.println(getspace(children.elementAt(i))+"<" + children.elementAt(i).name + ">");
            children.elementAt(i).print();
        }
    }
}
