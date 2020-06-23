package lessons.lesson1;

import lessons.lesson1.object.Camera;
import lessons.lesson1.spring.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera = context.getBean("camera",Camera.class);
        camera.doPhotograph();
    }

}
