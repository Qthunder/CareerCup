package Questions

object PotsOfGold {
   object Direction extends Enumeration {
    	val LEFT = Value("LEFT")
    	val RIGHT= Value("Right")
    }
    import Direction._
  def getOptimal (A: Array[Int]) : Array[Direction.Value] ={
   
    val Size=A.length;
    val table=Array.ofDim[Int](Size+1 ,Size+1)               // A(i)(j)=optimum gold difference 
    val next=Array.ofDim[Direction.Value](Size+1,Size+1)
    for (i<-0 until Size)
      table(i)(i)=0
    var turn:Int=0;
    if (Size % 2==0)
      turn=(-1)
    else
      turn=1
    for (k <-1 to Size){
     for (i<-0 to Size-k){
       val j=i+k
       val left=table(i+1)(j)+turn * A(i)
       val right=table(i)(j-1)+turn * A(j-1)
       if (left*turn>right*turn)
         { table(i)(j)=left; next(i)(j)=LEFT; print (i,j,left);}
       else 
         { table(i)(j)=right; next(i)(j)=RIGHT; print(i,j,right);}
     }
      turn=turn*(-1);
    }
    var k=0
    var i=0
    var j=Size
    val Answer=Array.ofDim[Direction.Value](Size)
    while (i<j){
      Answer(k)=next(i)(j);
      if (Answer(k)==LEFT)
        i+=1;
      else
        j-=1
       k+=1
      }
    Answer;
    
    
    
    
  }

}