using System.Runtime.InteropServices.ComTypes;

namespace DesignPattern.Structural.Decorator;

public class BatterCakeWithEggSausage : BatterCakeWithEgg
{
    public override string Desc => base.Desc + " 加一根香肠";
    public override int Cost => base.Cost + 2;
}