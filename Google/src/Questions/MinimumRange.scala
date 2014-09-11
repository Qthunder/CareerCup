package Questions

import scala.collection.mutable.PriorityQueue

object MinimumRange {

  object implicits {
	  implicit def listOrdering : Ordering[List[Int]]=new Ordering[List[Int]] {
	    def compare(a:List[Int],b:List[Int])=(a(0) compare b(0)) *(-1) }
	  
	}  
	
  def getSmallestRange(A :List[List[Int]]):(Int,Int)={
    import implicits._;
    val Q=new PriorityQueue[List[Int]]();
    A.foreach {Q.+=}
    
   var currentRange=((A map (aList=>aList(0))).min,(A map (aList=>aList(0))).max);
   
   var minimumRange=currentRange
   var empty=false;
   while (!empty){
     val x= Q.dequeue().tail;
     if (x.isEmpty)
       empty=true
     else
       {
        Q+=x;
        var upperbound=Math.max(currentRange._2,x(0));
        currentRange=(Q.max(0),upperbound)
       if (currentRange._2-currentRange._1<minimumRange._2-minimumRange._1)
          minimumRange=currentRange;
       }
     
     
   }
   
   
    minimumRange
  }
}