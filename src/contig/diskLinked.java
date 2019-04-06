package contig;
class blockS{
  public boolean b;
public int next = -1 ;  
};
public class diskLinked {
   int N;
   blockS []block ;

   public  diskLinked(int n)
   {
       this.N= n;
       block = new blockS[this.N];
       for(int i=0;i<N;i++)
           block[i].b= false;
   }
   
       public  boolean check(int start) {
                      int next = block[start].next;

           while(next!=-1)
           {
               if(block[next].b = true)
                   return false;
               next = block[next].next;
            }

        return true;
    }
       public void add(int []arr)
       {
           for (int i = 0; i < arr.length; i++) {
               block[arr[i]].b = true ;
               if(i==arr.length-2) 
                   block[arr[i]].next=arr[i+1];
               else
                    block[arr[i]].next=-1  ;
            }
        }
              public void delete(int start)
       {
           int next = block[start].next;
           block[start].b=false;
           while(next!=-1)
           {
               block[next].b = false ; 
               int oldnext = next;
               next = block[next].next;
               block[oldnext].next=-1;
            }
        }
       }


