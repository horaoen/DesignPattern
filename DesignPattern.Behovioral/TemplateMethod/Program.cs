using DesignPattern.Behavioral.TemplateMethod;

AbstractCourse course = new DesignPatternCourse();
course.MakeCourse();
Console.WriteLine("===================");
AbstractCourse courseEf  = new FrontEndCourse();
courseEf.MakeCourse();