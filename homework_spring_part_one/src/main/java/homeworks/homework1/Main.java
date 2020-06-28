package homeworks.homework1;

import homeworks.homework1.objects.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("homeworks.homework1.objects")
public class Main {

    @Bean(name="manager")
    public Manager manager(){
        Manager m = new ManagerImpl(new PersonImpl("vasili"));
        return m;
    }


    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(Main.class);
        Person person = app.getBean("person", PersonImpl.class);
        person.whereI_Job();

        System.out.println();

        Job job = app.getBean("job", JobImpl.class);
        job.print();

        Job job_new = app.getBean("job_new", JobImpl_new.class);
        job_new.print();

        JobImpl jobImpl = (JobImpl) app.getBean("job");
        jobImpl.print();

        Manager m = app.getBean("manager", Manager.class);
        m.getPerson().toString();
    }
}
