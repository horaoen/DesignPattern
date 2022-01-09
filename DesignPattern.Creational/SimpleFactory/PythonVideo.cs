namespace DesignPattern.Creation.SimpleFactory;

public class PythonVideo : Video
{
    public override string Produce()
    {
        return "Python";
    }
}