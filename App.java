
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
  
        int[] arr = generateRandomArray(10_000);
        int[] arrTwo = generateRandomArray(10_000);


        // Measure the execution time of BubbleSort
        long startTime = System.nanoTime();
        Bubblesort(arr);
        long endTime = System.nanoTime();
        long bubbleSortTime = (endTime - startTime)/1_000_000;

        // Measure the execution time of BubbleSort
        startTime = System.nanoTime();
        Mergesort(arr, 0, arrTwo.length-1);
        endTime = System.nanoTime();
        long mergeSortTime = (endTime - startTime)/1_000_000;


        System.out.println("BubbleSort time: " + bubbleSortTime + " miliseconds");
        System.out.println("MergeSort time: " + mergeSortTime + " miliseconds");
    }

    //Create random array
    public static int[] generateRandomArray(int arrayLength) 
    {
        Random random = new Random(); //NOTE: Generate random
        int[] array = new int[arrayLength]; //REMINDER: Create a new array with the assigned length
        System.out.println("Creating random array...");
        
        for (int i = 0; i < arrayLength; i++) 
            array[i] = random.nextInt(1000);
        
        return array;
    }


    public static void Bubblesort(int[] arrayOne){
        int Temp;

        for(int i = 0; i<arrayOne.length; i++){
            for(int j = 0; j<arrayOne.length- 1 - i; j++){

                if(arrayOne[j] > arrayOne[i+1]){
                    Temp = arrayOne[j];
                    arrayOne[j] = arrayOne[j+1];
                    arrayOne[j + 1] = Temp;
                }
            }
        }
    }


    public static void Mergesort(int[] arrayTwo, int Start, int End){
        int Mid;

        if(Start <  End){
            Mid = (Start+ End)/2;

            Mergesort(arrayTwo, Start, Mid);
            Mergesort(arrayTwo, Mid+1, End);
            Merge(arrayTwo, Start, Mid, End);
        }
    }


    public static void Merge(int[] arrayTwo, int Start, int Mid, int End){
        int[] TempArr = new int[10001];
        int i,j,k;
        i = Start;
        j = Mid+1;
        k = Start;

        while(i<=Mid && j<=End){
            if(arrayTwo[i] <= arrayTwo[j])
                TempArr[k++]=arrayTwo[i++];
            else
                TempArr[k++]=arrayTwo[j++];
        }

        if(i > Mid){
            while(j <= End)
                TempArr[++k] = arrayTwo[j++];
        }
        else{
            while(i <= Mid)
                TempArr[k++] = arrayTwo[i++];
        }

        for(i = Start; i <= End; i++){
                arrayTwo[i] = TempArr[i];
        }
    }
}