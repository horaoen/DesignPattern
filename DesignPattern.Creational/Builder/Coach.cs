namespace DesignPattern.Creation.Builder;

public class Coach
{
    private CourseBuilder CourseBuilder { get; }

    public Coach()
    {
        CourseBuilder = new CourseActualBuilder();
    }

    public Course MakeCourse(
        string courseName,
        string courseVideo,
        string courseArticle,
        string coursePowerPoint,
        string courseQuestionAdnAnswer)
    {
        CourseBuilder.BuildCourseName(courseName);
        CourseBuilder.BuildCourseVideo(courseVideo);
        CourseBuilder.BuildCourseArticle(courseArticle);
        CourseBuilder.BuildCoursePowerPoint(coursePowerPoint);
        CourseBuilder.BuildCourseQuestionAndAnswer(courseQuestionAdnAnswer);
        return CourseBuilder.MakeCourse();
    }
}