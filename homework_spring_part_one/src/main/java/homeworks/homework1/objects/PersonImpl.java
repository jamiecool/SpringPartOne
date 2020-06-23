package homeworks.homework1.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class PersonImpl implements Person{

    @Value("Pavel")
    private String name;

    @Autowired
    @Qualifier("job")
    private JobImpl jobName;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void whereI_Job() {
        System.out.println("Я работаю в компании: " + jobName.getName());
        System.out.println("Меня зовут: " + name);
    }
}
