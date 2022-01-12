using System.Reflection;

namespace DesignPattern.Creation.ProtoType;

public class Mail : ICloneable
{ 
    public string Name { get; set; }
    public string EmailAddress { get; set; }
    public string Content { get; set; }

    public Mail()
    {
        Console.WriteLine("Ctor");        
    }


    public object Clone()
    {
        //Type type = this.GetType();
        //object o = Activator.CreateInstance(type);
        //PropertyInfo[] propertyInfos = type.GetProperties();
        //foreach (PropertyInfo pi in propertyInfos)
        //{
        //    pi.SetValue(o, pi.GetValue(this));
        //}

        //return o ??= new object();
        //如果mail有引用类型字段需要单独浅拷贝或者像上面方式。
        var mail = (Mail)this.MemberwiseClone();
        return mail;
    }
}