package homeworks.homework1.objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("job_new")
public class JobImpl_new implements Job{

    private String name;

    public JobImpl_new(@Value("diasoft") String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Diasoft: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
