package generics;

import org.apache.log4j.Logger;

public class ElementPresentException extends RuntimeException{
	Logger l=Logger.getLogger(this.getClass().getName());
	public ElementPresentException(String msg){
		l.error(msg);
	}

}
