using System;

namespace DesignPattern.Principle.DependenceInversion;
public class Person
{
    //public void StudyJavaCourse()
    //{
    //    return "学Java";
    //}

    //public void StudyCSharpCourse()
    //{
    //    return "学C#";
    //}

    public string StudyCourse(ICourse course)
    {
        return course.StudyCourse();
    }
}