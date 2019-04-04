package contig;

import java.io.*;
import java.util.*;


public class FilesInterface {

   public String name;
   public int Start;
   public int size ;
    public int level ;
    public FilesInterface(String name , int Start, int size,int level)
    {
        this.name=name;
        this.Start = Start;
        this.size=size;
        this.level=level;
    }

    

}
