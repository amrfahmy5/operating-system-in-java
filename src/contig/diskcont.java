package contig;

public class diskcont {

    int N;
    int[] block;

    public diskcont(int n) {
        this.N = n;
        block = new int[this.N];
        for (int i = 0; i < N; i++) {
            block[i] = 0;
        }
    }
    public void print()
    {
        for(int i=0;i<block.length;i++)
        {
                System.out.print(block[i]) ;
        }
        System.out.println("") ;
    }
    public boolean checkfolder(int start, int length) {
        for (int i = start; i < length + start; i++) {
            if (block[i] == 1||block[i]==2) {
                return false;
            }
        }
        return true;
    }
    public boolean checkfile(int start, int length) {
        for (int i = start; i < length + start; i++) {
            if (block[i] == 2) {
                
                return false;
            }
        }
        return true;
    }
    public boolean chechboundry(int Pstart, int Cstart, int Psize, int Csize) {
        if ((Pstart <= Cstart) && ((Pstart + Psize) > (Csize + Cstart))) {
            return true;
        } else {
            return false;
        }
    }

    public void addfile(int start, int length) {
        for (int i = start; i < start + length; i++) {
            block[i] = 2;
        }
    }
   public void addfolder(int start, int length) {
        for (int i = start; i < start + length; i++) {
            block[i] = 1;
        }
    }
    public void deletefolder(int start, int length) {
        for (int i = start; i < start + length; i++) {
            block[i] = 0;
        }
    }
       public void deletefile(int start, int length) {
        for (int i = start; i < start + length; i++) {
            block[i] = 1;
        }
    }
}
