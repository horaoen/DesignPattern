namespace DesignPattern.Structural.Decorator;

public class BatterCakeWithEgg : BatterCake
{
    public override string Desc => base.Desc + " 加一个鸡蛋";
    public override int Cost => base.Cost + 1;
}