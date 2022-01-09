namespace DesignPattern.Creation.AbstractFactory;

public class PythonCourseFactory : ICourseFactory
{
    public Video Video => new PythonVideo();
    public Article Article => new PythonArticle();
}