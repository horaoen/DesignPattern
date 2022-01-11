namespace DesignPattern.Creation.Singleton;

public class ThreadLocalInstance
{
    private static readonly ThreadLocal<ThreadLocalInstance> Instance =
        new ThreadLocal<ThreadLocalInstance>(() => new ThreadLocalInstance(), true);

    private ThreadLocalInstance()
    {
    }

    public static ThreadLocalInstance GetInstance()
    {
        return Instance.Value;
    }
}