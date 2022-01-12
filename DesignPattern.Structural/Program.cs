using DesignPattern.Structural.Facade;

var pointsGift = new PointsGift("T恤");
var giftExchangeService = new GiftExchangeService()
{
    QualifyService = new QualifyService(),
    PointsPaymentService = new PointsPaymentService(),
    ShippingService = new ShippingService()
};

giftExchangeService.GiftExchange(pointsGift);
