package TimerTask;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class TimerClose implements Runnable {
	private  static long longtime ;
	public static long getLongtime() {
		return longtime;
	}
	public static String getPath() {
		return path;
	}

	//private static String command = "cmd /E:ON /c call  ";
    private static  String path = "";
    private static int sec = 0;
    
    //构造方法     传入参数     将图形界面拿到的时间值赋给longtime
    public TimerClose(Long time,String path){
    	this.longtime = time;
    	this.path = path;
    }
   
/*    START D:\Program Files\Thunder Network\Thunder\Program\Thunder.exe */
    private static void process() {
        try {
        	path = path.replaceAll("\\\\","\\\\\\\\");
            Process process = Runtime.getRuntime().exec("cmd /c start "+"\""+"\"  \""+ path+"\"");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
    	try {
    		Thread.sleep(longtime);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	process();
    }
}
