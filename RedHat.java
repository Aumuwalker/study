public class RedHat{
    public static void main(String[] args){
        int num = 5;
        while(num > 0)
          {
            if(num > 1)
                System.out.println(num+" bottles of beer on the wall,"+num+" bottles of beer.");
            else
                System.out.println(num+" bottle of beer on the wall,"+num+" bottle of beer.");
            System.out.println("take one down.");
            System.out.println("pass it around.");
            if(num > 2)
                System.out.println((num-1)+" bottles of beer on the wall.");
            else if(num == 2)
                System.out.println((num-1)+" bottle of beer on the wall.");
            else
                System.out.println("no more bottles of beer on the wall.");
            num = num - 1;
          }
    }
}