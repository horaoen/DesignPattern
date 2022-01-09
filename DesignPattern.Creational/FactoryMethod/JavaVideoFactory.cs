namespace DesignPattern.Creation.FactoryMethod
{
    public class JavaVideoFactory : VideoFactory
    {
        public override Video GetVideo()
        {
            return new JavaVideo();
        }
    }
}
