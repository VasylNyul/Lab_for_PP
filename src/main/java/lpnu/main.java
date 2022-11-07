package lpnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class main {
    public static void main(final String[] args) {
//        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(main.class, args);
    }
}
