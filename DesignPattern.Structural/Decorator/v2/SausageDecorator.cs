namespace DesignPattern.Structural.Decorator.v2;

public class SausageDecorator : AbstractDecorator
{
    public SausageDecorator(AbstractBatterCake abstractBatterCake) : base(abstractBatterCake)
    {
    }

    public override string Desc => base.Desc + " 加一根香肠";
    public override int Cost => base.Cost + 2;
}
  
