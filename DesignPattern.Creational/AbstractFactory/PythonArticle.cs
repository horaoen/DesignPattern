namespace DesignPattern.Creation.AbstractFactory;

public class PythonArticle : Article
{
    public override string Produce()
    {
        return "Python Article";
    }
}