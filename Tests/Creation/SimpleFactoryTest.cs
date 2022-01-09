using DesignPattern.Creation.SimpleFactory;
using Xunit;

namespace Tests.Creation;

public class SimpleFactoryTest
{
    [Fact]
    public void SimpleFactory()
    {
        //Arrange
        var stuVideoFactory = new VideoFactory();
        var mockJavaVideo = stuVideoFactory.GetVideo(typeof(JavaVideo));
        var mockPythonVideo = stuVideoFactory.GetVideo(typeof(PythonVideo));

        //Act
        var actualPython = mockPythonVideo.Produce();
        var actualJava = mockJavaVideo.Produce();

        //Assert
        Assert.Equal("Java", actualJava);
        Assert.Equal("Python", actualPython);

    }
}