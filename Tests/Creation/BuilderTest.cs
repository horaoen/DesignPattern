using Xunit;

namespace Tests.Creation;

public class BuilderTest
{
    public record Course(string CourseName, string CourseVideo, string CourseArticle, string CoursePowerPoint,
        string CourseQuestionAndAnswer);
    [Fact]
    public void Builder()
    {
        //Arrange 
        var mockCourse = new DesignPattern.Creation.Builder.V2.Course.CourseBuilder()
            .BuildCourseName("Java")
            .BuildCourseVideo("java video")
            .BuildCourseArticle("java article")
            .BuildCoursePowerPoint("java pt")
            .BuildCourseQuestionAndAnswer("java QA").Build();

        var mockTestCourse = new Course("Java", "java video", "java article", "java pt", "java QA");
        //Act
        var actual = mockCourse.ToString();
        var expected = mockTestCourse.ToString();

        //Assert
        Assert.Equal(expected, actual);

    }
}