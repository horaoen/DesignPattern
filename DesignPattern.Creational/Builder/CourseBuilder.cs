namespace DesignPattern.Creation.Builder;

public abstract class CourseBuilder
{
    public abstract void BuildCourseName(string courseName);
    public abstract void BuildCourseVideo(string courseVideo);
    public abstract void BuildCourseArticle(string courseArticle);
    public abstract void BuildCoursePowerPoint(string coursePowerPoint);
    public abstract void BuildCourseQuestionAndAnswer(string courseQuestionAndAnswer);
    public abstract Course MakeCourse();
}