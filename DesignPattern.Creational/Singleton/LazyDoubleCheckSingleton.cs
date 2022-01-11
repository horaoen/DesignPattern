using System.Runtime.CompilerServices;

namespace DesignPattern.Creation.Singleton;

public class LazyDoubleCheckSingleton
{
    //private static volatile LazyDoubleCheckSingleton _lazyDoubleCheckSingleton = null;
    private static LazyDoubleCheckSingleton _lazyDoubleCheckSingleton = null;
    //[MethodImpl(MethodImplOptions.Synchronized)]
    public static LazyDoubleCheckSingleton GetInstance()
    {
        if (_lazyDoubleCheckSingleton == null)
        {
            lock (typeof(LazyDoubleCheckSingleton))
            {
                if (_lazyDoubleCheckSingleton == null)
                {
                    Interlocked.Exchange(ref _lazyDoubleCheckSingleton, new LazyDoubleCheckSingleton());
                }
            }
        }

        return _lazyDoubleCheckSingleton;
    }
    private LazyDoubleCheckSingleton()
    { 
    }
}