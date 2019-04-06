package contig;

import java.util.*;

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

    public void DeleteFolder(String address) {
        System.out.println(address);
        String[] S = address.split("/");
        address = "";
        for (int i = 0; i < S.length - 1; i++) {
            address += S[i];
            address += "/";
        }

        System.out.println(address);
        foldercont f = getaddress(address);
        if (f != null) {
            for (int i = 0; i < f.children.size(); i++) {
                if (f.children.elementAt(i).name.equals(S[S.length - 2])) {
                    di.delete(f.children.elementAt(i).start, f.children.elementAt(i).size);
                    // f.fi.remove(f);
                    f.children.remove(i);

                    System.out.print("Folder Deleted !");
                }
            }
        } else {
            System.out.println("No Folder With This Name");
        }
    }

    public void DeleteFile(String address) {
        foldercont f = getaddress(address);
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

    void addfolder(String address, foldercont fo) {
        boolean flag = false;
        foldercont parent = getaddress(address);
        if (parent != null) {
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
                    System.out.println("Folder Added !");
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
        foldercont parent = getaddress(address);
        if (parent != null) {
            if(di.chechboundry(parent.start,fil.Start,parent.size,fil.size)){
            if (di.check(fil.Start, fil.size) ) {
                {
                    fil.level=parent.level+1;
                    parent.fi.add(fil);
                    di.add(fil.Start,fil.size);
                    System.out.println("File Added !");
                }}
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
          public String getspace(foldercont f)
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
    public void printSt()
    {
        di.print();
    }
}
