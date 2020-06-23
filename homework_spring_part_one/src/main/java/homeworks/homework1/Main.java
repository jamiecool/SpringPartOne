package homeworks.homework1;

import homeworks.homework1.objects.Job;
import homeworks.homework1.objects.JobImpl;
import homeworks.homework1.objects.Person;
import homeworks.homework1.objects.PersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("homeworks.homework1.objects")
public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(Main.class);
        Person person = app.getBean("person", PersonImpl.class);
        person.whereI_Job();

        System.out.println();

        Job job = app.getBean("job", JobImpl.class);
        job.print();
    }
}
