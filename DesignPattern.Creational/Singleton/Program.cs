using DesignPattern.Creation.Singleton;

var ts = new ThreadStart(ThreadEntry);
var thread1 = new Thread(ts) {Name = "Thread1"};
var thread2 = new Thread(ts) {Name = "Thread2"};
thread1.Start();
thread2.Start();
static void ThreadEntry()
{
    var singleton = LazySingleton.GetInstance();
    Console.WriteLine($"{Thread.CurrentThread.Name}: {singleton.GetHashCode()}");
}
