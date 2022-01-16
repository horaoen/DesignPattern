namespace DesignPattern.Behavioral.TemplateMethod;

public class FrontEndCourse : AbstractCourse
{
    protected override void PackageCourse()
    {
        Console.WriteLine("提供前端课程源码");
        Console.WriteLine("提供多媒体素材");
    }

    protected override bool NeedWriteArticle()
    {
        return true;
    }
}