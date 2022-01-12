//using DesignPattern.Structural.Facade;

//var pointsGift = new PointsGift("T恤");
//var giftExchangeService = new GiftExchangeService()
//{
//    QualifyService = new QualifyService(),
//    PointsPaymentService = new PointsPaymentService(),
//    ShippingService = new ShippingService()
//};

//giftExchangeService.GiftExchange(pointsGift);

//using DesignPattern.Structural.Decorator;

//var batterCake = new BatterCake();
//Console.WriteLine($"{batterCake.Desc} 售价：{batterCake.Cost}");
//var batterCakeWithEgg = new BatterCakeWithEgg();
//Console.WriteLine($"{batterCakeWithEgg.Desc} 售价：{batterCakeWithEgg.Cost}");
//var batterCakeWithEggSausage = new BatterCakeWithEggSausage();
//Console.WriteLine($"{batterCakeWithEggSausage.Desc} 售价：{batterCakeWithEggSausage.Cost}");

using DesignPattern.Structural.Decorator.v2;

AbstractBatterCake abstractBatterCake = new BatterCake();
abstractBatterCake = new EggDecorator(abstractBatterCake);
abstractBatterCake = new SausageDecorator(abstractBatterCake);
abstractBatterCake = new EggDecorator(abstractBatterCake);
Console.WriteLine($"{abstractBatterCake.Desc} 售价：{abstractBatterCake.Cost}");
