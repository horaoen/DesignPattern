using System.Runtime.CompilerServices;

namespace DesignPattern.Creation.Builder.V2;

public record Course
{
    public string CourseName { get; set; }
    public string CourseVideo { get; set; }
    public string CourseArticle { get; set; }
    public string CoursePowerPoint { get; set; }
    public string CourseQuestionAndAnswer { get; set; }

    public Course(CourseBuilder courseBuilder)
    {
        CourseName = courseBuilder.CourseName;
        CourseVideo = courseBuilder.CourseVideo;
        CourseArticle = courseBuilder.CourseArticle;
        CoursePowerPoint = courseBuilder.CoursePowerPoint;
        CourseQuestionAndAnswer = courseBuilder.CourseQuestionAndAnswer;
    }

    public class CourseBuilder
    {
        internal string CourseName { get; set; }

        internal string CourseVideo { get; set; }
        internal string CourseArticle { get; set; }
        internal string CoursePowerPoint { get; set; }
        internal string CourseQuestionAndAnswer { get; set; }

        public CourseBuilder BuildCourseName(string courseName)
        {
            CourseName = courseName;
            return this;
        }

        public CourseBuilder BuildCourseVideo(string courseVideo)
        {
            CourseVideo = courseVideo;
            return this;
        }

        public CourseBuilder BuildCourseArticle(string courseArticle)
        {
            CourseArticle = courseArticle;
            return this;
        }

        public CourseBuilder BuildCoursePowerPoint(string coursePowerPoint)
        {
            CoursePowerPoint = coursePowerPoint;
            return this;
        }

        public CourseBuilder BuildCourseQuestionAndAnswer(string courseQuestionAndAnswer)
        {
            CourseQuestionAndAnswer = courseQuestionAndAnswer;
            return this;
        }

        public Course Build()
        {
            return new Course(this);
        }
    }
}