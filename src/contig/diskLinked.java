package contig;
class blockS{
  public int b;
public int next = -1 ;  
};
public class diskLinked {
   int N;
   blockS []block ;

   public  diskLinked(int n)
   {
       this.N= n;
       System.out.println(N);
       block = new blockS[this.N];
       for(int i=0; i<N ; i++)
       {
           block[i]=new blockS();
           block[i].b= 0;
       }
   }
   public void print()
    {
        for(int i=0;i<block.length;i++)
            System.out.println(i + " " +block[i].b+" "+block[i].next);
    }
       public  boolean checkFolder(int start[]) {
          
          for(int i=0 ; i<start.length;i++)
          {
              if(block[start[i]].b!=0)
                  return false ;
          }
           

        return true;
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
              public  boolean checkFile(int start[]) {
        
          for(int i=0 ; i<start.length;i++)
          {
              if(block[start[i]].b!=1)
                  return false ;
          }
           

        return true;
    }
       public void addFolder(int []arr)
       {
           for (int i = 0; i < arr.length; i++) {

                  block[arr[i]].b = 1 ;
               if(i==arr.length-1)
                    block[arr[i]].next=-1;
               else
                    block[arr[i]].next=arr[i+1];
              }    
            
        }
              public void addFile(int []arr)
       {
           for (int i = 0; i < arr.length; i++) {
               block[arr[i]].b = 2 ;
               if(i==arr.length-2) 
                   block[arr[i]].next=arr[i+1];
               else
                    block[arr[i]].next=-1  ;
            }
        }
              public void deleteFolder(int start)
       {
           int next = block[start].next;
           block[start].b=0;
           block[start].next=-1 ;
           while(next!=-1)
           {
               block[next].b = 0 ; 
               int oldnext = next;
               next = block[next].next;
               block[oldnext].next=-1;
            }
        }
          public void deleteFile(int start)
       {
           int next = block[start].next;
           block[start].b=1;
           while(next!=-1)
           {
               block[next].b = 1 ; 
               int oldnext = next;
               next = block[next].next;
               block[oldnext].next=-1;
            }
        }
       }


