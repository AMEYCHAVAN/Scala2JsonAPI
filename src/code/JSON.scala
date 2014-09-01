package code
 
import scala.collection.mutable.HashMap
abstract class JSON

case class JSeq(elems: List[JSON]) extends JSON
case class JObj(bindings: Map[String, JSON]) extends JSON
case class JNum(num: Double) extends JSON
case class JCurrency(num: BigDecimal) extends JSON
case class JStr(str: String) extends JSON
//case class JArryStr(strarr: Array[String]) extends JSON
case class JBool(b: Boolean) extends JSON
case object JNull extends JSON

object N {
  //
  def show(json: Any):String = json match {
    case elems:List[Any] => "[" + (elems map show mkString ", ") + "]"
    case str:String => {
        	if (str != null) { "\"" + (str.replace("\"", "")).replace("\\", "/") + "\"" }
        	else { "\"" + str + "\"" }
        }
 
    case bindings:Map[String,Any]=> 
      val assocs = bindings map {
        case (key, value) => "\"" + key + "\": " + show(value)
      }
      "{" + (assocs mkString ", ") + "}"
    case num:Double=>num.toString
    case num:Integer=>num.toString
    case bool:Boolean=>bool.toString
    case _=> null
  }
}

object J {
	def show(json: JSON): String = json match {
	case JSeq(elems) => "[" + (elems map show mkString ", ") + "]"
	case JObj(bindings) =>
	val assocs = bindings map {
	case (key, value) => "\"" + key + "\": " + show(value)
	}
	"{" + (assocs mkString ", ") + "}"
	case JNum(num) => num.toString
	case JCurrency(num) => num.toString
	case JStr(str) => {
		if (str != null) 
		{

			var lines=str
					lines = lines.replaceAll("&quot;", "\"") 
					lines = lines.replaceAll("&apos;", "'") 
					lines = lines.replaceAll("&lt", "<") 
					lines = lines.replaceAll("&gt;", ">") 
					lines = lines.replaceAll("&amp;","&") 
					lines=lines.replace("\"", "")
					lines=lines.replace("\\", "/")


					 "\"" + lines + "\"" 


		}
		else { "\"" + str + "\"" }
	}
	case JBool(b) => b.toString
	case JNull => "null"
	}
  
  def get(json: JSON): Any = json match {
    case JSeq(elems)=> elems
    case JNum(num)=>num
    case JStr(str)=>str
  }



}


