package com.leetcode.dp;


import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {

    class Job{
      int startTime;
      int endTime;
      int profit;
      public Job(int startTime,int endTime,int profit){
         this.startTime=startTime;
         this.endTime=endTime;
         this.profit=profit;
      }

      @Override
      public String toString() {
        return "["+startTime+"-"+endTime+":"+profit+"]";
      }
    }
    private int binarySearch(Job job,Job[]jobs,int limit){
        int low=0;
        int middle=0;
        int prev=-1;// =>增加一个前项指针,避免出现错过以及循环跳出
        int key=job.startTime;
        while(low<limit){
            middle=(low+limit)/2;
            if(key<jobs[middle].endTime){
                 limit=middle-1;
            }else{
                 prev=middle;
                 low=middle+1;
            }
        }
        if(key>=jobs[low].endTime){ //不能选择limit,因为可能会出现limit=-1的情况[1,1]
          return low;
        }
        return prev;
    }
    private void initJobs(Job[]jobs,int[]startTime,int[]endTime,int[]profit){
        for(int i=0;i<profit.length;i++){
            jobs[i]=new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job1.endTime-job2.endTime;
            }
        });
    }
    public int jobScheduling(int[]startTime,int[]endTime,int[]profit){
        int len=profit.length;
        Job[]jobs=new Job[len];
        initJobs(jobs,startTime,endTime,profit);
        for(int i=len-1;i>0;i--){
            int pos=binarySearch(jobs[i],jobs,i-1);
            if(pos>=0&&pos<=i-1){
                jobs[i].startTime=pos+1;
            }else{
                jobs[i].startTime=0;
            }
        }
        jobs[0].startTime=jobs[0].profit;
        for(int i=1,j;i<len;i++){
            j=(jobs[i].startTime!=0)?jobs[i].startTime-1:i;
            jobs[i].startTime=Math.max(jobs[i-1].startTime,jobs[j].startTime+jobs[i].profit);
        }
        return jobs[len-1].startTime;
    }
    private int binarySearch(int key,int []endTime,int limit){
        int low=0;
        int middle=0;
        int prev=-1;// =>增加一个前项指针,避免出现错过以及循环跳出
        while(low<limit){
            middle=(low+limit)/2;
            if(key<endTime[middle]){
                 limit=middle-1;
            }else{
                 prev=middle;
                 low=middle+1;
            }
        }
        if(key>=endTime[low]){ //不能选择limit,因为可能会出现limit=-1的情况[1,1]
          return low;
        }
        return prev;
    }       
    public int jobSchedulingOptimize(int[] startTime, int[] endTime, int[] profit) {
       int len=profit.length;
       int []prev=new int[len];
      // qSort(startTime,endTime,profit,0,len-1);对数据进行排序
       for(int i=len-1;i>0;i--){
           int pos=binarySearch(startTime[i],endTime,i-1);
           if(pos>=0&&pos<=i-1){
             prev[i]=pos+1;
           }else{
             prev[i]=0;
           }
       }
       prev[0]=profit[0];
       for(int i=1,j;i<len;i++){
             j=(prev[i]!=0)?prev[i]-1:i;
             prev[i]=Math.max(prev[i-1],prev[j]+profit[i]);
       }
       return prev[len-1];
    }
    private int spilt(Job[]jobs,int left,int right){
          Job pivot=jobs[left];
          while(left<right){
              while(left<right&&pivot.endTime<=jobs[right].endTime){
                 right--;
              }
              jobs[left]=jobs[right];
              while(left<right&&pivot.endTime>=jobs[left].endTime){
                 left++;
              }
              jobs[right]=jobs[left];
          }
          jobs[left]=pivot;
          return left;
     }
    private void qSort(Job[]jobs,int left,int right){
        if(left<right){
           int pos=spilt(jobs,left,right);
           qSort(jobs,left,pos-1);
           qSort(jobs,pos+1,right);
        }
     }
    public static void main(String[] args) {
        JobScheduling schedu=new JobScheduling();
        /*  int []startTime={1,3,0,4,3,5,6,8};
            int []endTime={4,5,6,7,8,9,10,11};
            int []profit={5,1,8,4,6,3,2,4};
            测试结果是13

            int[] startTime={1,2,3,3};
            int[]endTime ={3,4,5,6};
            int[]profit = {50,10,40,70};
            测试结果120
            int []startTime={1,2,3,4,6};
            int []endTime={3,5,10,6,9};
            int []profit={20,20,100,70,60};
            测试结果 150

             int []startTime={1,1,1};
             int []endTime={2,3,4};
             int []profit={5,6,4};
             测试结果 6
        */
        int[] startTime={1,2,3,3};
        int[]endTime ={3,4,5,6};
        int[]profit = {50,10,40,70};
        int maxProfits = schedu.jobScheduling(startTime, endTime, profit);
        System.out.println(maxProfits);

    }
}
