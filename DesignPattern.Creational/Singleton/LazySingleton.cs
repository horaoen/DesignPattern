namespace DesignPattern.Creation.Singleton;

public class LazySingleton
{
    private static LazySingleton _lazySingleton;
    public static LazySingleton Instance
    {
        get { return _lazySingleton ??= new LazySingleton(); }
        set => _lazySingleton = value;
    }

    private LazySingleton()
    { 
    }


}