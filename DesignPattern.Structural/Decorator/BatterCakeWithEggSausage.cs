using System.Runtime.InteropServices.ComTypes;

namespace DesignPattern.Structural.Decorator;

public class BatterCakeWithEggSausage : BatterCakeWithEgg
{
    public new string Desc => base.Desc + " 加一根香肠";
    public new int Cost => base.Cost + 2;
}