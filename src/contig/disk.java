
package contig;

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
       public boolean chechboundry(int Pstart,int Cstart,int Psize,int Csize)
       {
           if( (Pstart < Cstart) && ((Pstart + Psize) > (Psize + Cstart)))
               return true ;
           else
               return false;
       }
       public void add(int start, int length)
       {
           for (int i = start; i < start+length; i++) {
               block[i] = true ;
            }
        }
              public void delete(int start, int length)
       {
           for (int i = start; i < start+length; i++) {
               block[i] = false ;
            }
        }
       }

