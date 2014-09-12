package Questions

object Main {
  import PotsOfGold.Direction

  def main(args: Array[String]): Unit = {
     val smallestRange =( MinimumRange.getSmallestRange(List(List(4,10,15,24,26),List(0,9,12,20),List(5,18,20,30))))
     val directions=PotsOfGold.getOptimal(Array(10,20,80,15))
    
     //Q1: Minimum Range
     println(smallestRange);
     println ("--------------------------------------------")
     
     //Q2 : Pots of Gold
     for (i<-0 until directions.size){
       if (i%2==0)
    	   println("Player A : " + directions(i)); 
       else
    	   println("Player B : "+ directions(i));
         
       }
     

}
}