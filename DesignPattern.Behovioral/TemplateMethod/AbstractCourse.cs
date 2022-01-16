namespace DesignPattern.Behavioral.TemplateMethod;

public abstract class AbstractCourse
{
    public void MakeCourse()
    {
        MakePowerPoint();
        MakeVideo();
        if(NeedWriteArticle())WriteArticle();
        PackageCourse();
    }

    private void MakePowerPoint()
    {
        Console.WriteLine("制作ppt");
    }

    private void MakeVideo()
    {
        Console.WriteLine("制作视频");
    }

    private void WriteArticle()
    {
        Console.WriteLine("编写手记");
    }

    protected virtual bool NeedWriteArticle()
    {
        return false;
    }

    protected abstract void PackageCourse();

}