namespace DesignPattern.Behavioral.TemplateMethod;

public class DesignPatternCourse : AbstractCourse
{
    protected override void PackageCourse()
    {
        Console.WriteLine("提供课程源码");
    }
}