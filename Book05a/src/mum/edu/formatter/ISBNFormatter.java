package mum.edu.formatter;

import java.util.Locale;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import mum.edu.domain.ISBNumber;

public class ISBNFormatter implements Formatter<ISBNumber> {

	public ISBNFormatter() {
        System.out.println("ISBNFormatter() =====");

	}
	
	  public String print(ISBNumber isbn, Locale locale) {
	       System.out.println("ISBNFormatter PRINT");

    return isbn.getStart() + "-" +
	    		isbn.getMiddle() + "-" + isbn.getEnd();
	  }

	  public ISBNumber parse(String source, Locale locale)
	      throws ParseException {
	       System.out.println("ISBNFormatter PARSE");

	    int start = Integer.parseInt(source.substring(0, 3));
	    int middle = Integer.parseInt(source.substring(4, 6));
	    int end = Integer.parseInt(source.substring(7, 9));
	    return new ISBNumber(start, middle, end);
	  }
	}