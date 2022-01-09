    namespace DesignPattern.Creation.AbstractFactory;

    public class JavaCourseFactory : ICourseFactory
    {
        public Video Video => new JavaVideo();

        public Article Article => new JavaArticle();
    }