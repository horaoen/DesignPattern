namespace DesignPattern.Structural.Facade;

public class GiftExchangeService
{
    public QualifyService? QualifyService { get; set; }
    public PointsPaymentService? PointsPaymentService { get; set; }
    public ShippingService? ShippingService { get; set; }

    public void GiftExchange(PointsGift pointsGift)
    {
        if (QualifyService != null && QualifyService.IsAvaialable(pointsGift))
        {
            if (PointsPaymentService != null && PointsPaymentService.Pay(pointsGift))
            {
                string orderNo = "";
                if (ShippingService != null)
                {
                    orderNo = ShippingService.ShipGift(pointsGift);
                }

                Console.WriteLine(orderNo);
            }
        }
    }
}