namespace DesignPattern.Creation.Singleton;

public class HungrySingleton
{
    private static readonly HungrySingleton HungrySingletonInstance = new HungrySingleton();

    private HungrySingleton()
    {
    }

    private static HungrySingleton GetInstance() => HungrySingletonInstance;
}