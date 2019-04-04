package contig;

public class diskLinked {
   int N;
   boolean []block ;

   public  diskLinked(int n)
   {
       this.N= n;
       block = new boolean[this.N];
       for(int i=0;i<N;i++)
           block[i]= false;
   }
   
       public  boolean check(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            if (block[arr[i]] == true) {
                return false;
            }
        }
        return true;
    }
       public void add(int []arr)
       {
           for (int i = 0; i < arr.length; i++) {
               block[arr[i]] = true ;
            }
        }
              public void delete(int []arr)
       {
           for (int i = 0; i < arr.length; i++) {
               block[arr[i]] = false ;
            }
        }
       }


