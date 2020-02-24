import java.util.*;
class dayname{
   public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      int day,month,year;
      System.out.println("enter day:");
      day=sc.nextInt();
      System.out.println("enter month:");
      month=sc.nextInt();
      System.out.println("enter year:");
      year=sc.nextInt();
      validation(day, month, year);
      calculatedayname cdn = new calculatedayname();
      cdn.calculateC(year,month,day);
      cdn.calculateM(year, month, day);
      sc.close();
   }

   static void validation(int day, int month, int year) {
      if(day>31){
         System.exit(0);
         System.out.println("enter valid date");
      }
      if(month>12){
         System.exit(0);
         System.out.println("enter valid month:");
      }
      if(year>9999){
         System.exit(0);
         System.out.println("enter year less than 9999:");
      }
   }
}
class calculatedayname{
   int m,c,yby4,y;
   void calculateC(int year,int month,int day) {
      int first2digit,i,diff,j=0,cyear=0;
      if(year%100==0){
         cyear=year-1;
         first2digit=cyear/100;
      }
      else{
         first2digit=year/100;
      }
      for(i=4;i<first2digit;i+=4){
         j=i;
      }
      diff=first2digit-j;
      if(diff==1){
         c=5;
      }
      if(diff==2){
         c=3;
      }
      if(diff==3){
         c=1;
      }
      if(diff==0){
         c=0;
      }
      calculateY(year);
   }
   void calculateY(int year){
      if(year%100==00){
         y=99;
      }
      else{
         y=((year%100)-1);
      }
      calculateYdivide4(y);
   }
   void calculateYdivide4(int y){
      yby4=y/4;
   }
   void calculateM(int year,int month,int day){
      int leap[]={3,1,3,2,3,2,3,3,2,3,2,3},nonleap[]={3,0,3,2,3,2,3,3,2,3,2,3},i,sum=0;
      month=month-1;
      if(year%4==0){
         for(i=0;i<month;i++){
            sum=sum+leap[i];
         }
         m=day+sum;
      }
      else{
         for(i=0;i<month;i++){
            sum=sum+nonleap[i];
         }
         m=day+sum;
      }
      calculateDayName(c,y,yby4,m);
   }
   void calculateDayName(int c,int y,int yby4,int m){
      int total,rem;
      total=c+y+yby4+m;
      rem=total%7;
      // System.out.println("c"+c);
      // System.out.println("y"+y);
      // System.out.println("vby4"+yby4);
      // System.out.println("m"+m);
      // System.out.println("rem"+rem);
      // System.out.println("total"+total);
      if(rem==0){
         System.out.println("Day is Sunday");
      }
      else if(rem==1){
         System.out.println("Day is Monday");
      }
      else if(rem==2){
         System.out.println("Day is Tuesday");
      }
      else if(rem==3){
         System.out.println("Day is Wednesday");
      }
      else if(rem==4){
         System.out.println("Day is Thursday");
      }
      else if(rem==5){
         System.out.println("Day is Friday");
      }
      else if(rem==6){
         System.out.println("Day is Saturday");
      }
   }
}