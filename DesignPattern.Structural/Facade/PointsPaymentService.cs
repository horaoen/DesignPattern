namespace DesignPattern.Structural.Facade;

public class PointsPaymentService
{
    public bool Pay(PointsGift pointsGift)
    {
        Console.WriteLine($"支付{pointsGift.Name} 积分成功");
        return true;
    }
}