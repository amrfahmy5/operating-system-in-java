package contig;
class blockS1{
  public boolean b;
public int [] arr  ;  
};

public class diskIndex {
      int N;
   blockS1 []block ;

   public  diskIndex(int n)
   {
       this.N= n;
       block = new blockS1[this.N];
//       for(int i=0;i<N;i++)
//           block[i].b= false;
   }
   public void print()
    {
        for(int i=0;i<block.length;i++)
            System.out.print(block[i].b+" ");
    }
       public  boolean check(int start) {
            if(block[start].b==true)
                return false;
           int size = block[start].arr.length ;
           for(int i=0 ;i<size;i++)
           {
               if (block[block[start].arr[i]].b == true)
                    return false; 
            }
        return true;
    }
      
       
       public void add(int []arr)
       {
           block[arr[0]].arr = new int [arr.length-1] ;
           for(int i=1 ; i<arr.length-2;i++)
               block[arr[0]].arr[i]=arr[i];
           for (int i = 1; i < arr.length; i++) {
               block[i].b = true ;
            }
        }
       
       
              public void delete(int start)
       {
          
           block[start].b=false;
           int size = block[start].arr.length ;
           for(int i=0 ;i<size;i++)
           {
               block[block[start].arr[i]].b = false ; 
            }
        }
}
