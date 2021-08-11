public class Solution{
    public static void main(String args[]){
        Tree t1 = new Tree();
        Tree t2 = new Tree();
        t1.add(5);
        t1.add(3);
        t1.add(7);
        t1.add(2);
        t1.add(4);
        t1.add(6);
        t1.add(8);

        
        t2.add(5);
        t2.add(2);
        t2.add(8);
        t2.add(3);
        t2.add(6);
        t2.add(4);
        t2.add(7);

        for(int i =  1 ; i < 8 ; i++)
          System.out.print(t1.nthInorder(i)+" ");

        System.out.println();
        System.out.println("-------------------------------------------");

        for(int i =  1 ; i < 8 ; i++)
          System.out.print(t2.nthInorder(i)+" ");
        
    }
}