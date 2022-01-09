namespace DesignPattern.Creation.FactoryMethod;

public class PythonVideoFactory : VideoFactory
{
    public override Video GetVideo()
    {
        return new PythonVideo();
    }
}