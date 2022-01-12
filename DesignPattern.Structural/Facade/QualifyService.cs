namespace DesignPattern.Structural.Facade;

public class QualifyService
{
    public bool IsAvaialable(PointsGift pointGift)
    {
        Console.WriteLine($"校验{pointGift.Name} 积分资格通过，库存通过");
        return true;
    }
}