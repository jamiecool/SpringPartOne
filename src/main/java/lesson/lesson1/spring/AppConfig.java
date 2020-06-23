package lesson.lesson1.spring;

import lesson.lesson1.object.Camera;
import lesson.lesson1.object.CameraImpl;
import lesson.lesson1.object.CameraRoll;
import lesson.lesson1.object.ColorCameraRoll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll() ;
    }

    @Bean(name="camera")
    public Camera camera(CameraRoll cameraRoll){
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}

