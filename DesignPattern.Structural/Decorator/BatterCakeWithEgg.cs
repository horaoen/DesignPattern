namespace DesignPattern.Structural.Decorator;

public class BatterCakeWithEgg : BatterCake
{
    public new string Desc => base.Desc + " 加一个鸡蛋";
    public new int Cost => base.Cost + 1;
}