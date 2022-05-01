public class problem1 {
    public static void main(String[] args) {
        int[] arr={14,36,47,11,10,92,5};
        int temp;
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i]%2==0){
                System.out.println(arr[i]+" is even at index "+i);
            }else{
                for(int j=i;j<arr.length;j++){
                    if(arr[j]%2==0){
                        temp=arr[j];
                        arr[j]=arr[i];
                        arr[i]=temp;
                        break;
                    }
                }
            }
//            System.out.println(arr[i]); System.out.println(arr[i]+" is even at index "+i);
        }
        System.out.println("---------------------------------------------------------");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}