using System.Collections;

namespace DesignPattern.Structural.FlyWeight;

public class EmployeeFactory
{
    private static readonly Hashtable EmployeeTable = new Hashtable();

    public static IEmployee GetEmployee(string department)
    {
        var manager = EmployeeTable[department] as Manager;
        if (manager == null)
        {
            manager = new Manager(department);
            EmployeeTable[department] = manager;
            Console.WriteLine("创建部门经理：" + department);
            manager.ReportContent = "汇报内容为：";
            Console.WriteLine($"创建部门经理: {department}");
        }

        return manager;
    }
}