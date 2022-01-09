using DesignPattern.Principle.DependenceInversion;
using Xunit;

namespace Tests.Principle;
public class DependenceInversionTest
{
    [Fact]
    public void StudyJavaCourse()
    {
        //Arrange
        var stuJavaCourse = new JavaCourse();
        var mockPerson = new Person();

        //Act
        var expected = "学Java";
        var actual = mockPerson.StudyCourse(stuJavaCourse);
        //Assert 
        Assert.Equal(expected, actual);
    }

    [Fact]
    public void StudyCSharpCourse()
    {
        //Arrange
        var studyCSharpCourse = new CSharpCourse();
        var mockPerson = new Person();

        //Act
        var expected = "学C#";
        var actual = mockPerson.StudyCourse(studyCSharpCourse);

        Assert.Equal(expected, actual);
    }
}