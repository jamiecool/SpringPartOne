package lessons.lesson1.spring;

import lessons.lesson1.object.Camera;
import lessons.lesson1.object.CameraImpl;
import lessons.lesson1.object.CameraRoll;
import lessons.lesson1.object.ColorCameraRoll;
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

