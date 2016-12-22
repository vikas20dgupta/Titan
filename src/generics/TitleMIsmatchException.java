package generics;
import org.apache.log4j.Logger;

public class TitleMIsmatchException extends RuntimeException{
	Logger l=Logger.getLogger(this.getClass().getName());
	public TitleMIsmatchException(String msg){
		l.error(msg);
	}
	
}


	


	