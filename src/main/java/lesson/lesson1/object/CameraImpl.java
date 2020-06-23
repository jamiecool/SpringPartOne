package lesson.lesson1.object;

public class CameraImpl implements Camera{
    private CameraRoll cameraRoll;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }
    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public void doPhotograph(){
        System.out.println("Щелк!");
        cameraRoll.processing();
    }
}

