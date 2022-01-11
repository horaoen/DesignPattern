namespace DesignPattern.Creation.Singleton;

public class StaticInnerClassSingleton
{
    private static class InnerClass
    {
        public static readonly StaticInnerClassSingleton StaticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton GetInstance()
    {
        return InnerClass.StaticInnerClassSingleton;
    }

    private StaticInnerClassSingleton()
    {
    }
}