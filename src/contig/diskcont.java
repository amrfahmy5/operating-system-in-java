package contig;

public class diskcont {

    int N;
    boolean[] block;

    public diskcont(int n) {
        this.N = n;
        block = new boolean[this.N];
        for (int i = 0; i < N; i++) {
            block[i] = false;
        }
    }
    public void print()
    {
        for(int i=0;i<block.length;i++)
        {
                System.out.print(block[i]+" ") ;
        }
        System.out.println("") ;
    }
    public boolean check(int start, int length) {
        for (int i = start; i < length + start; i++) {
            if (block[i] == true) {
                return false;
            }
        }
        return true;
    }



    public void add(int start, int length) {
        for (int i = start; i < start + length; i++) {
            block[i] = true;
        }
    }

    public void delete(int start, int length) {
        for (int i = start; i < start + length; i++) {
            block[i] = false;
        }
    }

}
