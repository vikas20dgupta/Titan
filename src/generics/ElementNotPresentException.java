package generics;

import org.apache.log4j.Logger;

public class ElementNotPresentException extends RuntimeException{
Logger l=Logger.getLogger(this.getClass().getName());
public ElementNotPresentException(String msg){
	l.error(msg);
}
}
