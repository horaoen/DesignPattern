namespace DesignPattern.Structural.FlyWeight;

public class Manager : IEmployee
{
    private string Department { get; init; }
    public string? ReportContent { set; get; }
    public void Report()
    {
        Console.WriteLine(ReportContent);    
    }

    public Manager(string department)
    {
        Department = department;

    }
}