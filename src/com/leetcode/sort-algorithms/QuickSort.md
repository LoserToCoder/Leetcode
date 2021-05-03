      /*
      快速排序时
      如果有连续重复元素时
      判断条件中必须要有等于情况的判断
      否则会跳不出循环
      while(left<right){
            while(left<right&&pivot<array[right]){ => pivot<=array[right]
               right--;
            }
            array[left]=array[right];
            while(left<right&&pivot>array[left]){  => pivot>=array[left]
               left++;
            }
            array[right]=array[left];
         }
         array[left]=pivot;
     */ 
     public int sort(int[]array,int left,int right){
         int pivot=array[left];// pivot => 枢轴,在一趟中不能出现变化
         /***
            右边一旦循环跳出时,意味着右边有小于枢轴的值
            记住此时的位置right,array[right]
            因为刚开始时候枢轴是取左边第一个值,已经存在与pivot中
            所以将 array[left]=array[right]
            左边一旦循环跳出时,意味着有左边大于枢轴的值
            记住此时的位置left,array[left]
            顾将此值赋值 刚才右边的那个
            其实类似于左右边交换值
            循环重复以上行为
         */
         while(left<right){
            while(left<right&&pivot<=array[right]){
               right--;
            }
            array[left]=array[right];
            while(left<right&&pivot>=array[left]){
               left++;
            }
            array[right]=array[left];
         }
         array[left]=pivot;
         return right;
     }
     public void qSort(int[]array,int left,int right){
        if(left<right){
           int pos=sort(array,left,right);
           qSort(array,left,pos-1);
           qSort(array,pos+1,right);
        }
     } 