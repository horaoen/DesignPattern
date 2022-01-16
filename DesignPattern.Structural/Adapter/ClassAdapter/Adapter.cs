namespace DesignPattern.Structural.Adapter.ClassAdapter;

public class Adapter : Adaptee, ITarget
{
    public void Request()
    {
        base.AdapteeRequest();
    }
}