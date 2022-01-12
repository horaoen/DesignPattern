namespace DesignPattern.Creation.ProtoType;

public class Program
{
    public static void Main(string[] args)
    {
        Mail mail = new Mail() {Content = "初始化模板"};
        Console.WriteLine("初始化Mail");
        for (int i = 0; i < 10; i++)
        {
            var mailTemp = (Mail) mail.Clone();
            mailTemp.Name = "姓名" + i;
            mailTemp.EmailAddress = "地址";
            mailTemp.Content = "哈哈"; 
            MailUtil.SendMail(mailTemp);
        }
        MailUtil.SaveOriginMailRecord(mail);
    }
}