package Text;

public class Homework4d1 {
          public static void main(String[] args){
              StopWatch time = new StopWatch();
              int[] nums = new int[100000];
              for(int i = 1; i <= 100000; ++i)
                  nums[i - 1] = (int)((System.currentTimeMillis() / i) % 1000);

                   time.start();
                    for(int i = 0; i < 99999; ++i){
                    for(int j = i+1; j < 100000; ++j){
                         if(nums[i] > nums[j]){
                              int temp = nums[i];
                               nums[i] = nums[j];
                               nums[j] = temp;
                         }
                    }
                }
           time.stop();

              System.out.println(time.getElapsedTime());
          }
}
class StopWatch{
          private long startTime;
          private long endTime;
          public void setStartTime(long newStartTime){
                startTime = newStartTime;
          }
           public void setEndTime(long newEndTime){
                  endTime = newEndTime;
          }
           public StopWatch(){
                 startTime = System.currentTimeMillis();
          }

          public void start(){
                 startTime = System.currentTimeMillis();
          }

          public void stop(){
                 endTime = System.currentTimeMillis();
          }

          public long getElapsedTime(){
              return endTime - startTime;
          }
}
