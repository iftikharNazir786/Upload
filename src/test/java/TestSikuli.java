
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.FindFailed;

import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSikuli {
        public static void main(String[] args) throws  FindFailed, InterruptedException, IOException    {

            WebDriverManager.chromedriver().setup();
            //WebDriverManager.firefoxdriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
		  	options.addArguments("--disable-popup-blocking");
		  	options.addArguments("--disable-extensions");
		  	options.addArguments();
		 	options.addArguments("--start-maximized");
		// 	options.addArguments("--start-fullscreen");

		 	
		  	WebDriver driver = new ChromeDriver(options);
		 	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    /*
		  	WebDriver driver = new FirefoxDriver();
*/
			try{
			driver.get("https://www.yelp.com/");
			String OS = System.getProperty("os.name");
			if(OS.contains("Window")) {
			 	String Projectpath1=System.getProperty("user.dir");
				System.out.println(Projectpath1);
				System.out.println(Projectpath1+"/upload/upload.exe");			
				ProcessBuilder pb = new ProcessBuilder(Projectpath1+"/upload/upload.exe", Projectpath1+"/upload/text.docx");
				Thread.sleep(5000);
				pb.start();
				Thread.sleep(15000);

			}
			else {
				Screen s = new Screen();
	    		System.out.println(System.getProperty("os.name"));
				System.out.println(System.getProperty("user.home"));
				System.out.println(System.getProperty("user.name"));
		        System.getProperties().list(System.out);
				String Projectpath=System.getProperty("user.dir");
		        System.out.println(Projectpath);
		        Pattern image1= new Pattern(Projectpath+"/Pattern/click.PNG");
		        Pattern image2= new Pattern(Projectpath+"/Pattern/Name.PNG");
		        Pattern image3= new Pattern(Projectpath+"/Pattern/fn.PNG");
		        Thread.sleep(60000);
		        s.click(image1);
		        Thread.sleep(60000);
		        s.type(image3, "Iftikhar");
	    				

			}
    	            				
    				
    				    				
                }
                catch(FindFailed e){
                        e.printStackTrace();
                }
        }

}