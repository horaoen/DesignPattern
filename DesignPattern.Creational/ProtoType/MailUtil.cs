namespace DesignPattern.Creation.ProtoType;

public class MailUtil
{
    public static void SendMail(Mail mail)
    {
        string content = $"向{mail.Name}同学，邮件地址：{mail.EmailAddress},邮件内容：{mail.Content}, 发送邮件成功";
        Console.WriteLine(content);
    }

    public static void SaveOriginMailRecord(Mail mail)
    {
        Console.WriteLine($"存储originMail记录，originMail：{mail.Content}");
    }
}