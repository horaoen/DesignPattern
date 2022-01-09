namespace DesignPattern.Creation.Builder;

public class CourseActualBuilder : CourseBuilder
{
    private Course Course { get; }

    public CourseActualBuilder()
    {
        Course = new Course();
    }

    public override void BuildCourseName(string courseName)
    {
        Course.CourseName = courseName;
    }

    public override void BuildCourseVideo(string courseVideo)
    {
        Course.CourseVideo = courseVideo;
    }

    public override void BuildCourseArticle(string courseArticle)
    {
        Course.CourseArticle = courseArticle;
    }

    public override void BuildCoursePowerPoint(string coursePowerPoint)
    {
        Course.CoursePowerPoint = coursePowerPoint;
    }

    public override void BuildCourseQuestionAndAnswer(string courseQuestionAndAnswer)
    {
        Course.CourseQuestionAndAnswer = courseQuestionAndAnswer;
    }

    public override Course MakeCourse()
    {
        return Course;
    }
}