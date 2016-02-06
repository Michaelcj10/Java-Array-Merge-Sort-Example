public class MergeSort {

    static void mergeSort(int f[], int lb, int ub){
        //termination reached when a segment of size 1 reached - lb+1 = ub
        if(lb+1 < ub){
            int mid = (lb+ub)/2;
            mergeSort(f,lb,mid);
            mergeSort(f,mid,ub);
            merge(f,lb,mid,ub);
        }
    }

    static void merge(int f[], int p, int q, int r){
        //p<=q<=r
        int i = p; int j = q;

        //use temp array to store merged sub-sequence
        int temp[] = new int[r-p]; int t = 0;

        while(i < q && j < r){

            if(f[i] <= f[j]){
                temp[t]=f[i];i++;t++;
            }
            else{
                temp[t] = f[j]; j++; t++;
            }
        }
        //tag on remaining sequence
        while(i < q){
            temp[t]=f[i];
            i++;t++;
        }
        while(j < r){
            temp[t] = f[j];
            j++; t++;
        }
        //copy temp back to f
        i = p; t = 0;
        while(t < temp.length){
            f[i] = temp[t];
            i++; t++;
        }

    }

    public static void main(String args[]){
        int d[] = {2,5,1,2,3,6,7,8,4,2,5,3,7,9,1};
        mergeSort(d,0,d.length);
        for(int x : d)
            System.out.print(x + " ");
        System.out.println();
    }
}