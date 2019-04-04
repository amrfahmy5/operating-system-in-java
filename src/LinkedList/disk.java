package LinkedList;

public class disk {
   int N;
   boolean []block ;

   public  disk(int n)
   {
       this.N= n;
       block = new boolean[this.N];
       for(int i=0;i<N;i++)
           block[i]= false;
   }
   
       public  boolean check(int start, int length) {
        for (int i = start; i < length+start; i++) {
            if (block[i] == true) {
                return false;
            }
        }
        return true;
    }
       public void add(int []arr)
       {
           for (int i = 0; i < arr[i]; i++) {
               block[arr[i]] = true ;
            }
        }
              public void delete(int start, int length)
       {
           for (int i = start; i < start+length; i++) {
               block[i] = false ;
            }
        }
       }


