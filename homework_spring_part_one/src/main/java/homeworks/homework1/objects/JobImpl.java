package homeworks.homework1.objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("job")
public class JobImpl implements Job{

    private String name;

    @Value("y-solutions")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("Организация: " + name);
    }
}
