
package epam_maven_task;

import java.util.*;

interface Count
{ 
  void getCount();
}
class Candies
{
  int minWeight;
  int maxWeight;
 
  static int totalCandies,totalWeight;
 
 void  addCandies(int c,int ch)
 {
  int t;
  totalCandies+=c;
  t=totalWeight;
  totalWeight=t+(c*ch);
 // System.out.println("totalWeight "+totalWeight);
 }

 void setWeight(int a,int b)
 { minWeight=a; maxWeight=b; }
 int getWeight(){
     return (totalWeight);
 }
  int checkWeight(int w)
{
    if(totalWeight>maxWeight)  return totalWeight-maxWeight;
    return 0;
}

 boolean checkWeight()
  {
    if(totalWeight<=maxWeight && totalWeight>=minWeight)
      return true;
     return false;
  }
void getCount()
{System.out.println(totalCandies);}

}
class Chocolates extends Candies 
{
  static int chocWeight;  
  static int chocCount;
  Chocolates(int c)
  {
    addCandies(c,chocWeight);
 
    addChoc(c);
  }
 
  
 void setWeight(int w)
  {
    
      chocWeight=w;
   
  }
  
  int getWeight()
  {
    
    return chocCount*chocWeight;
  }
  void addChoc(int c)
  { chocCount+=c;
    //totalWeight+=c*chocWeight;System.out.println(totalWeight);
    }
  
}
class Sweets extends Candies 
{
  static int sweetWeight;
  static int sweetCount;
  Sweets(int c)
  {
    addCandies(c,sweetWeight);
    addSweets(c);
   
  }
 
  void setWeight(int w)
  {
   
      sweetWeight=w;
   
  }
  void addSweets(int c)
  {
   sweetCount+=c;
   //totalWeight+=c*sweetWeight;
   //System.out.println(totalWeight);
  }
  int getWeight()
  {
    
    return sweetCount*sweetWeight;
  }

}
public class NewYearGift
{
 public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    int chi,k,inp;
    Candies c=new Candies();
    int p,q;
   
    
        System.out.println("Let's start preparing a new year's gift!!!\nEnter the minimum and maximum weight of gift");
    c.setWeight(sc.nextInt(),sc.nextInt());//System.out.println(c.minWeight+"   "+c.maxWeight);
    Chocolates ch=new Chocolates(0);
    System.out.println("Enter weight of chocolate:");
    p=sc.nextInt();ch.setWeight(p);
    Sweets sw=new Sweets(0);
    System.out.println("Enter weight of sweet:");
    q=sc.nextInt();sw.setWeight(q);
    while(true)
    {
      k=Candies.totalWeight;
      
    if(c.checkWeight())
    {
	System.out.println("Successfully prepared a new year's gift!!! :)");
        break;
    }
    else if(c.checkWeight(k)>0)
    {
        System.out.println("Sorry to say that u have added "+c.checkWeight(k)+" extra weight than permitted.");
        //goto out;
        break;
    }
    System.out.println("\n1.Add chocolates.\n2.Add sweets\n3.Current weight of gift\n4.Current candies count\n");
    chi=sc.nextInt(); 
    switch(chi)
    {
    case 1: System.out.println("Enter the number of chocolates u want to add:");
            inp=sc.nextInt();
            ch=new Chocolates(inp);
            //ch.setWeight(p);
            // System.out.println(c.totalWeight);
 	    break;
    case 2: System.out.println("Enter the number of sweets u want to add:");
            inp=sc.nextInt();
            sw=new Sweets(inp);
            //sw.setWeight(q);
            //System.out.println(c.totalWeight);
 	    break;
    case 3: System.out.println("weight :"+c.getWeight());
            break;
    case 4: c.getCount();
            break;
    default: System.out.println("enter a valid option");
           
    }
   }   
  System.out.println("Sorting gift contents based on weight:");
  int cw=ch.getWeight();
  int swt=sw.getWeight();
  if(cw>=swt)
    System.out.println("chocolates weight="+cw+" sweets weight="+swt);
  else
    System.out.println("sweets weight="+swt+" chocolates weight="+cw);
  System.out.println("enter two weights:");
  int a=0,mn=sc.nextInt(),mx=sc.nextInt();
  if(p>=mn && p<=mx)
     a+=Chocolates.chocCount;
  if(q>=mn && q<=mx)
     a+=Sweets.sweetCount;
  System.out.println("candies in  given range:"+a); 
    sc.close();
    }
    }
   
    
















    
  