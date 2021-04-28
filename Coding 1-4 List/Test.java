import java.util.Arrays;
public class Test{
    public static void main(String[] args){
        int index =5;

        int[] array ={0,1,2,3,4,5,6};
        // int[] array =new int[8];

        // if(index>array.length-1){
        int[] array1 =new int[array.length-1];
        System.arraycopy(array, 0 , array1, 0,index );
        // array1[index]=-1;
        System.arraycopy(array, index+1 , array1, index,array.length-index-1 );
        // System.out.println(array[index+1]);

        array = array1;
        // System.out.println("arrayu1="+array.length);


        // System.out.println("arrayu1="+array1[index]);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        // System.out.println(array1[index]);


        // }
        // else{
        // array[index]=100;
        // System.out.println("array="+array.length);

            
        // }
        

        // array = Arrays.copyOf(array, array.length+20);

        // System.out.println(array1.length);
        // System.out.println(array1[11]);



    }
}
