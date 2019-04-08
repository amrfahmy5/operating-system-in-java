package contig;
class blockS1{
  public int b=0;
public int [] arr  ;  
};

public class diskIndex {
      int N;
   blockS1 []block ;

   public  diskIndex(int n)
   {
       this.N= n;
       block = new blockS1[this.N];
      for(int i=0; i<N ; i++)
       {
           block[i]=new blockS1();
           block[i].b= 0;
       }
   }
   
   public void print()
    {
        for(int i=0;i<block.length;i++)
            System.out.print(block[i].b+" ");
    }
      public boolean checboundry(int arr[],int arr2[])
       {
//           int counter=0;
//           for(int i=0;i<arr.length;i++)
//           {
//               counter=0 ;
//               for(int j=0 ; j<arr2.length;j++)
//               {                   
//                   if(arr[i]==arr2[j])
//                   {
//                       counter++;
//                   }
//                   
//               }
//               if(counter==arr2.length)
//                   return false;
//           }
           return true ;
       }
       public  boolean checkFolder(int start) {
            if(block[start].b==0)
                return false;
           int size = block[start].arr.length ;
           for(int i=0 ;i<size;i++)
           {
               if (block[block[start].arr[i]].b !=0)
                    return false; 
            }
        return true;
    }
            public  boolean checkFile(int start) {
            if(block[start].b==0)
                return false;
           int size = block[start].arr.length ;
           for(int i=0 ;i<size;i++)
           {
               if (block[block[start].arr[i]].b !=1)
                    return false; 
            }
        return true;
    } 
       
       public void addFolder(int []arr)
       {
           block[arr[0]].arr = new int [arr.length-1] ;
           for(int i=1 ; i<arr.length-2;i++)
               block[arr[0]].arr[i]=arr[i];
           for (int i = 1; i < arr.length; i++) {
               block[i].b = 1 ;
            }
        }
            public void addFile(int []arr)
       {
           block[arr[0]].arr = new int [arr.length-1] ;
           for(int i=1 ; i<arr.length-2;i++)
               block[arr[0]].arr[i]=arr[i];
           for (int i = 1; i < arr.length; i++) {
               block[i].b = 2 ;
            }
        }
       
              public void deleteFolder(int start)
       {
          
           block[start].b=0;
           int size = block[start].arr.length ;
           for(int i=0 ;i<size;i++)
           {
               block[block[start].arr[i]].b = 0 ; 
            }
        }
                         public void deleteFile(int start)
       {
          
           block[start].b=0;
           int size = block[start].arr.length ;
           for(int i=0 ;i<size;i++)
           {
               block[block[start].arr[i]].b = 1 ; 
            }
        }
}
