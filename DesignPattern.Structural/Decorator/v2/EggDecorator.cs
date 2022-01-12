namespace DesignPattern.Structural.Decorator.v2;

public class EggDecorator : AbstractDecorator
{
    public EggDecorator(AbstractBatterCake abstractBatterCake) : base(abstractBatterCake)
    {
    }

    public override int Cost => base.Cost + 1;
    public override string Desc => base.Desc + " 加鸡蛋";

}