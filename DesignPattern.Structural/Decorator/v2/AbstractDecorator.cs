namespace DesignPattern.Structural.Decorator.v2;

public class AbstractDecorator : AbstractBatterCake
{
    private AbstractBatterCake AbstractBatterCake { get; init; }
    public override string Desc => AbstractBatterCake.Desc;
    public override int Cost => AbstractBatterCake.Cost;

    public AbstractDecorator(AbstractBatterCake abstractBatterCake)
    {
        this.AbstractBatterCake = abstractBatterCake;
    }
}