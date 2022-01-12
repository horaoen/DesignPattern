namespace DesignPattern.Structural.Facade;

public class ShippingService
{
    public string ShipGift(PointsGift pointsGift)
    {
        Console.WriteLine(pointsGift.Name + "进入物流系统");
        string shipOrderNo = "123";
        return shipOrderNo;
    }
}