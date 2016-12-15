package generics;

import org.apache.log4j.Logger;



public class InvalidActionException extends RuntimeException{
	
	public InvalidActionException(String msg){
		Logger l=Logger.getLogger("InvalidActionException");
		l.info(msg);
		
	}
	}
