namespace DesignPattern.Creation.SimpleFactory;

public class VideoFactory
{
    public Video GetVideo(Type videoType)
    {
        return Activator.CreateInstance(videoType) as Video;
    }
}