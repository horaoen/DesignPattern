using DesignPattern.Structural.Adapter.ClassAdapter;

namespace DesignPattern.Structural.Adapter.ObjectAdapter;

public class Adapter : ITarget
{
    private readonly Adaptee _adaptee = new Adaptee();
    public void Request()
    {
       _adaptee.AdapteeRequest();  
    }
}