namespace DesignPattern.Structural.Adapter.ClassAdapter;

public class ConcreteTarget : ITarget
{
    public void Request()
    {
        throw new NotImplementedException("ConcreteTarget目标方法");
    }
}