using System.Runtime.CompilerServices;

namespace DesignPattern.Creation.Singleton;

public class LazySingleton
{
    private static LazySingleton _lazySingleton = null;

    [MethodImpl(MethodImplOptions.Synchronized)]
    public static LazySingleton GetInstance()
    {
        return _lazySingleton ??= new LazySingleton();
    }
    private LazySingleton()
    { 
    }


}