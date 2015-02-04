import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
  public static void main(String... args){

//    Format formatter = new SimpleDateFormat("dd-MMM-yy");
//    Date date = null;
//	try {
//		date = (Date) formatter.parseObject("29-Jan-02");
//	} catch (ParseException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//    System.out.println(date);
    
    
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date newdate = null;
	try {
		newdate = df.parse(df.format(new Date(new Long(1413964798000))));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(newdate);
  }
}
