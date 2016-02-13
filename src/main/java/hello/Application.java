package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"hello","Controller"})
public class Application {
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}