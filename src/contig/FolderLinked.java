package contig;

import java.util.Vector;

public class FolderLinked {

    String name;
    int[] arr;
    int level;
    Vector<FilesInterfaceLinker> fi = new Vector();
    Vector<FolderLinked> children = new Vector();
    String[] splited;
    diskLinked di;

    public FolderLinked(String name, int[] arr, int level) {
        this.name = name;
        this.arr = arr;
        this.level = level;
    }

    public FolderLinked(int N) {
        this.arr = new int[N];
        FolderLinked root = new FolderLinked("root", arr, 0);
        this.children.add(root);
        di = new diskLinked(N);
    }

    public FolderLinked getaddress(String address) {
        FolderLinked f = children.elementAt(0);

        splited = address.split("/");
        //System.out.println(splited[1]);
        if (splited[0].equals("root")) {
            for (int i = 1; i < splited.length - 1; i++) {
                FolderLinked newfolder = getchildren(splited[i], f);
                if (f.equals(newfolder)) {
                    return null;
                }
                f = newfolder;
            }
            f.level = splited.length;
            return f;
        } else {
            return null;
        }
    }

    public FolderLinked getchildren(String address, FolderLinked f) {
        for (int i = 0; i < f.children.size(); i++) {

            if (f.children.get(i).name.equals(address)) {
                return f.children.elementAt(i);
            }
        }
        return f;
    }

    public void DeleteFolder(String address) {
        //   System.out.println(address);
        String[] S = address.split("/");
        address = "";
        for (int i = 0; i < S.length - 1; i++) {
            address += S[i];
            address += "/";
        }

        //System.out.println(address);
        FolderLinked f = getaddress(address);
        if (f != null) {
            di.delete(f.arr);
            f.fi.remove(f.fi.indexOf(f));
            for (int i = 0; i < f.children.size(); i++) {
                if (f.children.elementAt(i).name.equals(S[S.length - 2])) {
                    di.delete(f.children.elementAt(i).arr);
                    // f.fi.remove(f);
                    f.children.remove(i);
                    System.out.print("Folder Deleted !");
                } else {
                    System.out.println("No Folder With This Name");
                }
            }
        }
    }

    public void DeleteFile(String address) {
        FolderLinked f = getaddress(address);
        if (f != null) {
            FilesInterfaceLinker target = null;
            for (int i = 0; i < f.fi.size(); i++) {
                if (f.fi.elementAt(i).name.equals(splited[splited.length - 1])) {
                    target = f.fi.elementAt(i);
                }
            }
            if (target == null) {
                System.out.println("Not Files Found With this Name");
            } else {
                di.delete(target.arr);
                f.fi.remove(target);
                System.out.print("File Deleted !");
            }
        } else {
            System.out.println("No File With This Name");
        }
    }

    void addfolder(String address, FolderLinked fo) {
        boolean flag = false;
        FolderLinked parent = getaddress(address);
        if (parent != null) {
            // System.out.println(parent.start+" "+fo.start+" "+parent.size+" "+fo.size +" "+parent.name);
            // if( (parent.start < fo.start) && ((parent.start + parent.size) > (fo.size + fo.start)))
            if (di.check(fo.arr)) {

                for (int i = 0; i < parent.children.size(); i++) {
                    if (parent.children.elementAt(i).equals(fo.name)) {
                        flag = true;
                    }
                }
                if (flag == true) {
                    System.out.println("Have File With Same Name");
                } else {
                    // di.add(fo.start, fo.size);
                    fo.level = parent.level + 1;
                    parent.children.add(fo);
                    System.out.print("Folder Added !");
                }
            } else {
                System.out.println("This Place Are Stored Befor");
            }

        } else {
            System.out.println("No Folder With This Name2");
        }
    }

    void addfile(String address, FilesInterfaceLinker fil) {
        FolderLinked parent = getaddress(address);
        if (parent != null) {

            if (di.check(fil.arr)) {
                {
                    fil.level = parent.level + 1;
                    parent.fi.add(fil);
                    di.add(fil.arr);
                    System.out.print("File Added !");
                }
            } else {
                System.out.println("Not Have Enoght Space or out of range");
            }
        } else {
            System.out.println("No Folder With This Name1");
        }

    }

    public String getspace(FilesInterfaceLinker f) {
        String arr = "";
        for (int i = 0; i < f.level; i++) {
            arr += "\t";
        }
        return arr;
    }

    public String getspace(FolderLinked f) {
        String arr = "";
        for (int i = 0; i < f.level; i++) {
            arr += "\t";
        }
        return arr;
    }

    public void print() {
        for (int i = 0; i < fi.size(); i++) {
            System.out.println(getspace(fi.elementAt(i)) + fi.elementAt(i).name);
        }
        for (int i = 0; i < children.size(); i++) {
            System.out.println(getspace(children.elementAt(i)) + "<" + children.elementAt(i).name + ">");
            children.elementAt(i).print();
        }
    }
}
